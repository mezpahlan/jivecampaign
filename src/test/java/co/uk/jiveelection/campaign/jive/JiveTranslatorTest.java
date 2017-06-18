package co.uk.jiveelection.campaign.jive;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for JiveTranslator.
 */
public class JiveTranslatorTest {

    private JiveTranslatorImpl jiveTranslator;

    @Before
    public void setUp() throws Exception {
        jiveTranslator = new JiveTranslatorImpl();
    }

    @Test
    public void should_not_overwrite_previous_translations() throws Exception {
        assertThat(jiveTranslator.translate("at the pub! yeah!"), is("at da damn pub. Right On! yeah. Right On!"));
    }

    @Test
    public void should_translate_file() {
        assertThat(jiveTranslator.translate("file"), is("stash"));
        assertThat(jiveTranslator.translate("aaa file aaa"), is("aaa stash aaa"));
        assertThat(jiveTranslator.translate("profiled"), is("profiled"));
    }

    @Test
    public void should_translate_send() {
        assertThat(jiveTranslator.translate("send"), is("t'row"));
        assertThat(jiveTranslator.translate("aaa send aaa"), is("aaa t'row aaa"));
        assertThat(jiveTranslator.translate("godsend"), is("godsend"));
    }

    @Test
    public void should_translate_program() {
        assertThat(jiveTranslator.translate("program"), is("honky code"));
        assertThat(jiveTranslator.translate("aaa program aaa"), is("aaa honky code aaa"));
        assertThat(jiveTranslator.translate("programming"), is("programmin'"));
    }

    @Test
    public void should_translate_atlas() {
        assertThat(jiveTranslator.translate("atlas"), is("Isaac"));
        assertThat(jiveTranslator.translate("aaa atlas aaa"), is("aaa Isaac aaa"));
        assertThat(jiveTranslator.translate("atlases"), is("atlases"));
    }

    @Test
    public void should_translate_unix() {
        assertThat(jiveTranslator.translate("unix"), is("slow mo-fo"));
        assertThat(jiveTranslator.translate("aaa unix aaa"), is("aaa slow mo-fo aaa"));
    }

    @Test
    public void should_translate_UNIX() {
        assertThat(jiveTranslator.translate("UNIX"), is("that slow mo-fo"));
        assertThat(jiveTranslator.translate("aaa UNIX aaa"), is("aaa that slow mo-fo aaa"));
    }

    @Test
    public void should_translate_take() {
        assertThat(jiveTranslator.translate("take"), is("snatch"));
        assertThat(jiveTranslator.translate("aaa take aaa"), is("aaa snatch aaa"));
        assertThat(jiveTranslator.translate("partakes"), is("partakes"));
    }

    @Test
    public void should_translate_mexican() {
        assertThat(jiveTranslator.translate("mexican"), is("wet-back"));
        assertThat(jiveTranslator.translate("aaa mexican aaa"), is("aaa wet-back aaa"));
        assertThat(jiveTranslator.translate("mexicans"), is("wet-backs"));
    }

    @Test
    public void should_translate_Mexican() {
        assertThat(jiveTranslator.translate("Mexican"), is("wet-back"));
        assertThat(jiveTranslator.translate("aaa Mexican aaa"), is("aaa wet-back aaa"));
        assertThat(jiveTranslator.translate("Mexicans"), is("wet-backs"));
    }

    @Test
    public void should_translate_italian() {
        assertThat(jiveTranslator.translate("italian"), is("greaser"));
        assertThat(jiveTranslator.translate("aaa italian aaa"), is("aaa greaser aaa"));
        assertThat(jiveTranslator.translate("italians"), is("greasers"));
    }

    @Test
    public void should_translate_Italian() {
        assertThat(jiveTranslator.translate("Italian"), is("greaser"));
        assertThat(jiveTranslator.translate("aaa Italian aaa"), is("aaa greaser aaa"));
        assertThat(jiveTranslator.translate("Italians"), is("greasers"));
    }

    @Test
    public void should_translate_takes() {
        assertThat(jiveTranslator.translate("takes"), is("snatch'd"));
        assertThat(jiveTranslator.translate("aaa takes aaa"), is("aaa snatch'd aaa"));
        assertThat(jiveTranslator.translate("partakes"), is("partakes"));
    }

    @Test
    public void should_translate_dont() {
        assertThat(jiveTranslator.translate("don't"), is("duzn't"));
        assertThat(jiveTranslator.translate("aaa don't aaa"), is("aaa duzn't aaa"));
    }

