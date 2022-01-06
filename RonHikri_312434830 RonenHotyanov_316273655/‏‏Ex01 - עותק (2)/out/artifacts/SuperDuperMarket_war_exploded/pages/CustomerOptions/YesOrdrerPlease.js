var urlAddOrderPlease=buildUrlWithContextPath("AddOrder");

$(function() {
    $("#Yes").click(function () {
        $.ajax({
            method: 'POST',
            url: urlAddOrderPlease,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                document.getElementById("Yes")["disabled"]=true;
                document.getElementById("No")["disabled"]=true;
                document.getElementById("ShowStoresOrder")["disabled"]=false;
                //ajContent..
                console.log("Failed to get ajax response");
            },
            success: function (res) {
                document.getElementById("Yes")["disabled"]=true;
                document.getElementById("No")["disabled"]=true;
                document.getElementById("ShowStoresOrder")["disabled"]=false;


            }

        })


    });
});