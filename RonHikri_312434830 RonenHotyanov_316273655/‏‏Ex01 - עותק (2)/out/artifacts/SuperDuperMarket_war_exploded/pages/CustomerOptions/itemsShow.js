var USER_LIST_URLitem = buildUrlWithContextPath("itemsNameAndIdServet");
var USER_LIST_URLaliitem=buildUrlWithContextPath("ShowDataItemsServet");
$(function() {
    $("#bthDataOfItem").click(function () {
       ajaxListItems();
       ajaxListItems2();
        ajaxListItems3();

    })
});
function ajaxListItems()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: USER_LIST_URLitem,
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (responsekk) {
            refreshtableZoneInfoItemscom(responsekk);
        }
    })
}
function refreshtableZoneInfoItemscom(reskk) {
    var Y = document.getElementById("idItem");
    while (Y.length > 0) {
        Y.remove(Y.length - 1);
    }

    $.each(reskk || [],function (index,responeitem) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x=responeitem.toString();
        $('#idItem').append($('<option>').val(x).text(x));



    })
}
function ajaxListItems2()
{
    var x=$("#idStores").val();
    $.ajax({
        method:'POST',
        data: {"idOfStored":x},
        url: USER_LIST_URLaliitem,
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (responsett) {
            refreshtableZoneInfoItems2(responsett);
        }
    })
}
function refreshtableZoneInfoItems2(restt)
{
    var y=document.getElementById('tt');
    while (y.rows.length > 1) {
        y.deleteRow(1);
    }
    $.each(restt ||[],function (index,resttin) {
        $('<tr>' +
            '<td>' + resttin.idofItem + '</td>' +
            '<td>' + resttin.idofstoreofitem+ '</td>' +
            '<td>'+resttin.nameStoreOfItem+'</td>'+
            '<td>'+resttin.nameitem+'</td>'+
            '<td>'+resttin.howtobuy+'</td>'+
            '<td>'+resttin.priceUnitItem+'</td>'+
            '</tr>').appendTo($("#tt"));
    })
}
function ajaxListItems3()
{
    document.getElementById("AddItemToOrder")["disabled"]=false;
}
