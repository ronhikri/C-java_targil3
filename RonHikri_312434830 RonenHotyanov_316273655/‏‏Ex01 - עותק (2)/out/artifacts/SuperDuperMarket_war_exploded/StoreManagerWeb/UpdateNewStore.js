var UrlUpdateNEWsTORE=buildUrlWithContextPath("UpdateServetenewStore");

$(function () {
    $("#Aditem").click(function () {
        var itt = $("#itemsSystem").val();
        var priceritem=$("#itemPrice").val();
        $.ajax({
            method: 'POST',
            data: {"idditem": itt, "priceritt": priceritem},
            url: UrlUpdateNEWsTORE,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                //ajContent..
                console.log("Failed to get ajax response");
            },

            success: function (response) {
                if(response=="1")
                {
                    document.getElementById("finished")["disabled"]=false;
                }

            }

        })
    })
});