    @Test
    public void should_translate_jive() {
        assertThat(jiveTranslator.translate("jive"), is("jibe"));
        assertThat(jiveTranslator.translate("aaa jive aaa"), is("aaa jibe aaa"));
        assertThat(jiveTranslator.translate("jived"), is("jived"));
    }

    @Test
    public void should_translate_fool() {
        assertThat(jiveTranslator.translate("fool"), is("honkyfool"));
        assertThat(jiveTranslator.translate("aaa fool aaa"), is("aaa honkyfool aaa"));
        assertThat(jiveTranslator.translate("foolishly"), is("foolishly"));
    }

    @Test
    public void should_translate_modem() {
        assertThat(jiveTranslator.translate("modem"), is("doodad"));
        assertThat(jiveTranslator.translate("aaa modem aaa"), is("aaa doodad aaa"));
    }

    @Test
    public void should_translate_the_e_variation() {
        assertThat(jiveTranslator.translate("e the"), is("e da damn"));
        assertThat(jiveTranslator.translate("aaa see the aaa"), is("aaa see da damn aaa"));
        assertThat(jiveTranslator.translate("the"), is("de"));
        assertThat(jiveTranslator.translate(" the"), is(" de"));
    }

    @Test
    public void should_translate_the_a_variation() {
        assertThat(jiveTranslator.translate("a the"), is("a da damn"));
        assertThat(jiveTranslator.translate("aaa la the aaa"), is("aaa la da damn aaa"));
        assertThat(jiveTranslator.translate("the"), is("de"));
        assertThat(jiveTranslator.translate(" the"), is(" de"));
    }

    @Test
    public void should_translate_the_t_variation() {
        assertThat(jiveTranslator.translate("t the"), is("t da damn"));
        assertThat(jiveTranslator.translate("aaa cat the aaa"), is("aaa cat da damn aaa"));
        assertThat(jiveTranslator.translate("the"), is("de"));
        assertThat(jiveTranslator.translate(" the"), is(" de"));
    }

    @Test
    public void should_translate_the_d_variation() {
        assertThat(jiveTranslator.translate("d the"), is("d da damn"));
        assertThat(jiveTranslator.translate("aaa bad the aaa"), is("aaa bad da damn aaa"));
        assertThat(jiveTranslator.translate("the"), is("de"));
        assertThat(jiveTranslator.translate(" the"), is(" de"));
    }

    @Test
    public void should_translate_man() {
        assertThat(jiveTranslator.translate("man"), is("dude"));
        assertThat(jiveTranslator.translate("aaa man aaa"), is("aaa dude aaa"));
        assertThat(jiveTranslator.translate("manipulated"), is("manipulated"));
    }

    @Test
    public void should_translate_woman() {
        assertThat(jiveTranslator.translate("woman"), is("mama"));
        assertThat(jiveTranslator.translate("aaa woman aaa"), is("aaa mama aaa"));
        assertThat(jiveTranslator.translate("chairwoman"), is("chairmama"));
    }

    @Test
    public void should_translate_girl() {
        assertThat(jiveTranslator.translate("girl"), is("goat"));
        assertThat(jiveTranslator.translate("aaa girl aaa"), is("aaa goat aaa"));
        assertThat(jiveTranslator.translate("girlfriends"), is("girlfriends"));
    }

    @Test
    public void should_translate_something() {
        assertThat(jiveTranslator.translate("something"), is("sump'n"));
        assertThat(jiveTranslator.translate("aaa something aaa"), is("aaa sump'n aaa"));
    }

    @Test
    public void should_translate_lie() {
        assertThat(jiveTranslator.translate("lie"), is("honky jibe"));
        assertThat(jiveTranslator.translate("aaa lie aaa"), is("aaa honky jibe aaa"));
        assertThat(jiveTranslator.translate("alien"), is("alien"));
    }

    @Test
    public void should_translate_full_stop_a_to_b_variation() {
        assertThat(jiveTranslator.translate("a."), is("a. Sheeeiit."));
        assertThat(jiveTranslator.translate("b."), is("b. Sheeeiit."));
        assertThat(jiveTranslator.translate("aaa a. aaa"), is("aaa a. Sheeeiit. aaa"));
        assertThat(jiveTranslator.translate("aaa b. aaa"), is("aaa b. Sheeeiit. aaa"));
    }

