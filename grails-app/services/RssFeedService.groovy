import idrabenia.domain.RssItem
import org.apache.commons.lang.Validate
import org.springframework.web.client.RestTemplate
import java.text.DateFormat
import java.text.SimpleDateFormat


/**
 * Class responsible for make needed operation with feed
 * @author Ilya Drabenia
 * @since 13.11.12
 */
class RssFeedService {

    RestTemplate restTemplate

    /**
     * Parse RSS feed and store items in database
     * It throws exceptions if not possible to parse specified feed
     * @param feedUrl
     * @throws java.text.ParseException
     * @throws org.springframework.web.client.RestClientException
     */
    void addRssFeed(String feedUrl) {
        Validate.notNull(feedUrl)

        String xml = restTemplate.getForObject(feedUrl, String.class)

        def xmlMap = new XmlSlurper().parseText(xml)
        xmlMap.channel.item.each { curItem ->
            convertItemToObject(curItem).saveOrUpdate()
        }
    }

    private RssItem convertItemToObject(item) {
        new RssItem(
                guid: item.guid.toString(),
                title: item.title.toString(),
                link: item.link.toString(),
                creationDate: makeDateFormat().parse(item.pubDate.toString()))
    }

    private DateFormat makeDateFormat() {
        // date format is not thread safe then we need to make it each time
        new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH)
    }

}
