var urlZonesToAddItem=buildUrlWithContextPath("ZonesOfYourStoreManege");
$(function () {
    $("#selectZone").click(function () {

        $.ajax({
            method:'POST',
            ///  data: formData,
            url: urlZonesToAddItem,
            dataType: 'json',
            timeout: 5000,
            error: function e()
            {
                console.log("no success");
            },
            success: function (ressZones) {
                refreshfullZones(ressZones);
                document.getElementById("selectZone")["disabled"]=true;
                document.getElementById("selectDataToItem")["disabled"]=false;
            }
        })

    })
});
function refreshfullZones(ressZones)
{
    var Zonik=document.getElementById("YourZones");
    while (Zonik.length>=1)
    {
        Zonik.remove(Zonik.length-1);
    }
    $.each(ressZones || [],function (index,ressZon) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x = ressZon;
        $("#YourZones").append($('<option>').val(x).text(x));
    })
}