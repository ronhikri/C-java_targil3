const refreshRate = 2000; //milli seconds
const SHOW_NOTIFICATIONS_RIDE = buildUrlWithContextPath("ShowNotificationsRideServlet");

function ajaxShowNotificationsRide() {
    $.ajax({
        url: SHOW_NOTIFICATIONS_RIDE,
        success: function(userWeb) {
            if((!(userWeb === "The Notifications are already Update")) && (!(userWeb === "i am PASSENGER")))
                ShowNotificationsRide(userWeb);
        }
    });
}

function ShowNotificationsRide(userWeb)
{
    var StringAddText = "";


    if (!$("#TextWatchNewsnewItem").val()) {
        // textarea is empty
        StringAddText = "";
    }
    else
        StringAddText = StringAddText.concat($("#TextWatchNewsnewItem").val(), "\n");

    $.each(userWeb.feedbackUpdates || [], function(index, FeedbackNotification) {
        StringAddText = StringAddText.concat("Feedback Notification:\n", "Name of Customer: ", FeedbackNotification.nameOfCustomer,"   Rate: ",  FeedbackNotification.ratingNumber, "\n");
        if (!(FeedbackNotification.messageFeedback === ""))
            StringAddText = StringAddText.concat("message:\n", FeedbackNotification.messageFeedback, "\n");

        StringAddText = StringAddText.concat("Date:", FeedbackNotification.dateOfNotification, "\n");
    })
    $.each(userWeb.orderUpdates || [], function(index, OrdersNotification) {
        StringAddText = StringAddText.concat("Order Notification:\n", "Number of order: ",OrdersNotification.numberOfOrder,"   name Of Customer: ",  OrdersNotification.name_customer,"  countkinditems: ", OrdersNotification.kindItems,"  SumCostItemsInOrder: ", OrdersNotification.SumCostItems," CostSendOfOrder: ", OrdersNotification.CostSend, "\n");
    })
    $.each(userWeb.newStoreUpdates || [], function(index, ShowNewStores) {
        StringAddText = StringAddText.concat("Stores Notification:\n", "name of maneger store: ",ShowNewStores.nameMenegerStore,"   name of store: ",  ShowNewStores.nameOfStore,"  CordinataX of store: ", ShowNewStores.cordinataX,"  CordinataY of store: ", ShowNewStores.cordinataY," Count items In Store: ", ShowNewStores.countItems, "\n");
    })



    $("#TextWatchNewsnewItem").val(StringAddText);
}

//activate the timer calls after the page is loaded
$(function () {
    setInterval(ajaxShowNotificationsRide, refreshRate);
});