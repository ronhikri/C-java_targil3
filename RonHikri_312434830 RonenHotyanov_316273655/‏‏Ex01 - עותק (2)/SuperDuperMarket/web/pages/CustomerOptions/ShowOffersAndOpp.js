var USER_LIST_nameoffs = buildUrlWithContextPath("serveteNameOffers");
var UsrListopp=buildUrlWithContextPath("ServeteOpp");
var usrdataoffers=buildUrlWithContextPath("servetAddOffers");
$(function() {
    $("#Showoffers").click(function () {

        ajaxListoffers();
        ajaxListItemsopps();
        ajaxListItemsTableOffs();
        document.getElementById("addDisc")["disabled"]=false;



    })
})
function ajaxListoffers()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: USER_LIST_nameoffs,
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (responsenameoffs) {
            refreshtableZoneInfooffs(responsenameoffs);
        }
    })
}
function refreshtableZoneInfooffs(responsenameoffs)
{
    var o = document.getElementById("name_offers");
    while (o.length > 0) {
        o.remove(o.length - 1);
    }

    $.each(responsenameoffs || [],function (index,responsof) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x=responsof;
        $("#name_offers").append($('<option>').val(x).text(x));



    })

}
function ajaxListItemsopps()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: UsrListopp,
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (responseops) {
            refreshNamesoops(responseops);
        }
    })

}
function refreshNamesoops(responseops)
{
    var p = document.getElementById("name_opperation");
    while (p.length > 0) {
        p.remove(p.length - 1);
    }

    $.each(responseops || [],function (index,responseop) {
        // var option=document.createElement("OPTION"),
        //txt=document.createTextNode(responeitem.idstore+","+responeitem.nameStore);
        //option.appendChild(txt);
        //option.setAttribute("value",responeitem.idstore+","+responeitem.nameStore);
        //select.insertAfter(option,select.lastChild);
        var x=responseop;
        $("#name_opperation").append($('<option>').val(x).text(x));



    })
}
function ajaxListItemsTableOffs()
{
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: usrdataoffers,
        timeout: 5000,
        error: function e()
        {
            console.log("no success");
        },
        success: function (responseoffsdata) {
            rfreshDataOffs(responseoffsdata);
        }
    })

}
function rfreshDataOffs(responseoffsdata)
{
    var D=document.getElementById('DataOffetsOfDiscount');
    while (D.rows.length > 1) {
        D.deleteRow(1);
    }
    $.each(responseoffsdata||[],function (index,responsedat) {
        $('<tr>' +
            '<td>' +responsedat.idoffer + '</td>' +
            '<td>' + responsedat.nameofOffer+ '</td>' +
            '<td>'+responsedat.quantityOffer+'</td>'+
            '<td>'+responsedat.priceOffer+'</td>'+
            '</tr>').appendTo($("#DataOffetsOfDiscount"));
    })
}
