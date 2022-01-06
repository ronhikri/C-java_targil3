CHARGE_MONEY_URL = buildUrlWithContextPath("ChargeMoneyServet");

$(function() { // onload...do
    $("#ChargeMoneyForm").click(function() {

        var amount = $("#chargeAmount").val();
        var datei=$("#dateChargeMoney").val();

        $.ajax({
            method:'POST',
            data: {"chargeMoneyForAccount":amount,"chargeDatei":datei} ,
            url: CHARGE_MONEY_URL,
            //timeout: 4000,
            success: function (r) {
                if((r=="-1")||(r=="-2")) {
                    $("#errorMessage").text("Can only charge money above 0 or the date not fix");
                }
                else {
                    $("#theAmountOfMoney").text(r);
                    $("#errorMessage").text("Charging process Succeeded");
                }
            },
            error: function (e) {
                $("#errorMessage").text("Not a legal amount of money");
            }

        });

        // return value of the submit operation
        // by default - we'll always return false so it doesn't redirect the user.

    })
})

