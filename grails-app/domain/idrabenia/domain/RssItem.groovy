package idrabenia.domain

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

    /**
     * Method check if item with similar guid exists in database then it will be updated
     * else method save new item to database
     * @return persisted rss item
     */
    RssItem saveOrUpdate() {
        def oldItem = RssItem.findByGuid(this.guid, [cache: true])

        if (oldItem) {
            oldItem.properties = this.properties
            return oldItem.save()
        } else {
            return this.save()
        }
    }

    static constraints = {
        title nullable: false, blank: false
        link nullable: false, blank: false
        creationDate nullable: false
        guid nullable: false, blank: false, unique: true
    }

    static mapping = {
        cache true
        creationDate index: true
    }
}
