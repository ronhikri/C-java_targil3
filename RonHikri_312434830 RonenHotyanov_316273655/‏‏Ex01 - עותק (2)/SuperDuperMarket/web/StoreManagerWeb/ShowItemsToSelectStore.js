var urlItemsToNewStore=buildUrlWithContextPath("ServetbringItemsForStore");
$(function () {
    $("#ShowItemsInSystem").click(function () {

        $.ajax({
            method:'POST',
            ///  data: formData,
            url: urlItemsToNewStore,
            dataType: 'json',
            timeout: 5000,
            error: function e()
            {
                console.log("no success");
            },
            success: function (responsenamestores) {
                refreshfullitems(responsenamestores);
                document.getElementById("Aditem")["disabled"]=false;
            }
        })

    })
});
function refreshfullitems(resitems)
{
    var iter=document.getElementById("itemsSystem");
    while (iter.length>=1)
    {
        iter.remove(iter.length-1);
    }
    $.each(resitems || [],function (index,resitem) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x = resitem;
        $("#itemsSystem").append($('<option>').val(x).text(x));
    })
}