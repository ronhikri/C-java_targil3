var UrlUpdateNEWItem=buildUrlWithContextPath("UpdateServeteNewItem");

$(function () {
    $("#AdStores").click(function () {
        var stt = $("#StoresSystem").val();
        var priceritemToStore=$("#priceToAddNewItem").val();
        $.ajax({
            method: 'POST',
            data: {"idsstor": stt, "pricerittToStore": priceritemToStore},
            url: UrlUpdateNEWItem,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                //ajContent..
                console.log("Failed to get ajax response");
            },

            success: function (response) {
                if(response=="1")
                {
                    document.getElementById("finishedCreateItem")["disabled"]=false;
                }

            }

        })
    })
});