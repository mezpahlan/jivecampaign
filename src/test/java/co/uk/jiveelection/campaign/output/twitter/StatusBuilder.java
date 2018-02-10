package co.uk.jiveelection.campaign.output.twitter;

import twitter4j.*;

import java.util.Date;

public class StatusBuilder {

    private Date createdAt;
    private long id;
    private String text;
    private int displayTextRangeStart;
    private int displayTextRangeEnd;
    private String source;
    private boolean isTruncated;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private String inReplyToScreenName;
    private GeoLocation geoLocation;
    private Place place;
    private boolean isFavourited;
    private boolean isRetweeted;
    private int favouriteCount;
    private User user;
    private boolean isRetweet;
    private Status retweetedStatus;
    private long[] contributors = new long[0];
    private int retweetCount;
    private boolean retweetedByMe;
    private long currentUserRetweetId;
    private boolean isPossiblySensitive;
    private String lang;
    private Scopes scopes;
    private String[] withheldInCountries = new String[0];
    private long quotedStatusId;
    private Status quotedStatus;
    private UserMentionEntity[] userMentionEntities = new UserMentionEntity[0];
    private URLEntity[] urlEntities = new URLEntity[0];
    private HashtagEntity[] hashtagEntities = new HashtagEntity[0];
    private MediaEntity[] mediaEntities = new MediaEntity[0];
    private SymbolEntity[] symbolEntities = new SymbolEntity[0];
    private RateLimitStatus rateLimitStatus;
    private int accessLevel;

    public StatusBuilder createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public StatusBuilder id(long id) {
        this.id = id;
        return this;
    }

    public StatusBuilder text(String text) {
        this.text = text;
        return this;
    }

    public StatusBuilder displayTextRange(int displayTextRangeStart, int displayTextRangeEnd) {
        this.displayTextRangeStart = displayTextRangeStart;
        this.displayTextRangeEnd = displayTextRangeEnd;
        return this;
    }

    public StatusBuilder source(String source) {
        this.source = source;
        return this;
    }

    public StatusBuilder isTruncated() {
        this.isTruncated = true;
        return this;
    }

    public StatusBuilder inReplyToStatusId(long inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
        return this;
    }

    public StatusBuilder inReplyToUserId(long inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
        return this;
    }

    public StatusBuilder inReplyToUserId(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
        return this;
    }

