var urlStoresToNrewItem=buildUrlWithContextPath("ServetBringStoresToItem");
$(function () {
    $("#ShowStoresInSystem").click(function () {

        $.ajax({
            method:'POST',
            ///  data: formData,
            url: urlStoresToNrewItem,
            dataType: 'json',
            timeout: 5000,
            error: function e()
            {
                console.log("no success");
            },
            success: function (resstores) {
                refreshfulliStores(resstores);
                document.getElementById("AdStores")["disabled"]=false;
            }
        })

    })
});
function refreshfulliStores(resstores)
{
    var sto=document.getElementById("StoresSystem");
    while (sto.length>=1)
    {
        sto.remove(sto.length-1);
    }
    $.each(resstores || [],function (index,resstor) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x = resstor;
        $("#StoresSystem").append($('<option>').val(x).text(x));
    })
}