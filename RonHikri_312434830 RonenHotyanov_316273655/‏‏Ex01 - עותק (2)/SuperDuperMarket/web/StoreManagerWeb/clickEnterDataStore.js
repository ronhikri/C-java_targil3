var UrlBringDataStoreToSystem=buildUrlWithContextPath("bringnewStoreToSystem");

$(function () {
    $("#selectDataToStore").click(function () {
        var iDsTore = $("#IdStore").val();
        var nameStore = $("#namenewstore").val();
        var ppkSTORE = $("#ppkstore").val();
        var corx = $("#CordinataXStore").val();
        var cory = $("#CordinataYStore").val();

        $.ajax({
            method: 'POST',
            data: {"iddsstore": iDsTore, "nameSTOre": nameStore, "ppkastore": ppkSTORE, "cordX": corx, "cordY": cory},
            url: UrlBringDataStoreToSystem,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                //ajContent..
                console.log("Failed to get ajax response");
            },

            success: function (response) {
                if(response=="1")
                {
                    document.getElementById("selectDataToStore")["disabled"]=true;
                    document.getElementById("ShowItemsInSystem")["disabled"]=false;
                }

            }

        })
    })
});