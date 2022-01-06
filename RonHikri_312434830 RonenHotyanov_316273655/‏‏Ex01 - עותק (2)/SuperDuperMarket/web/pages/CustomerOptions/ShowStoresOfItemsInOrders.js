var USER_LIST_URLselectStoresOrdered = buildUrlWithContextPath("ServeteShowStroesThatOrdered");

$(function () {
    $("#ShowStoresOrder").click(function () {

        $.ajax({
            method: 'POST',
            url: USER_LIST_URLselectStoresOrdered,
            dataType: 'json',
            timeout: 5000,
            error: function (e) {
                console.log("Failed to get ajax response");
            },
            success:function (res)
            {
               refreshcomboxstoresthatordered(res);
                restared();

            }

        })
    })
})
function   refreshcomboxstoresthatordered(resst)
{
    var st=document.getElementById("StoresInOrder");
    while (st.length>0)
    {
        st.remove(st.length-1);
    }
    $.each(resst || [],function (index,rest)
    {
        var or=rest;
        $('#StoresInOrder').append($('<option>').val(or).text(or));

    })
}
function restared()
{
    document.getElementById("sendfidback")["disabled"]=false;
}