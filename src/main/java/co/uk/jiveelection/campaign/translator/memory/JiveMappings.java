package co.uk.jiveelection.campaign.translator.memory;

import java.util.HashMap;

/**
 * Mapping file for Jive speak based on the language file
 * from https://www.cs.utexas.edu/users/jbc/home/chef.html.
 * <p>
 * Seeds the mappings in the constructor.
 */
class JiveMappings extends HashMap<String, String> {

    private static final JiveMappings instance = new JiveMappings();

    private JiveMappings() {
        addAtomic("file", "stash");
        addAtomic("send", "t'row");
        addAtomic("program", "honky code");
        addAtomic("atlas", "Isaac");
        addAtomic("unix", "slow mo-fo");
        addAtomic("UNIX", "that slow mo-fo");
        addAtomic("take", "snatch");
        addLeftAtomic("[Mm]exican", "wet-back");
        addLeftAtomic("[Ii]talian", "greaser");
        addAtomic("takes", "snatch'd");
        addAtomic("don't", "duzn't");
        addAtomic("translator", "jibe");
        addAtomic("fool", "honkyfool");
        addAtomic("modem", "doodad");
        addMapping("([adet])\\b the", "$1 da damn");
        addAtomic("man", "dude");
        addRightAtomic("woman", "mama");
        addAtomic("girl", "goat");
        addAtomic("something", "sump'n");
        addAtomic("lie", "honky jibe");
        addMapping("([a-b])\\.", "$1. Sheeeiit.");
        addMapping("([e-f])\\.", "$1. What it is, Mama!");
        addMapping("([i-j])\\.", "$1. Ya' know?");
        addMapping("([m-n])\\.", "$1. 'S coo', bro.");
        addMapping("([q-r])\\.", "$1. Ah be baaad...");
        addMapping("([u-v])\\.", "$1. Man!");
        addMapping("([y-z])\\.", "$1. Slap mah fro!");
        addAtomic("([Ss])ure", "$1ho' nuff");
        addLeftAtomic("get", "git");
        addAtomic("(will have|will|got to|have to|has)", "gots'ta");
        addAtomic("I am", "I's gots'ta be");
        addAtomic("(am|is|are) not", "aint");
        addAtomic("are your", "is yo'");
        addAtomic("are you", "you is");
        addAtomic("hat", "fedora");
        addAtomic("shoe", "kicker");
        addAtomic("haven't", "aint");
        addAtomic("(?<!will )have(?! to)", "gots'");
        addAtomic("(come over|come)", "mosey on down");
        addMapping("!\\B", ". Right On!");
        addAtomic("buy", "steal");
        addAtomic("car", "wheels");
        addAtomic("drive", "roll");
        addAtomic("eat", "feed da bud");
        addAtomic("(black|negro)", "brother");
        addAtomic("white", "honky");
        addLeftAtomic("nigger", "gentleman");
        addAtomic("nice", "supa' fine");
        addAtomic("person", "sucka'");
        addAtomic("persons|people", "sucka's");
        addAtomic("thing", "wahtahmellun");
        addAtomic("home", "crib");
        addAtomic("name", "dojigger");
        addAtomic("path", "alley");
        addAtomic("computer", "clunker");
        addAtomic("or", "o'");
        addAtomic("killed", "wasted");
        addAtomic("president", "super-dude");
        addAtomic("prime minister", "super honcho");
        addAtomic("injured", "hosed");
        addLeftAtomic("government", "guv'ment");
        addAtomic("knew", "knowed");
        addAtomic("([Bb])ecause", "$1'cuz");
        addLeftAtomic("(?<!are )([Yy])our", "$1o'");
        addMapping("four", "foe");
        addAtomic("got(?! to)", "gots");
        addAtomic("aren't", "ain't");
        addMapping("young", "yung");
        addAtomic("(?<!are )you(?!')", "ya'");
        addAtomic("You(?!')", "You's");
        addMapping("first", "fust");
        addAtomic("police", "honky pigs");
        addAtomic("string", "chittlin'");
        addAtomic("read", "eyeball");
        addMapping("write", "scribble");
        addMapping("(?<![adet] )(?<![ae])th(?![i])", "d");
        addMapping("(?<![adet] )(?<![ae])Th(?![i])", "D");
        addRightAtomic("(?<!str|th)ing", "in'");
        addAtomic("a(?!\\.| the|:)", "some");
        addLeftAtomic("(?<!have |got |want |wants )to ", "t'");
        addRightAtomic("tion", "shun");
        addAtomic("almost", "mos'");
        addAtomic("from", "fum");
        addAtomic("([Yy])ou're", "$1ouse");
        addAtomic("alright|okay", "coo'");
        addRightAtomic("(?<!writ|ov|prime minist|comput|nigg|p|wat)er", "a'");
        addAtomic("known", "knode");
        addAtomic("want(?!s)(?! to)", "wants'");
        addAtomic("beat", "whup'");
        addLeftAtomic("exp", "'sp");
        addLeftAtomic("exs|exc", "'s");
        addLeftAtomic("ex(?!c|p|s)", "'es");
        addAtomic("like(?!s)", "likes");
        addAtomic("did", "dun did");
        addAtomic("kind of", "kind'a");
        addAtomic("women", "honky chicks");
        addAtomic("mens?", "dudes");
        addAtomic("dead", "wasted");
        addAtomic("good", "baaaad");
        addAtomic("open", "jimmey");
        addAtomic("opened", "jimmey'd");
        addAtomic("very", "real");
        addAtomic("per", "puh'");
        addAtomic("oar", "o'");
        addAtomic("can", "kin");
        addAtomic("just", "plum");
        addAtomic("[Dd]etroit", "Mo-town");
        addMapping("believe(?!r)", "recon'");
        addAtomic("[Ii]ndianapolis", "Nap-town");
        addAtomic("[Jj]ack", "Buckwheat");
        addAtomic("[Bb]ob", "Liva' Lips");
        addAtomic("[Pp]hil", "dat fine soul");
        addAtomic("[Mm]ark", "Amos");
        addAtomic("[Rr]obert", "Leroy");
        addAtomic("[Ss]andy", "dat fine femahnaine ladee");
        addAtomic("[Jj]ohn", "Raz'tus");
        addAtomic("[Pp]aul", "Fuh'rina");
        addAtomic("[Rr]eagan", "Kingfish");
        addAtomic("[Dd]avid", "Issac");
        addAtomic("[Rr]onald", "Rolo");
        addAtomic("[Jj]im", "Bo-Jangles");
        addAtomic("[Mm]ary", "Snow Flake");
        addAtomic("[Ll]arry", "Remus");
        addAtomic("[Mm]ohammed", "Home Boy");
        addAtomic("[Pp]ope|[Pp]ontiff", "wiz'");
        addAtomic("[Pp]ravda", "dat commie rag");
        addAtomic("broken", "bugger'd");
        addAtomic("strange", "funky");
        addAtomic("dance", "boogy");
        addAtomic("house", "crib");
        addAtomic("ask", "ax'");
        addAtomic("so", "so's");
        addAtomic("head", "'haid");
        addAtomic("(?<!my )boss", "main man");
        addAtomic("wife", "mama");
        addAtomic("money", "bre'd");
        addMapping("([a-oq-z]):", "$1, dig dis:");
        addAtomic("amateur", "begina'");
        addAtomic("radio", "transista'");
        addAtomic("(?<!sort |kind )of", "uh'");
        addAtomic("what", "whut");
        addAtomic("does", "duz");
        addAtomic("was|were", "wuz");
        addAtomic("understand( it)?", "dig it");
        addAtomic("my(?! boss)", "mah");
        addAtomic("I(?! am)", "ah'");
        addAtomic("meta", "meta-fuckin'");
        addAtomic("hair", "fro");
        addAtomic("talk", "rap");
        addAtomic("music", "beat");
        addAtomic("basket", "hoop");
        addAtomic("football", "ball");
        addAtomic("friend", "homey");
        addAtomic("school", "farm");
        addAtomic("my boss", "The Man");
        addAtomic("want to", "wanna");
        addAtomic("wants to", "be hankerin' aftah");
        addAtomic("Well", "Sheeit");
        addAtomic("well", "sheeit");
        addAtomic("big", "big-ass");
        addAtomic("bad(?! t)", "bad-ass");
        addAtomic("small", "little-ass");
        addAtomic("sort of", "radical");
        addAtomic("is(?! not)", "be");
        addAtomic("water", "booze");
        addAtomic("book", "scribblin'");
        addAtomic("magazine", "issue of GQ");
        addAtomic("paper", "sheet");
        addAtomic("up", "down");
        addAtomic("down", "waaay down");
        addAtomic("Hi", "'Sup, dude");
        addAtomic("VAX", "Pink Cadillac");
    }

    public static JiveMappings getInstance() {
        return instance;
    }

    /**
     * Used for words that are to be considered on their own.
     * <p>
     * For example a word rather than a punctuation. This also
     * prevents interword translations from happening.
     *
     * @param key   The item to be translated.
     * @param value The translation
     */
    private void addAtomic(String key, String value) {
        super.put("\\b" + key + "\\b", value);
    }

    /**
     * Used for words that could start a larger word.
     * <p>
     * For exammple given: Italian -> greaser
     * Do: Italians -> greasers
     *
     * @param key   The item to be translated.
     * @param value The translation
     */
    private void addLeftAtomic(String key, String value) {
        super.put("\\b" + key, value);
    }

    /**
     * Used for words that could end a larger word.
     * <p>
     * For example given: woman-> mama
     * Do: chairwoman -> chairmama
     *
     * @param key   The item to be translated.
     * @param value The translation
     */
    private void addRightAtomic(String key, String value) {
        super.put(key + "\\b", value);
    }

    /**
     * Used for items that cannot easily use the atomic variations.
     *
     * @param key   The item to be translated.
     * @param value The translation
     */
    private void addMapping(String key, String value) {
        super.put(key, value);
    }
}
