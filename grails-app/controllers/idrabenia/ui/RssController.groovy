package idrabenia.ui

import idrabenia.domain.RssItem

/**
 * Controller used for make operations with RSS items list
 * @author Ilya Drabenia
 * @since 13.11.12
 */
class RssController {

    def rssFeedService

    def newsList = {
        render(view: 'newsList', model: [rssItems: listRssItemsForCurrentUser()])
    }

    def addNewsFeed = {
        try {
            rssFeedService.addRssFeed(currentUserName, params.feedUrl)
            render 'Ok'
        } catch (Exception ex) {
            render 'Error'
        }
    }

    def listRssItems = {
        render(template: 'itemsList', model: [rssItems: listRssItemsForCurrentUser()])
    }

    def removeItem = {
        RssItem.findByGuidAndCreatorUserName(params.guid, currentUserName)?.delete()
        render 'Ok'
    }

    private String getCurrentUserName() {
        request.userPrincipal.name
    }

    private listRssItemsForCurrentUser() {
        RssItem.listItemsForUser(currentUserName)
    }

}
