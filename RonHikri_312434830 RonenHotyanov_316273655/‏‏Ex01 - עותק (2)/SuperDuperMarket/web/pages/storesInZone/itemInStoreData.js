var USER_LIST_URLl = buildUrlWithContextPath("servetCreateStores");
$(function() {
    $("#DataOfStore").click(function () {

        var storeInCombo=$("#stores").val();
        if((check(storeInCombo)))
        {
            ajaxitemsinstore(storeInCombo);
        }


    });
});
function check(storeincom)
{
    if(storeincom.length<=0)
        return false;
    else
        return true;
}
function ajaxitemsinstore(storeInCombo)
{
    $.ajax({
        method:'POST',
        data: { "storeselect":storeInCombo } ,
        url: USER_LIST_URLl,
        error:function (e)
        {
            console.log("no success");
        },
        success:function (responce)
        {
            filldata(responce);
        }
    })

}
function filldata(responce)
{
    var tb = document.getElementById('dataOneStore');
    while (tb.rows.length > 1) {
        tb.deleteRow(1);
    }
        $('<tr>'+
            '<td>'+responce.idStore+'</td>'+
            '<td>'+responce.nameSore+'</td>'+
            '<td>'+responce.StoreManeger+'</td>'+
            '<td>'+responce.locationOfStore+'</td>'+
            '<td>'+responce.sumordersOfStore+'</td>'+
            '<td>'+responce.costOfItemsThatSold+'</td>'+
            '<td>'+responce.ppk+'</td>'+
            '<td>'+responce.sumCostOfOrdersInStore+'</td>'+
            '</tr>').appendTo($("#dataOneStore"));

    var tb = document.getElementById('itemsStore');
    while (tb.rows.length > 1) {
        tb.deleteRow(1);
    }
    $.each(responce.list ||[],function (index,resinfo){
        $('<tr>'+
            '<td>'+resinfo.idOfItem+'</td>'+
            '<td>'+resinfo.nameOfItem+'</td>'+
            '<td>'+resinfo.howToBuy+'</td>'+
            '<td>'+resinfo.priceUnitOfItem+'</td>'+
            '<td>'+resinfo.SUMitemSold+'</td>'+
            '</tr>').appendTo($("#itemsStore"));


    })


}
