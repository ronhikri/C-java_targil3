var UrlBringmeOrders=buildUrlWithContextPath("BringmeOrdersInStoreSelect");
var UrlBringToTableOrders=buildUrlWithContextPath("ShowOrdrerInStore");
$(function() {
    $("#selectStoreClick").click(function () {
        var ar = $("#StoresSelecting").val();
        ajaOrders(ar);
        ajaxTableOrders(ar);
        disabledbuttonStore();
    })
});


        function ajaOrders(ar) {
            $.ajax({
                method: 'POST',
                data: {"StoreSelectBring": ar},
                url: UrlBringmeOrders,
                dataType:'json',
                timeout: 5000,
                error: function e() {
                    console.log("no success");
                },
                success: function (responsenameorders) {
                    refreshtableZoneInforders(responsenameorders);
                }
            })
        }


function  refreshtableZoneInforders(responsenameprders)
{
    var ork = document.getElementById("OrdersSelecting");
    while (ork.length > 0) {
        ork.remove(ork.length - 1);
    }

    $.each(responsenameprders || [],function (index,resord) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x=resord;
        $("#OrdersSelecting").append($('<option>').val(x).text(x));



    })

}
function ajaxTableOrders(ar)
{
    $.ajax({
        method: 'POST',
        data: {"StoreSelectBring": ar},
        url: UrlBringToTableOrders,
        dataType:'json',
        timeout: 5000,
        error: function e() {
            console.log("no success");
        },
        success: function (responsetable) {
            refreshtableZoneInforderstable(responsetable);
        }
    })
}
function  refreshtableZoneInforderstable(responstable)
{
    var DT=document.getElementById('DataOfOrder');
    while (DT.rows.length > 1) {
        DT.deleteRow(1);
    }
    $.each(responstable ||[],function (index,resontable){
        $('<tr>'+
            '<td>'+resontable.idOrd+'</td>'+
            '<td>'+resontable.date+'</td>'+
            '<td>'+resontable.nameCust+'</td>'+
            '<td>'+resontable.cordinataX+'</td>'+
            '<td>'+resontable.CordinataY+'</td>'+
            '<td>'+resontable.countItems+'</td>'+
            '<td>'+resontable.SumPriceItems+'</td>'+
            '<td>'+resontable.priceSending+'</td>'+
            '<td>'+resontable.costOrder+'</td>'+
            '</tr>').appendTo($("#DataOfOrder"));


    })
}
function disabledbuttonStore()
{
    document.getElementById("selectStoreClick")["disabled"] = true;
    document.getElementById("seletOrderInStoreClick")["disabled"] = false;
}
