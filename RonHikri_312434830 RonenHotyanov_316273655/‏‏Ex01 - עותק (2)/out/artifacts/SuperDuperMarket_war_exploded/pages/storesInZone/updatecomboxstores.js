var USER_LIST_URLlll = buildUrlWithContextPath("servetCreateStore");
$(function() {
    setInterval(ajaxListStores,5000)

});
function ajaxListStores()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: USER_LIST_URLlll,
        timeout: 5000,
        error:function (e)
        {
            console.log("no success");

        },
        success: function (response) {
            refreshcomboxZoneInfo(response);
        }
    })
}

function  refreshcomboxZoneInfo(response)
{
   var y=document.getElementById("stores");
   while (y.length>=1)
   {
       y.remove(y.length-1);
   }
    $.each(response || [],function (index,responeitem) {
       // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x=responeitem.idstore.toString()+","+responeitem.nameStore;
        $('#stores').append($('<option>').val(x).text(x));


    })


}
