var UrlItemToSysNew=buildUrlWithContextPath("bringNewItemTosys");

$(function () {
    $("#selectDataToItem").click(function () {
        var zoneunit=$("#YourZones").val();
       var nameItemToadd=$("#nameItemToSpace").val();
        var myRadio = $("input[name=QuantityOrWeightToItem]");
        var checkedToValue = myRadio.filter(":checked").val();

        $.ajax({
            method: 'POST',
            data: {"ZonSelect":zoneunit,"nameitemto": nameItemToadd, "howBuyItemTo": checkedToValue},
            url: UrlItemToSysNew,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                //ajContent..
                console.log("Failed to get ajax response");
            },

            success: function (response) {
                if(response=="1")
                {
                    document.getElementById("selectDataToItem")["disabled"]=true;
                    document.getElementById("ShowStoresInSystem")["disabled"]=false;
                }

            }

        })
    })
});