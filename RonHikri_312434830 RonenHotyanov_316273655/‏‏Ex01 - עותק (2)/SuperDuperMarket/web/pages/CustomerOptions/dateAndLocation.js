var USER_LIST_URLl = buildUrlWithContextPath("SeveteDate");
$(function() {
    $("#btnMakeAnOrder").click(function () {
        window.typeOrder = 0;

        var YearCombox = $("#comboYears").val();
        var MonthCombox = $("#comboMonth").val();
        var DayCombox = $("#comboDay").val();
        var cordinataX = $("#Cordinatax").val();
        var cordinataY = $("#Cordinatay").val();
        var myRadio = $("input[name=StaticOrDynamic]");
        var checkedValue = myRadio.filter(":checked").val();
        if ((YearCombox == null) || (MonthCombox == null) || (DayCombox == null) || (cordinataX == null) || (cordinataY == null))
            $("errorMessageToDateAndLocation").text("Fill all data to select location and date");
        else {

            // var formData = new FormData();
            $.ajax({
                method: 'POST',
                data: {
                    "Year": YearCombox,
                    "Month": MonthCombox,
                    "Day": DayCombox,
                    "X": cordinataX,
                    "Y": cordinataY,
                    "staticOrDynamic": checkedValue
                },
                url: USER_LIST_URLl,
                dataType: 'json',
                timeout: 5000,
                error: function (e) {
                    $("errorMessageToDateAndLocation").text(e);
                    //ajContent..
                    console.log("Failed to get ajax response");
                },

                success: function (response) {
                    if (response != "1" && response != 2) {
                        $("errorMessageToDateAndLocation").text(response);
                    }
                    if (response == "1") {
                        document.getElementById("finishToSelectItem")["disabled"] = true;
                        document.getElementById("AddItemToOrder")["disabled"] = true;
                        document.getElementById("btnDataOfStore")["disabled"] = false;
                        document.getElementById("bthAddStore")["disabled"] = true;
                        document.getElementById("bthDataOfItem")["disabled"] = false;
                        document.getElementById("btnMakeAnOrder")["disabled"] = true;
                        window.typeOrder = 1;
                    } else {
                        if (response == "2") {
                            document.getElementById("finishToSelectItem")["disabled"] = true;
                            document.getElementById("AddItemToOrder")["disabled"] = true;
                            document.getElementById("btnDataOfStore")["disabled"] = false;
                            document.getElementById("bthAddStore")["disabled"] = true;
                            document.getElementById("bthDataOfItem")["disabled"] = false;
                            document.getElementById("btnMakeAnOrder")["disabled"] = true;
                            window.typeOrder = 2;
                        }
                    }

                }
            })
        }
    });
});

