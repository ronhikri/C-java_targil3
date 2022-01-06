var USER_LIST_URLselectItmsOrdStore = buildUrlWithContextPath("ShowItemsOrderInStore");

$(function () {
    $("#seletOrderInStoreClick").click(function () {

        var ordi = $("#OrdersSelecting").val();
        $.ajax({
            method: 'POST',
            data: {"selectOrderinStore": ordi},
            url: USER_LIST_URLselectItmsOrdStore,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {

                //ajContent..
                console.log("Failed to get ajax response");
            },
            success:function (res)
            {
                refreshtableitems(res);

            }

        })
    })
})
function refreshtableitems(resItemsOrders)
{
    var itord=document.getElementById('itemsOrd');
    while (itord.length>1)
    {
        itord.deleteRow(1);
    }
    $.each(resItemsOrders||[],function (index,responitem) {
        $('<tr>' +
            '<td>' + responitem.idi + '</td>' +
            '<td>' + responitem.namei+ '</td>' +
            '<td>'+responitem.howToBuy+'</td>'+
            '<td>'+responitem.storeThatSold+'</td>'+
            '<td>'+responitem.oount+'</td>'+
            '<td>'+responitem.priceunit+'</td>'+
            '<td>'+responitem.SumPrice+'</td>'+
            '<td>'+responitem.DoItemSoldDiscount+'</td>'+
            '</tr>').appendTo($("#itemsOrd"));
    })
    document.getElementById("selectStoreClick")["disabled"] = false;
    document.getElementById("seletOrderInStoreClick")["disabled"] = true;
}