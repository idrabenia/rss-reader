$(function() {

    function refreshRssItemsList() {
        var url = window['pageConfig'].itemsListUrl;
        $.get(url, {}, function(data) {
            $('#rssItemsList').html(data);
        });
    }

    $('#addFeedErrorDialog').dialog({
        autoOpen: false,
        modal: true
    });

    $('#addFeedButton').click(function() {
        var curValue = $('input[name=feedUrl]').val();
        var url = window['pageConfig'].addFeedUrl;
        $.get(url, {feedUrl: curValue}, function(data) {
            if (data == 'Ok') {
                refreshRssItemsList();
            } else {
                $('#addFeedErrorDialog').dialog('open');
            }
        });
    });

    $('.closeErrorDialogButton').click(function() {
        $('#addFeedErrorDialog').dialog('close');
    });

    $('.removeItemButton').live('click', function() {
        var guid = $(this).attr('data-itemGuid');
        var url = window['pageConfig'].removeItemUrl;

        $.post(url, {guid: guid}, function() {
            refreshRssItemsList();
        });
    });

    $('#logoutButton').click(function() {
        window.location.href = window['pageConfig'].logoutUrl;
    });

});