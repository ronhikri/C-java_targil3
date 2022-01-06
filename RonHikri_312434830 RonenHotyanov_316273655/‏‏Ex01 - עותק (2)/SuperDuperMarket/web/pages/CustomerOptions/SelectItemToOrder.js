var USER_LIST_URLselecting = buildUrlWithContextPath("servetAddItemOrder");

$(function () {
    $("#AddItemToOrder").click(function () {

        var it=$("#idItem").val();
        var am=$("#Enteramount").val();

        $.ajax({
            method: 'POST',
            data: {"idkItem":it,"CountItem":am},
            url: USER_LIST_URLselecting,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                document.getElementById("finishToSelectItem")["disabled"]=false;
                document.getElementById("AddItemToOrder")["disabled"]=false;
                //ajContent..
                console.log("Failed to get ajax response");
            },
            success: function (response)
            {
                console.log("Yo add item");
                document.getElementById("finishToSelectItem")["disabled"]=false;
                document.getElementById("AddItemToOrder")["disabled"]=false;
            }
        })

    })
});
