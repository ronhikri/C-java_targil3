var USER_LIST_URL = buildUrlWithContextPath("servetitemssystem");
$(function() {
    setInterval(ajaxListitems,5000);

});
function ajaxListitems()
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
            refreshtableZoneInfoItems(response);
        }
    })
}
function refreshtableZoneInfoItems(res)
{
    var tb = document.getElementById('dataitems');
    while (tb.rows.length > 1) {
        tb.deleteRow(1);
    }
    $.each(res ||[],function (index,resInfoItem){
        $('<tr>'+
            '<td>'+resInfoItem.idofItem+'</td>'+
            '<td>'+resInfoItem.nameitem+'</td>'+
            '<td>'+resInfoItem.buyitem+'</td>'+
            '<td>'+resInfoItem.countitemsStores+'</td>'+
            '<td>'+resInfoItem.avgpriceofitem+'</td>'+
            '<td>'+resInfoItem.countItemsInOrders+'</td>'+
            '</tr>').appendTo($("#dataitems"));


    })


}