    @Test
    public void should_translate_full_stop_e_to_f_variation() {
        assertThat(jiveTranslator.translate("e."), is("e. What it is, Mama!"));
        assertThat(jiveTranslator.translate("f."), is("f. What it is, Mama!"));
        assertThat(jiveTranslator.translate("aaa e. aaa"), is("aaa e. What it is, Mama! aaa"));
        assertThat(jiveTranslator.translate("aaa f. aaa"), is("aaa f. What it is, Mama! aaa"));
    }

    @Test
    public void should_translate_full_stop_i_to_j_variation() {
        assertThat(jiveTranslator.translate("i."), is("i. Ya' know?"));
        assertThat(jiveTranslator.translate("j."), is("j. Ya' know?"));
        assertThat(jiveTranslator.translate("aaa i. aaa"), is("aaa i. Ya' know? aaa"));
        assertThat(jiveTranslator.translate("aaa j. aaa"), is("aaa j. Ya' know? aaa"));
    }

    @Test
    public void should_translate_full_stop_m_to_n_variation() {
        assertThat(jiveTranslator.translate("m."), is("m. 'S coo', bro."));
        assertThat(jiveTranslator.translate("n."), is("n. 'S coo', bro."));
        assertThat(jiveTranslator.translate("aaa m. aaa"), is("aaa m. 'S coo', bro. aaa"));
        assertThat(jiveTranslator.translate("aaa n. aaa"), is("aaa n. 'S coo', bro. aaa"));
    }

    @Test
    public void should_translate_full_stop_q_to_r_variation() {
        assertThat(jiveTranslator.translate("q."), is("q. Ah be baaad..."));
        assertThat(jiveTranslator.translate("r."), is("r. Ah be baaad..."));
        assertThat(jiveTranslator.translate("aaa q. aaa"), is("aaa q. Ah be baaad... aaa"));
        assertThat(jiveTranslator.translate("aaa r. aaa"), is("aaa r. Ah be baaad... aaa"));
    }

    @Test
    public void should_translate_full_stop_u_to_v_variation() {
        assertThat(jiveTranslator.translate("u."), is("u. Man!"));
        assertThat(jiveTranslator.translate("v."), is("v. Man!"));
        assertThat(jiveTranslator.translate("aaa u. aaa"), is("aaa u. Man! aaa"));
        assertThat(jiveTranslator.translate("aaa v. aaa"), is("aaa v. Man! aaa"));
    }

    @Test
    public void should_translate_full_stop_y_to_z_variation() {
        assertThat(jiveTranslator.translate("y."), is("y. Slap mah fro!"));
        assertThat(jiveTranslator.translate("z."), is("z. Slap mah fro!"));
        assertThat(jiveTranslator.translate("aaa y. aaa"), is("aaa y. Slap mah fro! aaa"));
        assertThat(jiveTranslator.translate("aaa z. aaa"), is("aaa z. Slap mah fro! aaa"));
    }

    @Test
    public void should_translate_Sure() {
        assertThat(jiveTranslator.translate("Sure"), is("Sho' nuff"));
        assertThat(jiveTranslator.translate("aaa Sure aaa"), is("aaa Sho' nuff aaa"));
    }

    @Test
    public void should_translate_sure() {
        assertThat(jiveTranslator.translate("sure"), is("sho' nuff"));
        assertThat(jiveTranslator.translate("aaa sure aaa"), is("aaa sho' nuff aaa"));
        assertThat(jiveTranslator.translate("pressure"), is("pressure"));
    }

    @Test
    public void should_translate_get() {
        assertThat(jiveTranslator.translate("get"), is("git"));
        assertThat(jiveTranslator.translate("aaa get aaa"), is("aaa git aaa"));
        assertThat(jiveTranslator.translate("getaway"), is("gitaway"));
        assertThat(jiveTranslator.translate("forget"), is("forget"));
    }

