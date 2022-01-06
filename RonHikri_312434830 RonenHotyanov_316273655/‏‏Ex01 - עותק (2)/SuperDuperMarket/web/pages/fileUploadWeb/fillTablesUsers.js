var USER_LIST_URLl = buildUrlWithContextPath("dataUsersServet");

var refreshRate = 5000; //mili seconds

$(function() {
    setInterval(ajaxListUsers,refreshRate);
});


function ajaxListUsers() {
    // var formData = new FormData();
    $.ajax({
        method:'POST',
        ///  data: formData,
        url: USER_LIST_URLl,
        timeout: 5000,
        error: function (e) {
            //ajContent..
            console.log("Failed to get ajax response");
        },

        success: function (response) {
            refreshTableZoneInfoUsers(response);
        }
    })
}
//    return false;
//  }

function refreshTableZoneInfoUsers(zoneTableInfos) {
    //clear all current table info...
    var tb = document.getElementById('dataUsers');
    while (tb.rows.length > 1) {
        tb.deleteRow(1);
    }
    // $("#dataSpace").empty();
    /*
               <th>nameStoreManager</th>
            <th>NameSpace</th>
            <th> SumSortItems</th>
            <th>SumStores</th>
            <th>SumOrders</th>
            <th>AvgpriceOfOrder</th>

     */
    //  var tableHeaders = "<tr><th>nameStoreManager</th>" +"<th>NameSpace</th>"+"<th>SumSortItems</th>"+"<th>SumStores"+"<th>SumOrders"+"<th>AvgpriceOfOrder</th></tr>";

    //   $(tableHeaders).appendTo($("#dataSpace"));
    // [Zone0:{name, id,....}, Zone1:{}]
    // rebuild the list of users: scan all users and add them to the list of users
    //  $.each(zoneTableInfos || [], function (index, zoneInfo) {
    // var data = "<tr>"+
    //               "<td>"+zoneInfo.nameStoreManager+"</td>"+zoneInfo.szone+"<td>"+zoneInfo.sumSortsItems+"</td>"+"<td>"+zoneInfo.SumStores+"</td>"+"<td>"+zoneInfo.SumOrders+"</td>"+"<td>"+zoneInfo.AvgPriceOrder+"</td>"+"</tr>";
    //    $(data).appendTo($("#dataSpace"));
    /*
     $('<tr>' + '<td> <form method="GET" action="../../ShowData"> <input type="submit" class="mapClick btn" value="I want this map" /> <input type="hidden" value=' + zoneTableInfos.nameStoreManager + ' name="userNameMap"/> </td>' + '<td>' + zoneTableInfos.szone + '</td>' + '<td>' + zoneTableInfos.sumSortsItems + '</td>' +
         '<td>' + zoneTableInfos.SumStores + '</td>' + '<td>' + zoneTableInfos.SumOrders + '</td>' +
         '<td>' + zoneTableInfos.AvgPriceOrder + '</td>' + '</tr>').appendTo($("#dataSpace"));
         *
     */
    // });

    $.each(zoneTableInfos ||[],function (index,zoneTableInfo){
        $('<tr>'+
            '<td>'+zoneTableInfo.nameyi+'</td>'+
            '<td>'+zoneTableInfo.roliey+'</td>'+
            '</tr>').appendTo($("#dataUsers"));


    })

}
//activate the timer calls after the page is loaded