    public StatusBuilder geoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
        return this;
    }

    public StatusBuilder place(Place place) {
        this.place = place;
        return this;
    }

    public StatusBuilder isFavourited() {
        this.isFavourited = true;
        return this;
    }

    public StatusBuilder isRetweeted() {
        this.isRetweeted = true;
        return this;
    }

    public StatusBuilder favouriteCount(int favouriteCount) {
        this.favouriteCount = favouriteCount;
        return this;
    }

    public StatusBuilder user(User user) {
        this.user = user;
        return this;
    }

    public StatusBuilder isRetweet() {
        this.isRetweet = true;
        return this;
    }

    public StatusBuilder retweetedStatus(Status retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
        return this;
    }

    public StatusBuilder contributors(long[] contributors) {
        this.contributors = contributors;
        return this;
    }

    public StatusBuilder retweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
        return this;
    }

    public StatusBuilder retweetedByMe() {
        this.retweetedByMe = true;
        return this;
    }

    public StatusBuilder currentUserRetweetId(long currentUserRetweetId) {
        this.currentUserRetweetId = currentUserRetweetId;
        return this;
    }

    public StatusBuilder isPossiblySensitive(boolean isPossiblySensitive) {
        this.isPossiblySensitive = isPossiblySensitive;
        return this;
    }

    public StatusBuilder lang(String lang) {
        this.lang = lang;
        return this;
    }

    public StatusBuilder scopes(Scopes scopes) {
        this.scopes = scopes;
        return this;
    }

    public StatusBuilder withheldInCountries(String[] withheldInCountries) {
        this.withheldInCountries = withheldInCountries;
        return this;
    }

    public StatusBuilder quotedStatusId(long quotedStatusId) {
        this.quotedStatusId = quotedStatusId;
        return this;
    }

    public StatusBuilder quotedStatus(Status quotedStatus) {
        this.quotedStatus = quotedStatus;
        return this;
    }

    public StatusBuilder userMentionEntities(UserMentionEntity[] userMentionEntities) {
        this.userMentionEntities = userMentionEntities;
        return this;
    }

    public StatusBuilder urlEntities(URLEntity[] urlEntities) {
        this.urlEntities = urlEntities;
        return this;
    }

    public StatusBuilder hashtagEntities(HashtagEntity[] hashtagEntities) {
        this.hashtagEntities = hashtagEntities;
        return this;
    }

    public StatusBuilder mediaEntities(MediaEntity[] mediaEntities) {
        this.mediaEntities = mediaEntities;
        return this;
    }

    public StatusBuilder symbolEntities(SymbolEntity[] symbolEntities) {
        this.symbolEntities = symbolEntities;
        return this;
    }

    public StatusBuilder rateLimitStatus(RateLimitStatus rateLimitStatus) {
        this.rateLimitStatus = rateLimitStatus;
        return this;
    }

    public StatusBuilder accessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    public Status build() {
        return new Status() {
            @Override
            public Date getCreatedAt() {
                return createdAt;
            }

            @Override
            public long getId() {
                return id;
            }

            @Override
            public String getText() {
                return text;
            }

            @Override
            public int getDisplayTextRangeStart() {
                return displayTextRangeStart;
            }

            @Override
            public int getDisplayTextRangeEnd() {
                return displayTextRangeEnd;
            }

            @Override
            public String getSource() {
                return source;
            }

            @Override
            public boolean isTruncated() {
                return isTruncated;
            }

            @Override
            public long getInReplyToStatusId() {
                return inReplyToStatusId;
            }

            @Override
            public long getInReplyToUserId() {
                return inReplyToUserId;
            }

            @Override
            public String getInReplyToScreenName() {
                return inReplyToScreenName;
            }

            @Override
            public GeoLocation getGeoLocation() {
                return geoLocation;
            }

            @Override
            public Place getPlace() {
                return place;
            }

            @Override
            public boolean isFavorited() {
                return isFavourited;
            }

            @Override
            public boolean isRetweeted() {
                return isRetweeted;
            }

            @Override
            public int getFavoriteCount() {
                return favouriteCount;
            }

            @Override
            public User getUser() {
                return user;
            }

            @Override
            public boolean isRetweet() {
                return isRetweet;
            }

            @Override
            public Status getRetweetedStatus() {
                return retweetedStatus;
            }

            @Override
            public long[] getContributors() {
                return contributors;
            }

            @Override
            public int getRetweetCount() {
                return retweetCount;
            }

            @Override
            public boolean isRetweetedByMe() {
                return retweetedByMe;
            }

            @Override
            public long getCurrentUserRetweetId() {
                return currentUserRetweetId;
            }

            @Override
            public boolean isPossiblySensitive() {
                return isPossiblySensitive;
            }

            @Override
            public String getLang() {
                return lang;
            }

            @Override
            public Scopes getScopes() {
                return scopes;
            }

            @Override
            public String[] getWithheldInCountries() {
                return withheldInCountries;
            }

            @Override
            public long getQuotedStatusId() {
                return quotedStatusId;
            }

            @Override
            public Status getQuotedStatus() {
                return quotedStatus;
            }

            @Override
            public int compareTo(Status o) {
                return o.getText().compareTo(text);
            }

            @Override
            public UserMentionEntity[] getUserMentionEntities() {
                return userMentionEntities;
            }

            @Override
            public URLEntity[] getURLEntities() {
                return urlEntities;
            }

            @Override
            public HashtagEntity[] getHashtagEntities() {
                return hashtagEntities;
            }

            @Override
            public MediaEntity[] getMediaEntities() {
                return mediaEntities;
            }

            @Override
            public SymbolEntity[] getSymbolEntities() {
                return symbolEntities;
            }

            @Override
            public RateLimitStatus getRateLimitStatus() {
                return rateLimitStatus;
            }

            @Override
            public int getAccessLevel() {
                return accessLevel;
            }
        };
    }
}
