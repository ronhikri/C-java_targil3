var UPDATE_FINANCIAL_URL = buildUrlWithContextPath("UpdateFinancialInfoServlet");




function refreshFinancialTableInfo(userWeb) {
    //clear all current table info...
    var tb = document.getElementById('financialTable');
    while(tb.rows.length > 1) {
        tb.deleteRow(1);
    }

    // rebuild the list of activations: scan all the activations of the current user and add them to the list of activations
    $.each(userWeb.financialActionList || [], function(index, FinancialAction) {
        $('<tr>' + '<td>'+ FinancialAction.actionName +'</td>' + '<td>'+ FinancialAction.dateFormat +'</td>' +
            '<td>'+ FinancialAction.amountAction +'</td>' + '<td>' + FinancialAction.amountBefore + '</td>' +
            '<td>' + FinancialAction.amountAfter +'</td>' + '</tr>').appendTo($("#financialTable"));
    });
}


function ajaxFinancialAction() {
    $.ajax({
        method:'POST',
        url: UPDATE_FINANCIAL_URL,
        timeout: 4000,
        error: function(e) {
            console.error("Failed to submit");
            $("#theAmountOfMoney").text("Failed to get result from server ");
        },
        success: function(userWeb) {
            refreshFinancialTableInfo(userWeb);
        }
    });
}
$(function()
{
    ajaxFinancialAction();
});