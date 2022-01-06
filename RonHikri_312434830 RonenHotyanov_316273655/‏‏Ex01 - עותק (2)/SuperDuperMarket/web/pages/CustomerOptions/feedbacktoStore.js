var urlFeedbackToStoreManege= buildUrlWithContextPath("ServeteSendFeedback");

$(function() {
    $("#sendfidback").click(function () {
        var selectfeed = $("#StoresInOrder").val();
        var myRadio = $("input[name=Rate]");
        var checkedValue = myRadio.filter(":checked").val();
        var feedbackText = $("#textAreaFeedback").val();
        if ((selectfeed == null) || (checkedValue == null)) {
            $("#errorMessageFeedback").text("You must choose the rate and you select store");
        } else {
            ajaxfeed(selectfeed,checkedValue,feedbackText);
        }
    });
});



    function ajaxfeed(selectfeed,checkedValue,feedbackText) {
        $.ajax({
            method: 'POST',
            data: {"selectStoreThatOrder": selectfeed,"valuecheckeed":checkedValue,"textfeed":feedbackText},
            url: urlFeedbackToStoreManege,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                document.getElementById("sendfidback")["disabled"]=false;
                document.getElementById("finishfeedback")["disabled"]=false;


                //ajContent..
                console.log("Failed to get ajax response");
            },
            success: function (res) {

                document.getElementById("sendfidback")["disabled"]=false;
                document.getElementById("finishfeedback")["disabled"]=false;


            }

        })
    }