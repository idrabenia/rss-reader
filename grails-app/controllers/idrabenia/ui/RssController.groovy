package idrabenia.ui

import java.text.ParseException
import org.springframework.web.client.RestClientException
import idrabenia.domain.RssItem

/**
 *
 * @author Ilya Drabenia
 * @since 13.11.12
 */
class RssController {

    def rssFeedService

    def newsList = {

    }

    def addNewsFeed = {
        try {
            rssFeedService.addRssFeed(params.feedUrl)
            render 'Ok'
        } catch (Exception ex) {
            render 'Error'
        }
    }

    def listRssItems = {
        render(template: 'itemsList')
    }

    def removeItem = {
        RssItem.findByGuid(params.guid)?.delete()
        render 'Ok'
    }

}
