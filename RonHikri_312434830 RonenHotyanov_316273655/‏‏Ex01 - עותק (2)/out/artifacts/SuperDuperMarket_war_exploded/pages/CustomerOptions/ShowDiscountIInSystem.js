var USER_LIST_URLDisc = buildUrlWithContextPath("ServetecreateDisc");
var UsrListNamesDiscs=buildUrlWithContextPath("ServeteNameCreateDiscont");
$(function() {
    $("#ShowDiscounts").click(function () {

        ajaxListItemsDiscs();
        ajaxListItemsDiscs2();
        ajaxListItemsDiscs3();



    })
})
function ajaxListItemsDiscs()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: USER_LIST_URLDisc,
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (responsedis) {
            refreshtableZoneInfoDiscs(responsedis);
        }
    })
}
function refreshtableZoneInfoDiscs(resDiscs)
{
    var D=document.getElementById('DataDiscount');
    while (D.rows.length > 1) {
        D.deleteRow(1);
    }
    $.each(resDiscs||[],function (index,resDisc) {
        $('<tr>' +
            '<td>' + resDisc.nameofDiscount + '</td>' +
            '<td>' + resDisc.idOfDisc+ '</td>' +
            '<td>'+resDisc.nameItemDiscount+'</td>'+
            '<td>'+resDisc.quantityitemDisc+'</td>'+
            '<td>'+resDisc.OperationDiscount+'</td>'+
            '</tr>').appendTo($("#DataDiscount"));
    })

}
function ajaxListItemsDiscs2()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: UsrListNamesDiscs,
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (responsedis) {
            refreshNamesDiscs(responsedis);
        }
    })

}
function refreshNamesDiscs(ress)
{
    var n = document.getElementById("namedis");
    while (n.length > 0) {
        n.remove(n.length - 1);
    }

    $.each(ress || [],function (index,responedic) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x=responedic.toString();
        $("#namedis").append($('<option>').val(x).text(x));



    })
}
function ajaxListItemsDiscs3()
{
    document.getElementById("adddiscount")["disabled"]=false;
}
