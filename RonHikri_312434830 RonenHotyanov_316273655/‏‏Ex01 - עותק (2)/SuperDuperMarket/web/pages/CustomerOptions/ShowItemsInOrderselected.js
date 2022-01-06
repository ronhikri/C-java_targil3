var User_listOrderItems = buildUrlWithContextPath("SowItemsConclusionOrdr");

$(function () {
    $("#ShowPrivateOrders").click(function () {

        var iteminorder=$("#OrderSelect").val();


        $.ajax({
            method: 'POST',
            data: {"SelectOrder":iteminorder},
            url: User_listOrderItems,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                //ajContent..
                console.log("Failed to get ajax response");
            },
            success: function (response)
            {
               refreshupdateTable(response);
            }
        })

    })
});
function  refreshupdateTable(resTable)
{
    var Ti=document.getElementById('DataItemsOfOrder');
    while (Ti.rows.length > 1) {
        Ti.deleteRow(1);
    }
    $.each(resTable||[],function (index,reTable) {
        $('<tr>' +
            '<td>' + reTable.idi + '</td>' +
            '<td>' + reTable.namei+ '</td>' +
            '<td>'+reTable.howToBuy+'</td>'+
            '<td>'+reTable.storeThatSold+'</td>'+
            '<td>'+reTable.oount+'</td>'+
            '<td>'+reTable.priceunit+'</td>'+
            '<td>'+reTable.SumPrice+'</td>'+
            '<td>'+reTable.DoItemSoldDiscount+'</td>'+
            '</tr>').appendTo($("#DataItemsOfOrder"));
    })
}
