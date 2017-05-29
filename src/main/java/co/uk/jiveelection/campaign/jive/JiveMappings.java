package co.uk.jiveelection.campaign.jive;

import java.util.HashMap;

/**
 * Mapping file for Jive speak based on the language file
 * from https://www.cs.utexas.edu/users/jbc/home/chef.html.
 * <p>
 * Seeds the mappings in the constructor.
 */
public class JiveMappings extends HashMap<String, String> {

    JiveMappings() {
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
        addAtomic("jive", "jibe");
        addAtomic("fool", "honkyfool");
        addAtomic("modem", "doodad");
        addMapping("([eatd])\\b the", "$1 da damn");
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
        addAtomic("persons", "sucka's");
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

    }

    /**
     * Used for words that are to be considered on their own.
     * <p>
     * For example a word rather than a punctuation. This also
     * prevents interword translations from happening.
     *
     * @param key   The item to be translated.
     * @param value The translation
     * @return Ignore. Do not use.
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
