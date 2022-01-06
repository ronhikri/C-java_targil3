const SHOW_FEEDBACK_URL = buildUrlWithContextPath("servetFeedbackFromCustomer");
var refreshRate=4000;
$(function() {
    setInterval(ajaxShowFeedback, refreshRate);
});

function ajaxShowFeedback() {
    $.ajax({
        url: SHOW_FEEDBACK_URL,
        dataType: 'json',
        success: function(userWeb) {
            refreshShowFeedback(userWeb);
        }
    });
}

function refreshShowFeedback(userWeb)
{
    var StringAddText = "";
    $("#TextWatchFeedbackOfRide").val("");
    $("#AverageWatchFeedbackOfRide").val("");
    $("#numberVotesFeedbackOfRide").val("");

    // rebuild the list of Feedback: scan all the Feedback of the current user and add them to the list of Feedbacks
    $.each(userWeb.feedbackList || [], function(index, feedback) {
        StringAddText = StringAddText.concat("Name Of Customer: ", feedback.nameOfCustomer,"    Rate: ",  feedback.rateFeed,"\n");
        if (!(feedback.messageFeed === null))
            StringAddText = StringAddText.concat("message:\n", feedback.messageFeed, "\n");
    });

    if (!(userWeb.numOfVoters === 0))
    {
        $("#TextWatchFeedbackOfRide").val(StringAddText);
        $("#AverageWatchFeedbackOfRide").val(userWeb.averageGrade);
        $("#numberVotersFeedbackOfRide").val(userWeb.numOfVoters);
    }
}
