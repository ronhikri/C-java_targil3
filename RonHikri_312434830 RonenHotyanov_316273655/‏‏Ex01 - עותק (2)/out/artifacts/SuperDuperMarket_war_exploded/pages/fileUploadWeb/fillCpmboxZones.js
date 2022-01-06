var USER_LISTURL = buildUrlWithContextPath("ZoneselecServet");

var refreshRate = 5000; //mili seconds

$(function() {
    setInterval(ajaxListZones,refreshRate);
});


function ajaxListZones() {
    // var formData = new FormData();
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: USER_LISTURL,
        timeout: 5000,
        error: function (e) {
            //ajContent..
            console.log("Failed to get ajax response");
        },

        success: function (response) {
            refreshComboxZoneInfoUsers(response);
        }
    })
}
function refreshComboxZoneInfoUsers(responce)
{
    var x=document.getElementById("Zones");
  while (x.length>0)
  {
      x.remove(x.length-1);
  }
    $.each(responce || [],function (index,responeitem) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x=responeitem.nameZone;
        $('#Zones').append($('<option>').val(x).text(x));

    })
}