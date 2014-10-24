$(document).ready( function () {
    console.info($('#status'));
    $.ajax({
        type: "GET",
        url: "/user/status",
        dataType: "json",
        success : function(data) {
            $('#status').autocomplete({
                source : data
            });
        }
    });
});