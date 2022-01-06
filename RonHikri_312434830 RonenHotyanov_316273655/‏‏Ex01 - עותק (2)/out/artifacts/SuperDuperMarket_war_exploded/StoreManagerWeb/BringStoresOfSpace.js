var UrlBringmeStores=buildUrlWithContextPath("SowStoresFformanager");
$(function() {


    setInterval(ajaxListores, 5000);
    initiallShowOrders();

});
function ajaxListores()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: UrlBringmeStores,
        dataType: 'json',
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (responsenamestores) {
            refreshtableZoneInfstores(responsenamestores);
        }
    })
}
function  refreshtableZoneInfstores(responsenameStores)
{
    var o = document.getElementById("StoresSelecting");
    while (o.length > 0) {
        o.remove(o.length - 1);
    }

    $.each(responsenameStores || [],function (index,responstore) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x=responstore;
        $("#StoresSelecting").append($('<option>').val(x).text(x));



    })

}
function initiallShowOrders() {
    document.getElementById("selectStoreClick")["disabled"] = false;
    document.getElementById("seletOrderInStoreClick")["disabled"] = true;
}