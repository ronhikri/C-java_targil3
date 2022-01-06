var SHOW_MONEY_URL = buildUrlWithContextPath("ShowMoney");

$(function() { // onload...do

    $.ajax({
        method:'POST',
        url: SHOW_MONEY_URL,
        timeout: 4000,
        error: function(e) {
            console.error("Failed to submit");
            $("#theAmountOfMoney").text("Failed to get result from server ");
        },
        success: function(r) {
            $("#theAmountOfMoney").text(r);
        }
    });

    // return value of the submit operation
    // by default - we'll always return false so it doesn't redirect the user.
    return false;
})