
$(function() {

    $('#submit').click(function() {
        var url = window['pageConfig'].registerUrl;
        $.get(url, {email: $('#username').val()}, function(data) {
            $('#passwordOutput').val(data.password);
            $('.login_message').html(data.errorsList);
        });

        return false;
    });

});