    @Test
    public void should_translate_will_have() {
        assertThat(jiveTranslator.translate("will have"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa will have aaa"), is("aaa gots'ta aaa"));
    }

    @Test
    public void should_translate_will() {
        assertThat(jiveTranslator.translate("will"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa will aaa"), is("aaa gots'ta aaa"));
    }

    @Test
    public void should_translate_got_to() {
        assertThat(jiveTranslator.translate("got to"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa got to aaa"), is("aaa gots'ta aaa"));
    }

    @Test
    public void should_translate_I_am() {
        assertThat(jiveTranslator.translate("I am"), is("I's gots'ta be"));
        assertThat(jiveTranslator.translate("aaa I am aaa"), is("aaa I's gots'ta be aaa"));
    }

    @Test
    public void should_translate_am_not() {
        assertThat(jiveTranslator.translate("am not"), is("aint"));
        assertThat(jiveTranslator.translate("aaa am not aaa"), is("aaa aint aaa"));
    }

    @Test
    public void should_translate_is_not() {
        assertThat(jiveTranslator.translate("is not"), is("aint"));
        assertThat(jiveTranslator.translate("aaa is not aaa"), is("aaa aint aaa"));
    }

    @Test
    public void should_translate_are_not() {
        assertThat(jiveTranslator.translate("are not"), is("aint"));
        assertThat(jiveTranslator.translate("aaa are not aaa"), is("aaa aint aaa"));
    }

    @Test
    public void should_translate_are_your() {
        assertThat(jiveTranslator.translate("are your"), is("is yo'"));
        assertThat(jiveTranslator.translate("aaa are your aaa"), is("aaa is yo' aaa"));
    }

    @Test
    public void should_translate_are_you() {
        assertThat(jiveTranslator.translate("are you"), is("you is"));
        assertThat(jiveTranslator.translate("aaa are you aaa"), is("aaa you is aaa"));
    }

    @Test
    public void should_translate_hat() {
        assertThat(jiveTranslator.translate("hat"), is("fedora"));
        assertThat(jiveTranslator.translate("aaa hat aaa"), is("aaa fedora aaa"));
        assertThat(jiveTranslator.translate("hatred"), is("hatred"));
    }

    @Test
    public void should_translate_shoe() {
        assertThat(jiveTranslator.translate("shoe"), is("kicker"));
        assertThat(jiveTranslator.translate("aaa shoe aaa"), is("aaa kicker aaa"));
        assertThat(jiveTranslator.translate("shoebox"), is("shoebox"));
    }

    @Test
    public void should_translate_havent() {
        assertThat(jiveTranslator.translate("haven't"), is("aint"));
        assertThat(jiveTranslator.translate("aaa haven't aaa"), is("aaa aint aaa"));
    }

    @Test
    public void should_translate_have_to() {
        assertThat(jiveTranslator.translate("have to"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa have to aaa"), is("aaa gots'ta aaa"));
    }

    @Test
    public void should_translate_have() {
        assertThat(jiveTranslator.translate("have"), is("gots'"));
        assertThat(jiveTranslator.translate("aaa have aaa"), is("aaa gots' aaa"));
    }

    @Test
    public void should_translate_has() {
        assertThat(jiveTranslator.translate("has"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa has aaa"), is("aaa gots'ta aaa"));
    }

    @Test
    public void should_translate_come_over() {
        assertThat(jiveTranslator.translate("come over"), is("mosey on down"));
        assertThat(jiveTranslator.translate("aaa come over aaa"), is("aaa mosey on down aaa"));
    }

    @Test
    public void should_translate_come() {
        assertThat(jiveTranslator.translate("come"), is("mosey on down"));
        assertThat(jiveTranslator.translate("aaa come aaa"), is("aaa mosey on down aaa"));
        assertThat(jiveTranslator.translate("outcome"), is("outcome"));
    }

    @Test
    public void should_translate_exclamation_mark() {
        assertThat(jiveTranslator.translate("!"), is(". Right On!"));
        assertThat(jiveTranslator.translate("aaa! aaa"), is("aaa. Right On! aaa"));
    }

    @Test
    public void should_translate_buy() {
        assertThat(jiveTranslator.translate("buy"), is("steal"));
        assertThat(jiveTranslator.translate("aaa buy aaa"), is("aaa steal aaa"));
        assertThat(jiveTranslator.translate("buyer"), is("buya'"));
    }

    @Test
    public void should_translate_car() {
        assertThat(jiveTranslator.translate("car"), is("wheels"));
        assertThat(jiveTranslator.translate("aaa car aaa"), is("aaa wheels aaa"));
        assertThat(jiveTranslator.translate("carcus"), is("carcus"));
    }

    @Test
    public void should_translate_drive() {
        assertThat(jiveTranslator.translate("drive"), is("roll"));
        assertThat(jiveTranslator.translate("aaa drive aaa"), is("aaa roll aaa"));
        assertThat(jiveTranslator.translate("screwdriver"), is("screwdriva'"));
    }

    @Test
    public void should_translate_eat() {
        assertThat(jiveTranslator.translate("eat"), is("feed da bud"));
        assertThat(jiveTranslator.translate("aaa eat aaa"), is("aaa feed da bud aaa"));
        assertThat(jiveTranslator.translate("concreat"), is("concreat"));
    }

    @Test
    public void should_translate_black() {
        assertThat(jiveTranslator.translate("black"), is("brother"));
        assertThat(jiveTranslator.translate("aaa black aaa"), is("aaa brother aaa"));
        assertThat(jiveTranslator.translate("blackest"), is("blackest"));
    }

    @Test
    public void should_translate_negro() {
        assertThat(jiveTranslator.translate("negro"), is("brother"));
        assertThat(jiveTranslator.translate("aaa negro aaa"), is("aaa brother aaa"));
    }

    @Test
    public void should_translate_white() {
        assertThat(jiveTranslator.translate("white"), is("honky"));
        assertThat(jiveTranslator.translate("aaa white aaa"), is("aaa honky aaa"));
        assertThat(jiveTranslator.translate("whiter"), is("whita'"));
    }

    @Test
    public void should_translate_nigger() {
        assertThat(jiveTranslator.translate("nigger"), is("gentleman"));
        assertThat(jiveTranslator.translate("aaa nigger aaa"), is("aaa gentleman aaa"));
        assertThat(jiveTranslator.translate("niggers"), is("gentlemans"));
    }

    @Test
    public void should_translate_nice() {
        assertThat(jiveTranslator.translate("nice"), is("supa' fine"));
        assertThat(jiveTranslator.translate("aaa nice aaa"), is("aaa supa' fine aaa"));
        assertThat(jiveTranslator.translate("niceties"), is("niceties"));
    }

    @Test
    public void should_translate_person() {
        assertThat(jiveTranslator.translate("person"), is("sucka'"));
        assertThat(jiveTranslator.translate("aaa person aaa"), is("aaa sucka' aaa"));
        assertThat(jiveTranslator.translate("personalities"), is("personalities"));
    }

    @Test
    public void should_translate_persons() {
        assertThat(jiveTranslator.translate("persons"), is("sucka's"));
        assertThat(jiveTranslator.translate("aaa persons aaa"), is("aaa sucka's aaa"));
    }

    @Test
    public void should_translate_thing() {
        assertThat(jiveTranslator.translate("thing"), is("wahtahmellun"));
        assertThat(jiveTranslator.translate("aaa thing aaa"), is("aaa wahtahmellun aaa"));
        assertThat(jiveTranslator.translate("clothing"), is("clothing"));
    }

    @Test
    public void should_translate_home() {
        assertThat(jiveTranslator.translate("home"), is("crib"));
        assertThat(jiveTranslator.translate("aaa home aaa"), is("aaa crib aaa"));
        assertThat(jiveTranslator.translate("whomever"), is("whomeva'"));
    }

    @Test
    public void should_translate_name() {
        assertThat(jiveTranslator.translate("name"), is("dojigger"));
        assertThat(jiveTranslator.translate("aaa name aaa"), is("aaa dojigger aaa"));
        assertThat(jiveTranslator.translate("tournament"), is("tournament"));
    }

    @Test
    public void should_translate_path() {
        assertThat(jiveTranslator.translate("path"), is("alley"));
        assertThat(jiveTranslator.translate("aaa path aaa"), is("aaa alley aaa"));
        assertThat(jiveTranslator.translate("sociopath"), is("sociopath"));
    }

    @Test
    public void should_translate_computer() {
        assertThat(jiveTranslator.translate("computer"), is("clunker"));
        assertThat(jiveTranslator.translate("aaa computer aaa"), is("aaa clunker aaa"));

    }

    @Test
    public void should_translate_or() {
        assertThat(jiveTranslator.translate("or"), is("o'"));
        assertThat(jiveTranslator.translate("aaa or aaa"), is("aaa o' aaa"));
        assertThat(jiveTranslator.translate("orange"), is("orange"));
    }

    @Test
    public void should_translate_killed() {
        assertThat(jiveTranslator.translate("killed"), is("wasted"));
        assertThat(jiveTranslator.translate("aaa killed aaa"), is("aaa wasted aaa"));
        assertThat(jiveTranslator.translate("skilled"), is("skilled"));
    }

    @Test
    public void should_translate_president() {
        assertThat(jiveTranslator.translate("president"), is("super-dude"));
        assertThat(jiveTranslator.translate("aaa president aaa"), is("aaa super-dude aaa"));
        assertThat(jiveTranslator.translate("presidential"), is("presidential"));
    }

    @Test
    public void should_translate_prime_minister() {
        assertThat(jiveTranslator.translate("prime minister"), is("super honcho"));
        assertThat(jiveTranslator.translate("aaa prime minister aaa"), is("aaa super honcho aaa"));
        assertThat(jiveTranslator.translate("prime ministerial"), is("prime ministerial"));
    }

    @Test
    public void should_translate_injured() {
        assertThat(jiveTranslator.translate("injured"), is("hosed"));
        assertThat(jiveTranslator.translate("aaa injured aaa"), is("aaa hosed aaa"));
        assertThat(jiveTranslator.translate("reinjured"), is("reinjured"));
    }

    @Test
    public void should_translate_government() {
        assertThat(jiveTranslator.translate("government"), is("guv'ment"));
        assertThat(jiveTranslator.translate("aaa government aaa"), is("aaa guv'ment aaa"));
        assertThat(jiveTranslator.translate("governments"), is("guv'ments"));
    }

    @Test
    public void should_translate_knew() {
        assertThat(jiveTranslator.translate("knew"), is("knowed"));
        assertThat(jiveTranslator.translate("aaa knew aaa"), is("aaa knowed aaa"));
        assertThat(jiveTranslator.translate("misknew"), is("misknew"));
    }

    @Test
    public void should_translate_Because() {
        assertThat(jiveTranslator.translate("Because"), is("B'cuz"));
        assertThat(jiveTranslator.translate("aaa Because aaa"), is("aaa B'cuz aaa"));
    }

    @Test
    public void should_translate_because() {
        assertThat(jiveTranslator.translate("because"), is("b'cuz"));
        assertThat(jiveTranslator.translate("aaa because aaa"), is("aaa b'cuz aaa"));
    }

    @Test
    public void should_translate_Your() {
        assertThat(jiveTranslator.translate("Your"), is("Yo'"));
        assertThat(jiveTranslator.translate("aaa Your aaa"), is("aaa Yo' aaa"));
        assertThat(jiveTranslator.translate("Yourself"), is("Yo'self"));
    }

    @Test
    public void should_translate_your() {
        assertThat(jiveTranslator.translate("your"), is("yo'"));
        assertThat(jiveTranslator.translate("aaa your aaa"), is("aaa yo' aaa"));
        assertThat(jiveTranslator.translate("yourself"), is("yo'self"));
    }

    @Test
    public void should_translate_four() {
        assertThat(jiveTranslator.translate("four"), is("foe"));
        assertThat(jiveTranslator.translate("aaa four aaa"), is("aaa foe aaa"));
        assertThat(jiveTranslator.translate("fourteen"), is("foeteen"));
    }

    @Test
    public void should_translate_got() {
        assertThat(jiveTranslator.translate("got"), is("gots"));
        assertThat(jiveTranslator.translate("aaa got aaa"), is("aaa gots aaa"));
        assertThat(jiveTranslator.translate("gothic"), is("gothic"));
    }

    @Test
    public void should_translate_arent() {
        assertThat(jiveTranslator.translate("aren't"), is("ain't"));
        assertThat(jiveTranslator.translate("aaa aren't aaa"), is("aaa ain't aaa"));
    }

    @Test
    public void should_translate_young() {
        assertThat(jiveTranslator.translate("young"), is("yung"));
        assertThat(jiveTranslator.translate("aaa young aaa"), is("aaa yung aaa"));
        assertThat(jiveTranslator.translate("youngster"), is("yungsta'"));
    }

    @Test
    public void should_translate_you() {
        assertThat(jiveTranslator.translate("you"), is("ya'"));
        assertThat(jiveTranslator.translate("aaa you aaa"), is("aaa ya' aaa"));
        assertThat(jiveTranslator.translate("yourself"), is("yo'self"));
    }

    @Test
    public void should_translate_You() {
        assertThat(jiveTranslator.translate("You"), is("You's"));
        assertThat(jiveTranslator.translate("aaa You aaa"), is("aaa You's aaa"));
        assertThat(jiveTranslator.translate("Yourself"), is("Yo'self"));
    }

    @Test
    public void should_translate_first() {
        assertThat(jiveTranslator.translate("first"), is("fust"));
        assertThat(jiveTranslator.translate("aaa first aaa"), is("aaa fust aaa"));
        assertThat(jiveTranslator.translate("firstly"), is("fustly"));
    }

    @Test
    public void should_translate_police() {
        assertThat(jiveTranslator.translate("police"), is("honky pigs"));
        assertThat(jiveTranslator.translate("aaa police aaa"), is("aaa honky pigs aaa"));
        assertThat(jiveTranslator.translate("policed"), is("policed"));
    }

    @Test
    public void should_translate_string() {
        assertThat(jiveTranslator.translate("string"), is("chittlin'"));
        assertThat(jiveTranslator.translate("aaa string aaa"), is("aaa chittlin' aaa"));
        assertThat(jiveTranslator.translate("hamstring"), is("hamstring"));
    }

    @Test
    public void should_translate_read() {
        assertThat(jiveTranslator.translate("read"), is("eyeball"));
        assertThat(jiveTranslator.translate("aaa read aaa"), is("aaa eyeball aaa"));
        assertThat(jiveTranslator.translate("readiness"), is("readiness"));
    }

    @Test
    public void should_translate_write() {
        assertThat(jiveTranslator.translate("write"), is("scribble"));
        assertThat(jiveTranslator.translate("aaa write aaa"), is("aaa scribble aaa"));
        assertThat(jiveTranslator.translate("ghostwriter"), is("ghostscribbler"));
    }

    @Test
    public void should_translate_th() {
        assertThat(jiveTranslator.translate("th"), is("d"));
        assertThat(jiveTranslator.translate("xxx th aaa"), is("xxx d aaa"));
        assertThat(jiveTranslator.translate("fifth"), is("fifd"));
        assertThat(jiveTranslator.translate("that"), is("dat"));
    }

    @Test
    public void should_translate_Th() {
        assertThat(jiveTranslator.translate("Th"), is("D"));
        assertThat(jiveTranslator.translate("xxx Th aaa"), is("xxx D aaa"));
        assertThat(jiveTranslator.translate("That"), is("Dat"));
    }

    @Test
    public void should_translate_ing() {
        assertThat(jiveTranslator.translate("ing"), is("in'"));
        assertThat(jiveTranslator.translate("aaaing aaa"), is("aaain' aaa"));
        assertThat(jiveTranslator.translate("winning"), is("winnin'"));
    }

    @Test
    public void should_translate_a() {
        assertThat(jiveTranslator.translate("a"), is("some"));
        assertThat(jiveTranslator.translate("aaa a aaa"), is("aaa some aaa"));
        assertThat(jiveTranslator.translate("awesome"), is("awesome"));
    }

    @Test
    public void should_translate_to() {
        assertThat(jiveTranslator.translate("to"), is("to"));
        assertThat(jiveTranslator.translate("aaa to aaa"), is("aaa t'aaa"));
        assertThat(jiveTranslator.translate("to town"), is("t'town"));
        assertThat(jiveTranslator.translate("too"), is("too"));
    }

    @Test
    public void should_translate_tion() {
        assertThat(jiveTranslator.translate("tion"), is("shun"));
        assertThat(jiveTranslator.translate("election"), is("elecshun"));
    }

    @Test
    public void should_translate_almost() {
        assertThat(jiveTranslator.translate("almost"), is("mos'"));
        assertThat(jiveTranslator.translate("aaa almost aaa"), is("aaa mos' aaa"));
    }

    @Test
    public void should_translate_from() {
        assertThat(jiveTranslator.translate("from"), is("fum"));
        assertThat(jiveTranslator.translate("aaa from aaa"), is("aaa fum aaa"));
        assertThat(jiveTranslator.translate("wherefrom"), is("wherefrom"));
    }

    @Test
    public void should_translate_Youre() {
        assertThat(jiveTranslator.translate("You're"), is("Youse"));
        assertThat(jiveTranslator.translate("aaa You're aaa"), is("aaa Youse aaa"));
    }

    @Test
    public void should_translate_youre() {
        assertThat(jiveTranslator.translate("you're"), is("youse"));
        assertThat(jiveTranslator.translate("aaa you're aaa"), is("aaa youse aaa"));
    }

    @Test
    public void should_translate_alright() {
        assertThat(jiveTranslator.translate("alright"), is("coo'"));
        assertThat(jiveTranslator.translate("aaa alright aaa"), is("aaa coo' aaa"));
    }

    @Test
    public void should_translate_okay() {
        assertThat(jiveTranslator.translate("okay"), is("coo'"));
        assertThat(jiveTranslator.translate("aaa okay aaa"), is("aaa coo' aaa"));
    }

    @Test
    public void should_translate_er() {
        assertThat(jiveTranslator.translate("er"), is("a'"));
        assertThat(jiveTranslator.translate("aaa er aaa"), is("aaa a' aaa"));
        assertThat(jiveTranslator.translate("winter"), is("winta'"));
        assertThat(jiveTranslator.translate("error"), is("error"));
    }

    @Test
    public void should_translate_known() {
        assertThat(jiveTranslator.translate("known"), is("knode"));
        assertThat(jiveTranslator.translate("aaa known aaa"), is("aaa knode aaa"));
    }

    @Test
    public void should_translate_want() {
        assertThat(jiveTranslator.translate("want"), is("wants'"));
        assertThat(jiveTranslator.translate("aaa want aaa"), is("aaa wants' aaa"));
    }

    @Test
    public void should_translate_beat() {
        assertThat(jiveTranslator.translate("beat"), is("whup'"));
        assertThat(jiveTranslator.translate("aaa beat aaa"), is("aaa whup' aaa"));
        assertThat(jiveTranslator.translate("beating"), is("beatin'"));
    }

    @Test
    public void should_translate_exp() {
        assertThat(jiveTranslator.translate("explain"), is("'splain"));
    }

    @Test
    public void should_translate_exs() {
        assertThat(jiveTranslator.translate("exsert"), is("'sert"));
    }

    @Test
    public void should_translate_exc() {
        assertThat(jiveTranslator.translate("exclaim"), is("'slaim"));
    }

    @Test
    public void should_translate_ex() {
        assertThat(jiveTranslator.translate("extra"), is("'estra"));
    }

    @Test
    public void should_translate_like() {
        assertThat(jiveTranslator.translate("like"), is("likes"));
        assertThat(jiveTranslator.translate("aaa like aaa"), is("aaa likes aaa"));
        assertThat(jiveTranslator.translate("likes"), is("likes"));
    }

    @Test
    public void should_translate_did() {
        assertThat(jiveTranslator.translate("did"), is("dun did"));
        assertThat(jiveTranslator.translate("aaa did aaa"), is("aaa dun did aaa"));
        assertThat(jiveTranslator.translate("candid"), is("candid"));
    }

    @Test
    public void should_translate_kind_of() {
        assertThat(jiveTranslator.translate("kind of"), is("kind'a"));
        assertThat(jiveTranslator.translate("aaa kind of aaa"), is("aaa kind'a aaa"));
        assertThat(jiveTranslator.translate("mankind offered"), is("mankind offered"));
    }

    @Test
    public void should_translate_women() {
        assertThat(jiveTranslator.translate("women"), is("honky chicks"));
        assertThat(jiveTranslator.translate("aaa women aaa"), is("aaa honky chicks aaa"));
        assertThat(jiveTranslator.translate("anchorwomen"), is("anchorwomen"));
    }

    @Test
    public void should_translate_men() {
        assertThat(jiveTranslator.translate("men"), is("dudes"));
        assertThat(jiveTranslator.translate("aaa men aaa"), is("aaa dudes aaa"));
        assertThat(jiveTranslator.translate("women"), is("honky chicks"));
    }

    @Test
    public void should_translate_mens() {
        assertThat(jiveTranslator.translate("mens"), is("dudes"));
        assertThat(jiveTranslator.translate("aaa mens aaa"), is("aaa dudes aaa"));
        assertThat(jiveTranslator.translate("anchormens"), is("anchormens"));
    }

    @Test
    public void should_translate_dead() {
        assertThat(jiveTranslator.translate("dead"), is("wasted"));
        assertThat(jiveTranslator.translate("aaa dead aaa"), is("aaa wasted aaa"));
        assertThat(jiveTranslator.translate("deadliest"), is("deadliest"));
    }

    @Test
    public void should_translate_good() {
        assertThat(jiveTranslator.translate("good"), is("baaaad"));
        assertThat(jiveTranslator.translate("aaa good aaa"), is("aaa baaaad aaa"));
        assertThat(jiveTranslator.translate("goodbye"), is("goodbye"));
    }

    @Test
    public void should_translate_open() {
        assertThat(jiveTranslator.translate("open"), is("jimmey"));
        assertThat(jiveTranslator.translate("aaa open aaa"), is("aaa jimmey aaa"));
        assertThat(jiveTranslator.translate("opened"), is("jimmey'd"));
    }

    @Test
    public void should_translate_opened() {
        assertThat(jiveTranslator.translate("opened"), is("jimmey'd"));
        assertThat(jiveTranslator.translate("aaa opened aaa"), is("aaa jimmey'd aaa"));
        assertThat(jiveTranslator.translate("unopened"), is("unopened"));
    }
}
