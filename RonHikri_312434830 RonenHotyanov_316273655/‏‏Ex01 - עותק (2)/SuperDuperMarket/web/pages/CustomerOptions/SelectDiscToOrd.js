var USER_LIST_URLlSelectDisc = buildUrlWithContextPath("AddDiscToSession");
$(function() {
    $("#adddiscount").click(function () {
        var DiscSelect = $("#namedis").val();
        $.ajax({
            method: 'POST',
            data: {"nameofdiscis":DiscSelect},
            url: USER_LIST_URLlSelectDisc,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                document.getElementById("adddiscount")["disabled"]=true;
                document.getElementById("Showoffers")["disabled"]=false;

                //ajContent..
                console.log("Failed to get ajax response");
            },
            success: function (res) {
                document.getElementById("adddiscount")["disabled"]=true;
                document.getElementById("Showoffers")["disabled"]=false;


            }

        })
    })
});