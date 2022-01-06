$(function() {
    $("#finishDiscount").click(function () {


        document.getElementById("ShowDiscounts")["disabled"] = true;
        document.getElementById("adddiscount")["disabled"] = true;
        document.getElementById("Showoffers")["disabled"] = true;
        document.getElementById("addDisc")["disabled"] = true;
        document.getElementById("finishDiscount")["disabled"] = true;
        document.getElementById("Yes")["disabled"]=false;
        document.getElementById("No")["disabled"]=false;
    })
});