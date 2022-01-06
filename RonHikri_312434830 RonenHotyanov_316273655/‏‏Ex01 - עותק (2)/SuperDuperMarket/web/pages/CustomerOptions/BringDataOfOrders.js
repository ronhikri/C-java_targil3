
var USER_LIST_URLOrders=buildUrlWithContextPath("ShowSelectOrders");
var UserlisstTableOrders=buildUrlWithContextPath("ServetShowOrders");


$(function() {
    setInterval(ajaxListOrders,2000);
    setInterval(ajaListTableOrders,2000);
});
function ajaxListOrders()
{
        // var formData = new FormData();
        $.ajax({
            method:'POST',
            ///  data: formData,
            url: USER_LIST_URLOrders,
            dataType:'json',
            timeout: 2000,
            error: function (e) {
                //ajContent..
                console.log("Failed to get ajax response");
            },

            success: function (response) {
                refreshComboxZoneInfoPOrders(response);
            }
        })

}
function refreshComboxZoneInfoPOrders(resOrders)
{
    var ordi=document.getElementById("OrderSelect")
    while (ordi.length>0)
    {
        ordi.remove(ordi.length-1);
    }
    $.each(resOrders || [],function (index,resord)
    {
        var or=resord;
        $('#OrderSelect').append($('<option>').val(or).text(or));

    })
}
function ajaListTableOrders()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: UserlisstTableOrders,
        dataType:'json',
        timeout: 2000,
        error: function (e) {
            //ajContent..
            console.log("Failed to get ajax response");
        },

        success: function (response) {
            refreshTableDataOrders(response);
        }
    })
}
function  refreshTableDataOrders(resTaOrds)
{
    var orDa=document.getElementById('DataOfOrders');
    while (orDa.rows.length > 1) {
        orDa.deleteRow(1);
    }
    $.each(resTaOrds||[],function (index,resTaOrd) {
        $('<tr>' +
            '<td>' +resTaOrd.idorder + '</td>' +
           '<td>'+resTaOrd.Date+'</td>'+
            '<td>'+resTaOrd.CordinataX+'</td>'+
            '<td>'+resTaOrd.CordinataY+'</td>'+
            '<td>'+resTaOrd.SumStores+'</td>'+
            '<td>'+resTaOrd.SumCountItems+'</td>'+
            '<td>'+resTaOrd.sumPriceItems+'</td>'+
            '<td>'+resTaOrd.sumSending+'</td>'+
            '<td>'+resTaOrd.CostSumOrder+'</td>'+
            '</tr>').appendTo($("#DataOfOrders"));
    })
}
