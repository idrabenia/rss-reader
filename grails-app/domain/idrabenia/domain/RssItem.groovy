package idrabenia.domain

import org.apache.commons.lang.Validate

/**
 * Class represent item of RSS feed
 * @author Ilya Drabenia
 * @since 13.11.12
 */
class RssItem {
    String title
    String link
    Date creationDate
    String guid
    String creatorUserName  // Name of user that add this item to database

    /**
     * Method check if item with similar guid exists in database then it will be updated
     * else method save new item to database
     * @return persisted rss item
     */
    RssItem saveOrUpdate() {
        def oldItem = RssItem.findByGuidAndCreatorUserName(this.guid, this.creatorUserName, [cache: true])

        if (oldItem) {
            oldItem.properties = this.properties
            return oldItem.save()
        } else {
            return this.save(flush: true)
        }
    }

    /**
     * Method return list of RSS items searched by user name and ordered by creation date
     * @param userName
     * @return
     */
    static List<RssItem> listItemsForUser(String userName) {
        Validate.notNull(userName)

        RssItem.findAllByCreatorUserName(userName, [sort: 'creationDate', order: 'desc'])
    }

    static constraints = {
        title nullable: false, blank: false
        link nullable: false, blank: false
        creationDate nullable: false
        guid nullable: false, blank: false
        creatorUserName nullable: false, blank: false
    }

    static mapping = {
        cache true
        creationDate index: true
        creatorUserName index: true
        guid index: true
    }

}
