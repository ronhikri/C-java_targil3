var urlfinishAddStore=buildUrlWithContextPath("ServeteFinishCreateStore");
$(function () {
    $("#finished").click(function () {
        $.ajax({
            method: 'POST',
            url: urlfinishAddStore,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                document.getElementById("selectDataToStore")["disabled"] = true;
                document.getElementById("ShowItemsInSystem")["disabled"] = true;
                document.getElementById("Aditem")["disabled"] = true;
                document.getElementById("finished")["disabled"] = true;
                //ajContent..
                console.log("Failed to get ajax response");
            },

            success: function (response) {
                document.getElementById("selectDataToStore")["disabled"] = true;
                document.getElementById("ShowItemsInSystem")["disabled"] = true;
                document.getElementById("Aditem")["disabled"] = true;
                document.getElementById("finished")["disabled"] = true;
            }
        })
    })
})