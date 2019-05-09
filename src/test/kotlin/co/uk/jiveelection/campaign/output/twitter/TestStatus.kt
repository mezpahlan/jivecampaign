package co.uk.jiveelection.campaign.output.twitter

import twitter4j.*
import java.util.*

data class TestStatus(
        private val createdAt: Date = Date(0),
        private val id: Long = 0,
        private val text: String = "",
        private val displayTextRangeStart: Int = 0,
        private val displayTextRangeEnd: Int = 0,
        private val source: String = "",
        private val isTruncated: Boolean = false,
        private val inReplyToStatusId: Long = 0,
        private val inReplyToUserId: Long = 0,
        private val inReplyToScreenName: String = "",
        private val geoLocation: GeoLocation = GeoLocation(0.0, 0.0),
        private val place: Place? = null,
        private val isFavourited: Boolean = false,
        private val isRetweeted: Boolean = false,
        private val favouriteCount: Int = 0,
        private val user: User? = null,
        private val isRetweet: Boolean = false,
        private val retweetedStatus: Status? = null,
        private val contributors: LongArray = LongArray(0),
        private val retweetCount: Int = 0,
        private val isRetweetedByMe: Boolean = false,
        private val currentUserRetweetId: Long = 0,
        private val isPossiblySensitive: Boolean = false,
        private val withheldInCountries: Array<String> = arrayOf(),
        private val symbolEntities: Array<SymbolEntity> = arrayOf(),
        private val accessLevel: Int = 0,
        private val mediaEntities: Array<MediaEntity> = arrayOf(),
        private val urlEntities: Array<URLEntity> = arrayOf(),
        private val lang: String = "",
        private val quotedStatus: Status? = null,
        private val rateLimitStatus: RateLimitStatus? = null,
        private val scopes: Scopes? = null,
        private val quotedStatusId: Long = 0,
        private val hashtagEntities: Array<HashtagEntity> = arrayOf(),
        private val userMentionEntities: Array<UserMentionEntity> = arrayOf()

) : Status {
    override fun compareTo(other: Status): Int = other.text.compareTo(text)
    override fun getCreatedAt() = createdAt
    override fun getId() = id
    override fun getText() = text
    override fun getDisplayTextRangeStart() = displayTextRangeStart
    override fun getDisplayTextRangeEnd() = displayTextRangeEnd
    override fun getSource() = source
    override fun isTruncated() = isTruncated
    override fun getInReplyToStatusId() = inReplyToStatusId
    override fun getInReplyToUserId() = inReplyToUserId
    override fun getInReplyToScreenName() = inReplyToScreenName
    override fun getGeoLocation() = geoLocation
    override fun getPlace() = place
    override fun isFavorited() = isFavourited
    override fun isRetweeted() = isRetweeted
    override fun getFavoriteCount() = favouriteCount
    override fun getUser() = user
    override fun isRetweet() = isRetweet
    override fun getRetweetedStatus() = retweetedStatus
    override fun getContributors() = contributors
    override fun getRetweetCount() = retweetCount
    override fun isRetweetedByMe() = isRetweetedByMe
    override fun getCurrentUserRetweetId() = currentUserRetweetId
    override fun isPossiblySensitive() = isPossiblySensitive
    override fun getWithheldInCountries() = withheldInCountries
    override fun getSymbolEntities() = symbolEntities
    override fun getAccessLevel() = accessLevel
    override fun getMediaEntities() = mediaEntities
    override fun getURLEntities() = urlEntities
    override fun getLang() = lang
    override fun getQuotedStatus() = quotedStatus
    override fun getRateLimitStatus() = rateLimitStatus
    override fun getScopes() = scopes
    override fun getQuotedStatusId() = quotedStatusId
    override fun getHashtagEntities() = hashtagEntities
    override fun getUserMentionEntities() = userMentionEntities

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestStatus

        if (createdAt != other.createdAt) return false
        if (id != other.id) return false
        if (text != other.text) return false
        if (displayTextRangeStart != other.displayTextRangeStart) return false
        if (displayTextRangeEnd != other.displayTextRangeEnd) return false
        if (source != other.source) return false
        if (isTruncated != other.isTruncated) return false
        if (inReplyToStatusId != other.inReplyToStatusId) return false
        if (inReplyToUserId != other.inReplyToUserId) return false
        if (inReplyToScreenName != other.inReplyToScreenName) return false
        if (geoLocation != other.geoLocation) return false
        if (place != other.place) return false
        if (isFavourited != other.isFavourited) return false
        if (isRetweeted != other.isRetweeted) return false
        if (favouriteCount != other.favouriteCount) return false
        if (user != other.user) return false
        if (isRetweet != other.isRetweet) return false
        if (retweetedStatus != other.retweetedStatus) return false
        if (!Arrays.equals(contributors, other.contributors)) return false
        if (retweetCount != other.retweetCount) return false
        if (isRetweetedByMe != other.isRetweetedByMe) return false
        if (currentUserRetweetId != other.currentUserRetweetId) return false
        if (isPossiblySensitive != other.isPossiblySensitive) return false
        if (!Arrays.equals(withheldInCountries, other.withheldInCountries)) return false
        if (!Arrays.equals(symbolEntities, other.symbolEntities)) return false
        if (accessLevel != other.accessLevel) return false
        if (!Arrays.equals(mediaEntities, other.mediaEntities)) return false
        if (!Arrays.equals(urlEntities, other.urlEntities)) return false
        if (lang != other.lang) return false
        if (quotedStatus != other.quotedStatus) return false
        if (rateLimitStatus != other.rateLimitStatus) return false
        if (scopes != other.scopes) return false
        if (quotedStatusId != other.quotedStatusId) return false
        if (!Arrays.equals(hashtagEntities, other.hashtagEntities)) return false
        if (!Arrays.equals(userMentionEntities, other.userMentionEntities)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = createdAt.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + displayTextRangeStart
        result = 31 * result + displayTextRangeEnd
        result = 31 * result + source.hashCode()
        result = 31 * result + isTruncated.hashCode()
        result = 31 * result + inReplyToStatusId.hashCode()
        result = 31 * result + inReplyToUserId.hashCode()
        result = 31 * result + inReplyToScreenName.hashCode()
        result = 31 * result + geoLocation.hashCode()
        result = 31 * result + (place?.hashCode() ?: 0)
        result = 31 * result + isFavourited.hashCode()
        result = 31 * result + isRetweeted.hashCode()
        result = 31 * result + favouriteCount
        result = 31 * result + (user?.hashCode() ?: 0)
        result = 31 * result + isRetweet.hashCode()
        result = 31 * result + (retweetedStatus?.hashCode() ?: 0)
        result = 31 * result + Arrays.hashCode(contributors)
        result = 31 * result + retweetCount
        result = 31 * result + isRetweetedByMe.hashCode()
        result = 31 * result + currentUserRetweetId.hashCode()
        result = 31 * result + isPossiblySensitive.hashCode()
        result = 31 * result + Arrays.hashCode(withheldInCountries)
        result = 31 * result + Arrays.hashCode(symbolEntities)
        result = 31 * result + accessLevel
        result = 31 * result + Arrays.hashCode(mediaEntities)
        result = 31 * result + Arrays.hashCode(urlEntities)
        result = 31 * result + lang.hashCode()
        result = 31 * result + (quotedStatus?.hashCode() ?: 0)
        result = 31 * result + (rateLimitStatus?.hashCode() ?: 0)
        result = 31 * result + (scopes?.hashCode() ?: 0)
        result = 31 * result + quotedStatusId.hashCode()
        result = 31 * result + Arrays.hashCode(hashtagEntities)
        result = 31 * result + Arrays.hashCode(userMentionEntities)
        return result
    }
}
