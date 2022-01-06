
$(function() {
    $("#finishToSelectItem").click(function () {
        Enditemorder();
    })
});
function  Enditemorder()
{
    document.getElementById("finishToSelectItem")["disabled"]=true;
    document.getElementById("AddItemToOrder")["disabled"]=true;
    document.getElementById("btnDataOfStore")["disabled"]=true;
    document.getElementById("bthDataOfItem")["disabled"]=true;
    document.getElementById("bthAddStore")["disabled"]=true;
    document.getElementById("ShowDiscounts")["disabled"]=false;

}