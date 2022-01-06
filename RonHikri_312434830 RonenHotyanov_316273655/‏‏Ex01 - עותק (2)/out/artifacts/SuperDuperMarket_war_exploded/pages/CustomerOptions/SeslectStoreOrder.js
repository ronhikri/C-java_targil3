var USER_LIST_URLselect = buildUrlWithContextPath("servetSelectStoreStatic");

$(function () {
    $("#bthAddStore").click(function () {

        var sstoreSelect = $("#idStoress").val();
        $.ajax({
            method: 'POST',
            data: {
                "selectStore":sstoreSelect
            },
            url: USER_LIST_URLselect,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                document.getElementById("bthDataOfItem")["disabled"]=false;
                document.getElementById("bthAddStore")["disabled"]=true;
                //ajContent..
                console.log("Failed to get ajax response");
            },
            success:function (res)
            {
                document.getElementById("bthDataOfItem")["disabled"]=false;
                document.getElementById("bthAddStore")["disabled"]=true;

            }

        })
    })
})
