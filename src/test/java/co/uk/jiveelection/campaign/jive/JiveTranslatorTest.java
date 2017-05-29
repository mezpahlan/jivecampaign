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
        assertThat(jiveTranslator.translate("aaa file"), is("aaa stash"));
        assertThat(jiveTranslator.translate("file aaa"), is("stash aaa"));
        assertThat(jiveTranslator.translate("profiled"), is("profiled"));
    }

    @Test
    public void should_translate_send() {
        assertThat(jiveTranslator.translate("send"), is("t'row"));
        assertThat(jiveTranslator.translate("aaa send"), is("aaa t'row"));
        assertThat(jiveTranslator.translate("send aaa"), is("t'row aaa"));
        assertThat(jiveTranslator.translate("godsend"), is("godsend"));
    }

    @Test
    public void should_translate_program() {
        assertThat(jiveTranslator.translate("program"), is("honky code"));
        assertThat(jiveTranslator.translate("aaa program"), is("aaa honky code"));
        assertThat(jiveTranslator.translate("program aaa"), is("honky code aaa"));
        assertThat(jiveTranslator.translate("programming"), is("programming"));
    }

    @Test
    public void should_translate_atlas() {
        assertThat(jiveTranslator.translate("atlas"), is("Isaac"));
        assertThat(jiveTranslator.translate("aaa atlas"), is("aaa Isaac"));
        assertThat(jiveTranslator.translate("atlas aaa"), is("Isaac aaa"));
        assertThat(jiveTranslator.translate("atlases"), is("atlases"));
    }

    @Test
    public void should_translate_unix() {
        assertThat(jiveTranslator.translate("unix"), is("slow mo-fo"));
        assertThat(jiveTranslator.translate("aaa unix"), is("aaa slow mo-fo"));
        assertThat(jiveTranslator.translate("unix aaa"), is("slow mo-fo aaa"));
    }

    @Test
    public void should_translate_UNIX() {
        assertThat(jiveTranslator.translate("UNIX"), is("that slow mo-fo"));
        assertThat(jiveTranslator.translate("aaa UNIX"), is("aaa that slow mo-fo"));
        assertThat(jiveTranslator.translate("UNIX aaa"), is("that slow mo-fo aaa"));
    }

    @Test
    public void should_translate_take() {
        assertThat(jiveTranslator.translate("take"), is("snatch"));
        assertThat(jiveTranslator.translate("aaa take"), is("aaa snatch"));
        assertThat(jiveTranslator.translate("take aaa"), is("snatch aaa"));
        assertThat(jiveTranslator.translate("partakes"), is("partakes"));
    }

    @Test
    public void should_translate_mexican() {
        assertThat(jiveTranslator.translate("mexican"), is("wet-back"));
        assertThat(jiveTranslator.translate("aaa mexican"), is("aaa wet-back"));
        assertThat(jiveTranslator.translate("mexican aaa"), is("wet-back aaa"));
        assertThat(jiveTranslator.translate("mexicans"), is("wet-backs"));
    }

    @Test
    public void should_translate_Mexican() {
        assertThat(jiveTranslator.translate("Mexican"), is("wet-back"));
        assertThat(jiveTranslator.translate("aaa Mexican"), is("aaa wet-back"));
        assertThat(jiveTranslator.translate("Mexican aaa"), is("wet-back aaa"));
        assertThat(jiveTranslator.translate("Mexicans"), is("wet-backs"));
    }

    @Test
    public void should_translate_italian() {
        assertThat(jiveTranslator.translate("italian"), is("greaser"));
        assertThat(jiveTranslator.translate("aaa italian"), is("aaa greaser"));
        assertThat(jiveTranslator.translate("italian aaa"), is("greaser aaa"));
        assertThat(jiveTranslator.translate("italians"), is("greasers"));
    }

    @Test
    public void should_translate_Italian() {
        assertThat(jiveTranslator.translate("Italian"), is("greaser"));
        assertThat(jiveTranslator.translate("aaa Italian"), is("aaa greaser"));
        assertThat(jiveTranslator.translate("Italian aaa"), is("greaser aaa"));
        assertThat(jiveTranslator.translate("Italians"), is("greasers"));
    }

    @Test
    public void should_translate_takes() {
        assertThat(jiveTranslator.translate("takes"), is("snatch'd"));
        assertThat(jiveTranslator.translate("aaa takes"), is("aaa snatch'd"));
        assertThat(jiveTranslator.translate("takes aaa"), is("snatch'd aaa"));
        assertThat(jiveTranslator.translate("partakes"), is("partakes"));
    }

    @Test
    public void should_translate_dont() {
        assertThat(jiveTranslator.translate("don't"), is("duzn't"));
        assertThat(jiveTranslator.translate("aaa don't"), is("aaa duzn't"));
        assertThat(jiveTranslator.translate("don't aaa"), is("duzn't aaa"));
    }

    @Test
    public void should_translate_jive() {
        assertThat(jiveTranslator.translate("jive"), is("jibe"));
        assertThat(jiveTranslator.translate("aaa jive"), is("aaa jibe"));
        assertThat(jiveTranslator.translate("jive aaa"), is("jibe aaa"));
        assertThat(jiveTranslator.translate("jived"), is("jived"));
    }

    @Test
    public void should_translate_fool() {
        assertThat(jiveTranslator.translate("fool"), is("honkyfool"));
        assertThat(jiveTranslator.translate("aaa fool"), is("aaa honkyfool"));
        assertThat(jiveTranslator.translate("fool aaa"), is("honkyfool aaa"));
        assertThat(jiveTranslator.translate("foolishly"), is("foolishly"));
    }

    @Test
    public void should_translate_modem() {
        assertThat(jiveTranslator.translate("modem"), is("doodad"));
        assertThat(jiveTranslator.translate("aaa modem"), is("aaa doodad"));
        assertThat(jiveTranslator.translate("modem aaa"), is("doodad aaa"));
    }

    @Test
    public void should_translate_the_e_variation() {
        assertThat(jiveTranslator.translate("e the"), is("e da damn"));
        assertThat(jiveTranslator.translate("aaa see the"), is("aaa see da damn"));
        assertThat(jiveTranslator.translate("see the aaa"), is("see da damn aaa"));
        assertThat(jiveTranslator.translate("the"), is("the"));
        assertThat(jiveTranslator.translate(" the"), is(" the"));
    }

    @Test
    public void should_translate_the_a_variation() {
        assertThat(jiveTranslator.translate("a the"), is("a da damn"));
        assertThat(jiveTranslator.translate("aaa la the"), is("aaa la da damn"));
        assertThat(jiveTranslator.translate("la the aaa"), is("la da damn aaa"));
        assertThat(jiveTranslator.translate("the"), is("the"));
        assertThat(jiveTranslator.translate(" the"), is(" the"));
    }

    @Test
    public void should_translate_the_t_variation() {
        assertThat(jiveTranslator.translate("t the"), is("t da damn"));
        assertThat(jiveTranslator.translate("aaa cat the"), is("aaa cat da damn"));
        assertThat(jiveTranslator.translate("cat the aaa"), is("cat da damn aaa"));
        assertThat(jiveTranslator.translate("the"), is("the"));
        assertThat(jiveTranslator.translate(" the"), is(" the"));
    }

    @Test
    public void should_translate_the_d_variation() {
        assertThat(jiveTranslator.translate("d the"), is("d da damn"));
        assertThat(jiveTranslator.translate("aaa bad the"), is("aaa bad da damn"));
        assertThat(jiveTranslator.translate("bad the aaa"), is("bad da damn aaa"));
        assertThat(jiveTranslator.translate("the"), is("the"));
        assertThat(jiveTranslator.translate(" the"), is(" the"));
    }

    @Test
    public void should_translate_man() {
        assertThat(jiveTranslator.translate("man"), is("dude"));
        assertThat(jiveTranslator.translate("aaa man"), is("aaa dude"));
        assertThat(jiveTranslator.translate("man aaa"), is("dude aaa"));
        assertThat(jiveTranslator.translate("manipulated"), is("manipulated"));
    }

    @Test
    public void should_translate_woman() {
        assertThat(jiveTranslator.translate("woman"), is("mama"));
        assertThat(jiveTranslator.translate("aaa woman"), is("aaa mama"));
        assertThat(jiveTranslator.translate("woman aaa"), is("mama aaa"));
        assertThat(jiveTranslator.translate("chairwoman"), is("chairmama"));
    }

    @Test
    public void should_translate_girl() {
        assertThat(jiveTranslator.translate("girl"), is("goat"));
        assertThat(jiveTranslator.translate("aaa girl"), is("aaa goat"));
        assertThat(jiveTranslator.translate("girl aaa"), is("goat aaa"));
        assertThat(jiveTranslator.translate("girlfriends"), is("girlfriends"));
    }

    @Test
    public void should_translate_something() {
        assertThat(jiveTranslator.translate("something"), is("sump'n"));
        assertThat(jiveTranslator.translate("aaa something"), is("aaa sump'n"));
        assertThat(jiveTranslator.translate("something aaa"), is("sump'n aaa"));
    }

    @Test
    public void should_translate_lie() {
        assertThat(jiveTranslator.translate("lie"), is("honky jibe"));
        assertThat(jiveTranslator.translate("aaa lie"), is("aaa honky jibe"));
        assertThat(jiveTranslator.translate("lie aaa"), is("honky jibe aaa"));
        assertThat(jiveTranslator.translate("alien"), is("alien"));
    }

    @Test
    public void should_translate_full_stop_a_to_b_variation() {
        assertThat(jiveTranslator.translate("a."), is("a. Sheeeiit."));
        assertThat(jiveTranslator.translate("b."), is("b. Sheeeiit."));
        assertThat(jiveTranslator.translate("aaa a."), is("aaa a. Sheeeiit."));
        assertThat(jiveTranslator.translate("b. aaa"), is("b. Sheeeiit. aaa"));
    }

    @Test
    public void should_translate_full_stop_e_to_f_variation() {
        assertThat(jiveTranslator.translate("e."), is("e. What it is, Mama!"));
        assertThat(jiveTranslator.translate("f."), is("f. What it is, Mama!"));
        assertThat(jiveTranslator.translate("aaa e."), is("aaa e. What it is, Mama!"));
        assertThat(jiveTranslator.translate("f. aaa"), is("f. What it is, Mama! aaa"));
    }

    @Test
    public void should_translate_full_stop_i_to_j_variation() {
        assertThat(jiveTranslator.translate("i."), is("i. Ya' know?"));
        assertThat(jiveTranslator.translate("j."), is("j. Ya' know?"));
        assertThat(jiveTranslator.translate("aaa i."), is("aaa i. Ya' know?"));
        assertThat(jiveTranslator.translate("j. aaa"), is("j. Ya' know? aaa"));
    }

    @Test
    public void should_translate_full_stop_m_to_n_variation() {
        assertThat(jiveTranslator.translate("m."), is("m. 'S coo', bro."));
        assertThat(jiveTranslator.translate("n."), is("n. 'S coo', bro."));
        assertThat(jiveTranslator.translate("aaa m."), is("aaa m. 'S coo', bro."));
        assertThat(jiveTranslator.translate("n. aaa"), is("n. 'S coo', bro. aaa"));
    }

    @Test
    public void should_translate_full_stop_q_to_r_variation() {
        assertThat(jiveTranslator.translate("q."), is("q. Ah be baaad..."));
        assertThat(jiveTranslator.translate("r."), is("r. Ah be baaad..."));
        assertThat(jiveTranslator.translate("aaa q."), is("aaa q. Ah be baaad..."));
        assertThat(jiveTranslator.translate("r. aaa"), is("r. Ah be baaad... aaa"));
    }

    @Test
    public void should_translate_full_stop_u_to_v_variation() {
        assertThat(jiveTranslator.translate("u."), is("u. Man!"));
        assertThat(jiveTranslator.translate("v."), is("v. Man!"));
        assertThat(jiveTranslator.translate("aaa u."), is("aaa u. Man!"));
        assertThat(jiveTranslator.translate("v. aaa"), is("v. Man! aaa"));
    }

    @Test
    public void should_translate_full_stop_y_to_z_variation() {
        assertThat(jiveTranslator.translate("y."), is("y. Slap mah fro!"));
        assertThat(jiveTranslator.translate("y."), is("y. Slap mah fro!"));
        assertThat(jiveTranslator.translate("aaa y."), is("aaa y. Slap mah fro!"));
        assertThat(jiveTranslator.translate("y. aaa"), is("y. Slap mah fro! aaa"));
    }

    @Test
    public void should_translate_Sure() {
        assertThat(jiveTranslator.translate("Sure"), is("Sho' nuff"));
        assertThat(jiveTranslator.translate("aaa Sure"), is("aaa Sho' nuff"));
        assertThat(jiveTranslator.translate("Sure aaa"), is("Sho' nuff aaa"));
    }

    @Test
    public void should_translate_sure() {
        assertThat(jiveTranslator.translate("sure"), is("sho' nuff"));
        assertThat(jiveTranslator.translate("aaa sure"), is("aaa sho' nuff"));
        assertThat(jiveTranslator.translate("sure aaa"), is("sho' nuff aaa"));
        assertThat(jiveTranslator.translate("pressure"), is("pressure"));
    }

    @Test
    public void should_translate_get() {
        assertThat(jiveTranslator.translate("get"), is("git"));
        assertThat(jiveTranslator.translate("aaa get"), is("aaa git"));
        assertThat(jiveTranslator.translate("get aaa"), is("git aaa"));
        assertThat(jiveTranslator.translate("getaway"), is("gitaway"));
        assertThat(jiveTranslator.translate("forget"), is("forget"));
    }

    @Test
    public void should_translate_will_have() {
        assertThat(jiveTranslator.translate("will have"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa will have"), is("aaa gots'ta"));
        assertThat(jiveTranslator.translate("will have aaa"), is("gots'ta aaa"));
    }

    @Test
    public void should_translate_will() {
        assertThat(jiveTranslator.translate("will"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa will"), is("aaa gots'ta"));
        assertThat(jiveTranslator.translate("will aaa"), is("gots'ta aaa"));
    }

    @Test
    public void should_translate_got_to() {
        assertThat(jiveTranslator.translate("got to"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa got to"), is("aaa gots'ta"));
        assertThat(jiveTranslator.translate("got to aaa"), is("gots'ta aaa"));
    }

    @Test
    public void should_translate_I_am() {
        assertThat(jiveTranslator.translate("I am"), is("I's gots'ta be"));
        assertThat(jiveTranslator.translate("aaa I am"), is("aaa I's gots'ta be"));
        assertThat(jiveTranslator.translate("I am aaa"), is("I's gots'ta be aaa"));
    }

    @Test
    public void should_translate_am_not() {
        assertThat(jiveTranslator.translate("am not"), is("aint"));
        assertThat(jiveTranslator.translate("aaa am not"), is("aaa aint"));
        assertThat(jiveTranslator.translate("am not aaa"), is("aint aaa"));
    }

    @Test
    public void should_translate_is_not() {
        assertThat(jiveTranslator.translate("is not"), is("aint"));
        assertThat(jiveTranslator.translate("aaa is not"), is("aaa aint"));
        assertThat(jiveTranslator.translate("is not aaa"), is("aint aaa"));
    }

    @Test
    public void should_translate_are_not() {
        assertThat(jiveTranslator.translate("are not"), is("aint"));
        assertThat(jiveTranslator.translate("aaa are not"), is("aaa aint"));
        assertThat(jiveTranslator.translate("are not aaa"), is("aint aaa"));
    }

    @Test
    public void should_translate_are_your() {
        assertThat(jiveTranslator.translate("are your"), is("is yo'"));
        assertThat(jiveTranslator.translate("aaa are your"), is("aaa is yo'"));
        assertThat(jiveTranslator.translate("are your aaa"), is("is yo' aaa"));
    }

    @Test
    public void should_translate_are_you() {
        assertThat(jiveTranslator.translate("are you"), is("you is"));
        assertThat(jiveTranslator.translate("aaa are you"), is("aaa you is"));
        assertThat(jiveTranslator.translate("are you aaa"), is("you is aaa"));
    }

    @Test
    public void should_translate_hat() {
        assertThat(jiveTranslator.translate("hat"), is("fedora"));
        assertThat(jiveTranslator.translate("aaa hat"), is("aaa fedora"));
        assertThat(jiveTranslator.translate("hat aaa"), is("fedora aaa"));
        assertThat(jiveTranslator.translate("hatred"), is("hatred"));
    }

    @Test
    public void should_translate_shoe() {
        assertThat(jiveTranslator.translate("shoe"), is("kicker"));
        assertThat(jiveTranslator.translate("aaa shoe"), is("aaa kicker"));
        assertThat(jiveTranslator.translate("shoe aaa"), is("kicker aaa"));
        assertThat(jiveTranslator.translate("shoebox"), is("shoebox"));
    }

    @Test
    public void should_translate_havent() {
        assertThat(jiveTranslator.translate("haven't"), is("aint"));
        assertThat(jiveTranslator.translate("aaa haven't"), is("aaa aint"));
        assertThat(jiveTranslator.translate("haven't aaa"), is("aint aaa"));
    }

    @Test
    public void should_translate_have_to() {
        assertThat(jiveTranslator.translate("have to"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa have to"), is("aaa gots'ta"));
        assertThat(jiveTranslator.translate("have to aaa"), is("gots'ta aaa"));
    }

    @Test
    public void should_translate_have() {
        assertThat(jiveTranslator.translate("have"), is("gots'"));
        assertThat(jiveTranslator.translate("aaa have"), is("aaa gots'"));
        assertThat(jiveTranslator.translate("have aaa"), is("gots' aaa"));
    }

    @Test
    public void should_translate_has() {
        assertThat(jiveTranslator.translate("has"), is("gots'ta"));
        assertThat(jiveTranslator.translate("aaa has"), is("aaa gots'ta"));
        assertThat(jiveTranslator.translate("has aaa"), is("gots'ta aaa"));
    }

    @Test
    public void should_translate_come_over() {
        assertThat(jiveTranslator.translate("come over"), is("mosey on down"));
        assertThat(jiveTranslator.translate("aaa come over"), is("aaa mosey on down"));
        assertThat(jiveTranslator.translate("come over aaa"), is("mosey on down aaa"));
    }

    @Test
    public void should_translate_come() {
        assertThat(jiveTranslator.translate("come"), is("mosey on down"));
        assertThat(jiveTranslator.translate("aaa come"), is("aaa mosey on down"));
        assertThat(jiveTranslator.translate("come aaa"), is("mosey on down aaa"));
        assertThat(jiveTranslator.translate("outcome"), is("outcome"));
    }

    @Test
    public void should_translate_exclamation_mark() {
        assertThat(jiveTranslator.translate("!"), is(". Right On!"));
        assertThat(jiveTranslator.translate("aaa!"), is("aaa. Right On!"));
        assertThat(jiveTranslator.translate("! aaa"), is(". Right On! aaa"));
    }

    @Test
    public void should_translate_buy() {
        assertThat(jiveTranslator.translate("buy"), is("steal"));
        assertThat(jiveTranslator.translate("aaa buy"), is("aaa steal"));
        assertThat(jiveTranslator.translate("buy aaa"), is("steal aaa"));
        assertThat(jiveTranslator.translate("buyer"), is("buyer"));
    }

    @Test
    public void should_translate_car() {
        assertThat(jiveTranslator.translate("car"), is("wheels"));
        assertThat(jiveTranslator.translate("aaa car"), is("aaa wheels"));
        assertThat(jiveTranslator.translate("car aaa"), is("wheels aaa"));
        assertThat(jiveTranslator.translate("carcus"), is("carcus"));
    }

    @Test
    public void should_translate_drive() {
        assertThat(jiveTranslator.translate("drive"), is("roll"));
        assertThat(jiveTranslator.translate("aaa drive"), is("aaa roll"));
        assertThat(jiveTranslator.translate("drive aaa"), is("roll aaa"));
        assertThat(jiveTranslator.translate("screwdriver"), is("screwdriver"));
    }

    @Test
    public void should_translate_eat() {
        assertThat(jiveTranslator.translate("eat"), is("feed da bud"));
        assertThat(jiveTranslator.translate("aaa eat"), is("aaa feed da bud"));
        assertThat(jiveTranslator.translate("eat aaa"), is("feed da bud aaa"));
        assertThat(jiveTranslator.translate("concreat"), is("concreat"));
    }

    @Test
    public void should_translate_black() {
        assertThat(jiveTranslator.translate("black"), is("brother"));
        assertThat(jiveTranslator.translate("aaa black"), is("aaa brother"));
        assertThat(jiveTranslator.translate("black aaa"), is("brother aaa"));
        assertThat(jiveTranslator.translate("blackest"), is("blackest"));
    }

    @Test
    public void should_translate_negro() {
        assertThat(jiveTranslator.translate("negro"), is("brother"));
        assertThat(jiveTranslator.translate("aaa negro"), is("aaa brother"));
        assertThat(jiveTranslator.translate("negro aaa"), is("brother aaa"));
    }

    @Test
    public void should_translate_white() {
        assertThat(jiveTranslator.translate("white"), is("honky"));
        assertThat(jiveTranslator.translate("aaa white"), is("aaa honky"));
        assertThat(jiveTranslator.translate("white aaa"), is("honky aaa"));
        assertThat(jiveTranslator.translate("whiter"), is("whiter"));
    }

    @Test
    public void should_translate_nigger() {
        assertThat(jiveTranslator.translate("nigger"), is("gentleman"));
        assertThat(jiveTranslator.translate("aaa nigger"), is("aaa gentleman"));
        assertThat(jiveTranslator.translate("nigger aaa"), is("gentleman aaa"));
        assertThat(jiveTranslator.translate("niggers"), is("gentlemans"));
    }

    @Test
    public void should_translate_nice() {
        assertThat(jiveTranslator.translate("nice"), is("supa' fine"));
        assertThat(jiveTranslator.translate("aaa nice"), is("aaa supa' fine"));
        assertThat(jiveTranslator.translate("nice aaa"), is("supa' fine aaa"));
        assertThat(jiveTranslator.translate("niceties"), is("niceties"));
    }

    @Test
    public void should_translate_person() {
        assertThat(jiveTranslator.translate("person"), is("sucka'"));
        assertThat(jiveTranslator.translate("aaa person"), is("aaa sucka'"));
        assertThat(jiveTranslator.translate("person aaa"), is("sucka' aaa"));
        assertThat(jiveTranslator.translate("personalities"), is("personalities"));
    }

    @Test
    public void should_translate_persons() {
        assertThat(jiveTranslator.translate("persons"), is("sucka's"));
        assertThat(jiveTranslator.translate("aaa persons"), is("aaa sucka's"));
        assertThat(jiveTranslator.translate("persons aaa"), is("sucka's aaa"));
    }

    @Test
    public void should_translate_thing() {
        assertThat(jiveTranslator.translate("thing"), is("wahtahmellun"));
        assertThat(jiveTranslator.translate("aaa thing"), is("aaa wahtahmellun"));
        assertThat(jiveTranslator.translate("thing aaa"), is("wahtahmellun aaa"));
        assertThat(jiveTranslator.translate("clothing"), is("clothing"));
    }

    @Test
    public void should_translate_home() {
        assertThat(jiveTranslator.translate("home"), is("crib"));
        assertThat(jiveTranslator.translate("aaa home"), is("aaa crib"));
        assertThat(jiveTranslator.translate("home aaa"), is("crib aaa"));
        assertThat(jiveTranslator.translate("whomever"), is("whomever"));
    }

    @Test
    public void should_translate_name() {
        assertThat(jiveTranslator.translate("name"), is("dojigger"));
        assertThat(jiveTranslator.translate("aaa name"), is("aaa dojigger"));
        assertThat(jiveTranslator.translate("name aaa"), is("dojigger aaa"));
        assertThat(jiveTranslator.translate("tournament"), is("tournament"));
    }

    @Test
    public void should_translate_path() {
        assertThat(jiveTranslator.translate("path"), is("alley"));
        assertThat(jiveTranslator.translate("aaa path"), is("aaa alley"));
        assertThat(jiveTranslator.translate("path aaa"), is("alley aaa"));
        assertThat(jiveTranslator.translate("sociopath"), is("sociopath"));
    }

    @Test
    public void should_translate_computer() {
        assertThat(jiveTranslator.translate("computer"), is("clunker"));
        assertThat(jiveTranslator.translate("aaa computer"), is("aaa clunker"));
        assertThat(jiveTranslator.translate("computer aaa"), is("clunker aaa"));
    }

    @Test
    public void should_translate_or() {
        assertThat(jiveTranslator.translate("or"), is("o'"));
        assertThat(jiveTranslator.translate("aaa or"), is("aaa o'"));
        assertThat(jiveTranslator.translate("or aaa"), is("o' aaa"));
        assertThat(jiveTranslator.translate("orange"), is("orange"));
    }

    @Test
    public void should_translate_killed() {
        assertThat(jiveTranslator.translate("killed"), is("wasted"));
        assertThat(jiveTranslator.translate("aaa killed"), is("aaa wasted"));
        assertThat(jiveTranslator.translate("killed aaa"), is("wasted aaa"));
        assertThat(jiveTranslator.translate("skilled"), is("skilled"));
    }

    @Test
    public void should_translate_president() {
        assertThat(jiveTranslator.translate("president"), is("super-dude"));
        assertThat(jiveTranslator.translate("aaa president"), is("aaa super-dude"));
        assertThat(jiveTranslator.translate("president aaa"), is("super-dude aaa"));
        assertThat(jiveTranslator.translate("presidential"), is("presidential"));
    }

    @Test
    public void should_translate_prime_minister() {
        assertThat(jiveTranslator.translate("prime minister"), is("super honcho"));
        assertThat(jiveTranslator.translate("aaa prime minister"), is("aaa super honcho"));
        assertThat(jiveTranslator.translate("prime minister aaa"), is("super honcho aaa"));
        assertThat(jiveTranslator.translate("prime ministerial"), is("prime ministerial"));
    }

    @Test
    public void should_translate_injured() {
        assertThat(jiveTranslator.translate("injured"), is("hosed"));
        assertThat(jiveTranslator.translate("aaa injured"), is("aaa hosed"));
        assertThat(jiveTranslator.translate("injured aaa"), is("hosed aaa"));
        assertThat(jiveTranslator.translate("reinjured"), is("reinjured"));
    }

    @Test
    public void should_translate_government() {
        assertThat(jiveTranslator.translate("government"), is("guv'ment"));
        assertThat(jiveTranslator.translate("aaa government"), is("aaa guv'ment"));
        assertThat(jiveTranslator.translate("government aaa"), is("guv'ment aaa"));
        assertThat(jiveTranslator.translate("governments"), is("guv'ments"));
    }

    @Test
    public void should_translate_knew() {
        assertThat(jiveTranslator.translate("knew"), is("knowed"));
        assertThat(jiveTranslator.translate("aaa knew"), is("aaa knowed"));
        assertThat(jiveTranslator.translate("knew aaa"), is("knowed aaa"));
        assertThat(jiveTranslator.translate("misknew"), is("misknew"));
    }

    @Test
    public void should_translate_Because() {
        assertThat(jiveTranslator.translate("Because"), is("B'cuz"));
        assertThat(jiveTranslator.translate("aaa Because"), is("aaa B'cuz"));
        assertThat(jiveTranslator.translate("Because aaa"), is("B'cuz aaa"));
    }

    @Test
    public void should_translate_because() {
        assertThat(jiveTranslator.translate("because"), is("b'cuz"));
        assertThat(jiveTranslator.translate("aaa because"), is("aaa b'cuz"));
        assertThat(jiveTranslator.translate("because aaa"), is("b'cuz aaa"));
    }

    @Test
    public void should_translate_Your() {
        assertThat(jiveTranslator.translate("Your"), is("Yo'"));
        assertThat(jiveTranslator.translate("aaa Your"), is("aaa Yo'"));
        assertThat(jiveTranslator.translate("Your aaa"), is("Yo' aaa"));
        assertThat(jiveTranslator.translate("Yourself"), is("Yo'self"));
    }

    @Test
    public void should_translate_your() {
        assertThat(jiveTranslator.translate("your"), is("yo'"));
        assertThat(jiveTranslator.translate("aaa your"), is("aaa yo'"));
        assertThat(jiveTranslator.translate("your aaa"), is("yo' aaa"));
        assertThat(jiveTranslator.translate("yourself"), is("yo'self"));
    }
}
