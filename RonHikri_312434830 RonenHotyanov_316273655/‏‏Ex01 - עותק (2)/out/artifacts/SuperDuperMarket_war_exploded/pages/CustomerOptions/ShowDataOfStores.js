var USER_LIST_URL = buildUrlWithContextPath("servetIdAndNameStores");
var USER_LIST_URLali=buildUrlWithContextPath("servetShowDataStores");
$(function() {
    $("#btnDataOfStore").click(function () {
    ajaxListStores();
    ajaxListStores2();
    ajaxListStores3();

})
});
function ajaxListStores()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: USER_LIST_URL,
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (response) {
            refreshtableZoneInfocomboxStores(response);
        }
    })
}
function  refreshtableZoneInfocomboxStores(res) {
    var Y = document.getElementById('idStoress');
    while (Y.length > 0) {
        Y.remove(Y.length - 1);
    }

    $.each(res || [],function (index,responeitem) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x=responeitem.toString();
        $('#idStoress').append($('<option>').val(x).text(x));



    })
}
function ajaxListStores2()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: USER_LIST_URLali,
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (response) {
            refreshtableZoneInfoItemsk2(response);
        }
    })
}
function refreshtableZoneInfoItemsk2(res)
{
    var tb = document.getElementById('ss');
    while (tb.rows.length > 1) {
        tb.deleteRow(1);
    }
    $.each(res ||[],function (index,resstore){
        $('<tr>'+
            '<td>'+resstore.idOfStore+'</td>'+
            '<td>'+resstore.nameStore+'</td>'+
            '<td>'+resstore.Cordinatax+'</td>'+
            '<td>'+resstore.Cordinatay+'</td>'+
            '<td>'+resstore.Ditance+'</td>'+
            '<td>'+resstore.ppk+'</td>'+
            '<td>'+resstore.priceSend+'</td>'+
            '<td>'+resstore.amountKindsItems+'</td>'+
            '<td>'+resstore.sumPrices+'</td>'+
            '</tr>').appendTo($("#ss"));


    })

}
function ajaxListStores3() {
    var x=window.typeOrder;
    if(x===1)
    {
        document.getElementById("bthAddStore")["disabled"]=false;
    }
}
