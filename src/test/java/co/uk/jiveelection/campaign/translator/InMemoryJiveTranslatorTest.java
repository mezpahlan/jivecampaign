package co.uk.jiveelection.campaign.translator;

import co.uk.jiveelection.campaign.output.twitter.EntitiesModel;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for InMemoryJiveTranslator.
 */
public class InMemoryJiveTranslatorTest {

    private JiveTranslator jiveTranslator;

    @Before
    public void setUp() throws Exception {
        jiveTranslator = new InMemoryJiveTranslator();
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
        assertThat(jiveTranslator.translate("translator"), is("jibe"));
        assertThat(jiveTranslator.translate("aaa translator aaa"), is("aaa jibe aaa"));
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
        assertThat(jiveTranslator.translate("better."), is("better. Ah be baaad..."));
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

    @Test
    public void should_translate_very() {
        assertThat(jiveTranslator.translate("very"), is("real"));
        assertThat(jiveTranslator.translate("aaa very aaa"), is("aaa real aaa"));
        assertThat(jiveTranslator.translate("avery"), is("avery"));
    }

    @Test
    public void should_translate_per() {
        assertThat(jiveTranslator.translate("per"), is("puh'"));
        assertThat(jiveTranslator.translate("aaa per aaa"), is("aaa puh' aaa"));
        assertThat(jiveTranslator.translate("copper"), is("copper"));
    }

    @Test
    public void should_translate_oar() {
        assertThat(jiveTranslator.translate("oar"), is("o'"));
        assertThat(jiveTranslator.translate("aaa oar aaa"), is("aaa o' aaa"));
        assertThat(jiveTranslator.translate("soar"), is("soar"));
    }

    @Test
    public void should_translate_can() {
        assertThat(jiveTranslator.translate("can"), is("kin"));
        assertThat(jiveTranslator.translate("aaa can aaa"), is("aaa kin aaa"));
        assertThat(jiveTranslator.translate("uncanny"), is("uncanny"));
    }

    @Test
    public void should_translate_just() {
        assertThat(jiveTranslator.translate("just"), is("plum"));
        assertThat(jiveTranslator.translate("aaa just aaa"), is("aaa plum aaa"));
        assertThat(jiveTranslator.translate("adjust"), is("adjust"));
    }

    @Test
    public void should_translate_Detroit() {
        assertThat(jiveTranslator.translate("Detroit"), is("Mo-town"));
        assertThat(jiveTranslator.translate("aaa Detroit aaa"), is("aaa Mo-town aaa"));
    }

    @Test
    public void should_translate_detroit() {
        assertThat(jiveTranslator.translate("detroit"), is("Mo-town"));
        assertThat(jiveTranslator.translate("aaa detroit aaa"), is("aaa Mo-town aaa"));
    }

    @Test
    public void should_translate_believe() {
        assertThat(jiveTranslator.translate("believe"), is("recon'"));
        assertThat(jiveTranslator.translate("aaa believe aaa"), is("aaa recon' aaa"));
        assertThat(jiveTranslator.translate("believes"), is("recon's"));
    }

    @Test
    public void should_translate_Indianapolis() {
        assertThat(jiveTranslator.translate("Indianapolis"), is("Nap-town"));
        assertThat(jiveTranslator.translate("aaa Indianapolis aaa"), is("aaa Nap-town aaa"));
    }

    @Test
    public void should_translate_indianapolis() {
        assertThat(jiveTranslator.translate("indianapolis"), is("Nap-town"));
        assertThat(jiveTranslator.translate("aaa indianapolis aaa"), is("aaa Nap-town aaa"));
    }

    @Test
    public void should_translate_Jack() {
        assertThat(jiveTranslator.translate("Jack"), is("Buckwheat"));
        assertThat(jiveTranslator.translate("aaa Jack aaa"), is("aaa Buckwheat aaa"));
        assertThat(jiveTranslator.translate("Jackal"), is("Jackal"));
    }

    @Test
    public void should_translate_jack() {
        assertThat(jiveTranslator.translate("jack"), is("Buckwheat"));
        assertThat(jiveTranslator.translate("aaa jack aaa"), is("aaa Buckwheat aaa"));
        assertThat(jiveTranslator.translate("jackal"), is("jackal"));
    }

    @Test
    public void should_translate_Bob() {
        assertThat(jiveTranslator.translate("Bob"), is("Liva' Lips"));
        assertThat(jiveTranslator.translate("aaa Bob aaa"), is("aaa Liva' Lips aaa"));
        assertThat(jiveTranslator.translate("Bobby"), is("Bobby"));
    }

    @Test
    public void should_translate_bob() {
        assertThat(jiveTranslator.translate("bob"), is("Liva' Lips"));
        assertThat(jiveTranslator.translate("aaa bob aaa"), is("aaa Liva' Lips aaa"));
        assertThat(jiveTranslator.translate("bobby"), is("bobby"));
    }

    @Test
    public void should_translate_Phil() {
        assertThat(jiveTranslator.translate("Phil"), is("dat fine soul"));
        assertThat(jiveTranslator.translate("aaa Phil aaa"), is("aaa dat fine soul aaa"));
        assertThat(jiveTranslator.translate("Phillip"), is("Phillip"));
    }

    @Test
    public void should_translate_phil() {
        assertThat(jiveTranslator.translate("phil"), is("dat fine soul"));
        assertThat(jiveTranslator.translate("aaa phil aaa"), is("aaa dat fine soul aaa"));
        assertThat(jiveTranslator.translate("Phillip"), is("Phillip"));
    }

    @Test
    public void should_translate_Mark() {
        assertThat(jiveTranslator.translate("Mark"), is("Amos"));
        assertThat(jiveTranslator.translate("aaa Mark aaa"), is("aaa Amos aaa"));
        assertThat(jiveTranslator.translate("Marking"), is("Markin'"));
    }

    @Test
    public void should_translate_mark() {
        assertThat(jiveTranslator.translate("mark"), is("Amos"));
        assertThat(jiveTranslator.translate("aaa mark aaa"), is("aaa Amos aaa"));
        assertThat(jiveTranslator.translate("marking"), is("markin'"));
    }

    @Test
    public void should_translate_Robert() {
        assertThat(jiveTranslator.translate("Robert"), is("Leroy"));
        assertThat(jiveTranslator.translate("aaa Robert aaa"), is("aaa Leroy aaa"));
        assertThat(jiveTranslator.translate("Roberto"), is("Roberto"));
    }

    @Test
    public void should_translate_robert() {
        assertThat(jiveTranslator.translate("robert"), is("Leroy"));
        assertThat(jiveTranslator.translate("aaa robert aaa"), is("aaa Leroy aaa"));
        assertThat(jiveTranslator.translate("roberto"), is("roberto"));
    }

    @Test
    public void should_translate_Sandy() {
        assertThat(jiveTranslator.translate("Sandy"), is("dat fine femahnaine ladee"));
        assertThat(jiveTranslator.translate("aaa Sandy aaa"), is("aaa dat fine femahnaine ladee aaa"));
        assertThat(jiveTranslator.translate("aaaSandyaaa"), is("aaaSandyaaa"));
    }

    @Test
    public void should_translate_sandy() {
        assertThat(jiveTranslator.translate("sandy"), is("dat fine femahnaine ladee"));
        assertThat(jiveTranslator.translate("aaa sandy aaa"), is("aaa dat fine femahnaine ladee aaa"));
        assertThat(jiveTranslator.translate("aaasandyaaa"), is("aaasandyaaa"));
    }

    @Test
    public void should_translate_John() {
        assertThat(jiveTranslator.translate("John"), is("Raz'tus"));
        assertThat(jiveTranslator.translate("aaa John aaa"), is("aaa Raz'tus aaa"));
        assertThat(jiveTranslator.translate("Johnny"), is("Johnny"));
    }

    @Test
    public void should_translate_john() {
        assertThat(jiveTranslator.translate("john"), is("Raz'tus"));
        assertThat(jiveTranslator.translate("aaa john aaa"), is("aaa Raz'tus aaa"));
        assertThat(jiveTranslator.translate("johnny"), is("johnny"));
    }

    @Test
    public void should_translate_Paul() {
        assertThat(jiveTranslator.translate("Paul"), is("Fuh'rina"));
        assertThat(jiveTranslator.translate("aaa Paul aaa"), is("aaa Fuh'rina aaa"));
        assertThat(jiveTranslator.translate("Paula"), is("Paula"));
    }

    @Test
    public void should_translate_paul() {
        assertThat(jiveTranslator.translate("paul"), is("Fuh'rina"));
        assertThat(jiveTranslator.translate("aaa paul aaa"), is("aaa Fuh'rina aaa"));
        assertThat(jiveTranslator.translate("paula"), is("paula"));
    }

    @Test
    public void should_translate_Reagan() {
        assertThat(jiveTranslator.translate("Reagan"), is("Kingfish"));
        assertThat(jiveTranslator.translate("aaa Reagan aaa"), is("aaa Kingfish aaa"));
        assertThat(jiveTranslator.translate("reaganomics"), is("reaganomics"));
    }

    @Test
    public void should_translate_reagan() {
        assertThat(jiveTranslator.translate("reagan"), is("Kingfish"));
        assertThat(jiveTranslator.translate("aaa reagan aaa"), is("aaa Kingfish aaa"));
        assertThat(jiveTranslator.translate("reaganomics"), is("reaganomics"));
    }

    @Test
    public void should_translate_David() {
        assertThat(jiveTranslator.translate("David"), is("Issac"));
        assertThat(jiveTranslator.translate("aaa David aaa"), is("aaa Issac aaa"));
        assertThat(jiveTranslator.translate("aaaDavidaaa"), is("aaaDavidaaa"));
    }

    @Test
    public void should_translate_david() {
        assertThat(jiveTranslator.translate("david"), is("Issac"));
        assertThat(jiveTranslator.translate("aaa david aaa"), is("aaa Issac aaa"));
        assertThat(jiveTranslator.translate("aaadavidaaa"), is("aaadavidaaa"));
    }

    @Test
    public void should_translate_Ronald() {
        assertThat(jiveTranslator.translate("Ronald"), is("Rolo"));
        assertThat(jiveTranslator.translate("aaa Ronald aaa"), is("aaa Rolo aaa"));
        assertThat(jiveTranslator.translate("aaaRonaldaaa"), is("aaaRonaldaaa"));
    }

    @Test
    public void should_translate_ronald() {
        assertThat(jiveTranslator.translate("ronald"), is("Rolo"));
        assertThat(jiveTranslator.translate("aaa ronald aaa"), is("aaa Rolo aaa"));
        assertThat(jiveTranslator.translate("aaaronaldaaa"), is("aaaronaldaaa"));
    }

    @Test
    public void should_translate_Jim() {
        assertThat(jiveTranslator.translate("Jim"), is("Bo-Jangles"));
        assertThat(jiveTranslator.translate("aaa Jim aaa"), is("aaa Bo-Jangles aaa"));
        assertThat(jiveTranslator.translate("Jimmy"), is("Jimmy"));
    }

    @Test
    public void should_translate_jim() {
        assertThat(jiveTranslator.translate("jim"), is("Bo-Jangles"));
        assertThat(jiveTranslator.translate("aaa jim aaa"), is("aaa Bo-Jangles aaa"));
        assertThat(jiveTranslator.translate("jimmy"), is("jimmy"));
    }

    @Test
    public void should_translate_Mary() {
        assertThat(jiveTranslator.translate("Mary"), is("Snow Flake"));
        assertThat(jiveTranslator.translate("aaa Mary aaa"), is("aaa Snow Flake aaa"));
        assertThat(jiveTranslator.translate("Maryanne"), is("Maryanne"));
    }

    @Test
    public void should_translate_mary() {
        assertThat(jiveTranslator.translate("mary"), is("Snow Flake"));
        assertThat(jiveTranslator.translate("aaa mary aaa"), is("aaa Snow Flake aaa"));
        assertThat(jiveTranslator.translate("maryanne"), is("maryanne"));
    }

    @Test
    public void should_translate_Larry() {
        assertThat(jiveTranslator.translate("Larry"), is("Remus"));
        assertThat(jiveTranslator.translate("aaa Larry aaa"), is("aaa Remus aaa"));
        assertThat(jiveTranslator.translate("unLarryny"), is("unLarryny"));
    }

    @Test
    public void should_translate_larry() {
        assertThat(jiveTranslator.translate("larry"), is("Remus"));
        assertThat(jiveTranslator.translate("aaa larry aaa"), is("aaa Remus aaa"));
        assertThat(jiveTranslator.translate("unlarryny"), is("unlarryny"));
    }

    @Test
    public void should_translate_Mohammed() {
        assertThat(jiveTranslator.translate("Mohammed"), is("Home Boy"));
        assertThat(jiveTranslator.translate("aaa Mohammed aaa"), is("aaa Home Boy aaa"));
        assertThat(jiveTranslator.translate("unMohammedny"), is("unMohammedny"));
    }

    @Test
    public void should_translate_mohammed() {
        assertThat(jiveTranslator.translate("mohammed"), is("Home Boy"));
        assertThat(jiveTranslator.translate("aaa mohammed aaa"), is("aaa Home Boy aaa"));
        assertThat(jiveTranslator.translate("unmohammedny"), is("unmohammedny"));
    }

    @Test
    public void should_translate_Pope() {
        assertThat(jiveTranslator.translate("Pope"), is("wiz'"));
        assertThat(jiveTranslator.translate("aaa Pope aaa"), is("aaa wiz' aaa"));
        assertThat(jiveTranslator.translate("unPopeny"), is("unPopeny"));
    }

    @Test
    public void should_translate_pope() {
        assertThat(jiveTranslator.translate("pope"), is("wiz'"));
        assertThat(jiveTranslator.translate("aaa pope aaa"), is("aaa wiz' aaa"));
        assertThat(jiveTranslator.translate("unpopeny"), is("unpopeny"));
    }

    @Test
    public void should_translate_Pontiff() {
        assertThat(jiveTranslator.translate("Pontiff"), is("wiz'"));
        assertThat(jiveTranslator.translate("aaa Pontiff aaa"), is("aaa wiz' aaa"));
        assertThat(jiveTranslator.translate("unPontiffny"), is("unPontiffny"));
    }

    @Test
    public void should_translate_pontiff() {
        assertThat(jiveTranslator.translate("pontiff"), is("wiz'"));
        assertThat(jiveTranslator.translate("aaa pontiff aaa"), is("aaa wiz' aaa"));
        assertThat(jiveTranslator.translate("unpontiffny"), is("unpontiffny"));
    }

    @Test
    public void should_translate_Pravda() {
        assertThat(jiveTranslator.translate("Pravda"), is("dat commie rag"));
        assertThat(jiveTranslator.translate("aaa Pravda aaa"), is("aaa dat commie rag aaa"));
        assertThat(jiveTranslator.translate("unPravdany"), is("unPravdany"));
    }

    @Test
    public void should_translate_pravda() {
        assertThat(jiveTranslator.translate("pravda"), is("dat commie rag"));
        assertThat(jiveTranslator.translate("aaa pravda aaa"), is("aaa dat commie rag aaa"));
        assertThat(jiveTranslator.translate("unpravdany"), is("unpravdany"));
    }

    @Test
    public void should_translate_broken() {
        assertThat(jiveTranslator.translate("broken"), is("bugger'd"));
        assertThat(jiveTranslator.translate("aaa broken aaa"), is("aaa bugger'd aaa"));
        assertThat(jiveTranslator.translate("unbrokenny"), is("unbrokenny"));
    }

    @Test
    public void should_translate_strange() {
        assertThat(jiveTranslator.translate("strange"), is("funky"));
        assertThat(jiveTranslator.translate("aaa strange aaa"), is("aaa funky aaa"));
        assertThat(jiveTranslator.translate("unstrangeny"), is("unstrangeny"));
    }

    @Test
    public void should_translate_dance() {
        assertThat(jiveTranslator.translate("dance"), is("boogy"));
        assertThat(jiveTranslator.translate("aaa dance aaa"), is("aaa boogy aaa"));
        assertThat(jiveTranslator.translate("undanceny"), is("undanceny"));
    }

    @Test
    public void should_translate_house() {
        assertThat(jiveTranslator.translate("house"), is("crib"));
        assertThat(jiveTranslator.translate("aaa house aaa"), is("aaa crib aaa"));
        assertThat(jiveTranslator.translate("unhouseny"), is("unhouseny"));
    }

    @Test
    public void should_translate_ask() {
        assertThat(jiveTranslator.translate("ask"), is("ax'"));
        assertThat(jiveTranslator.translate("aaa ask aaa"), is("aaa ax' aaa"));
        assertThat(jiveTranslator.translate("unaskny"), is("unaskny"));
    }

    @Test
    public void should_translate_so() {
        assertThat(jiveTranslator.translate("so"), is("so's"));
        assertThat(jiveTranslator.translate("aaa so aaa"), is("aaa so's aaa"));
        assertThat(jiveTranslator.translate("unsony"), is("unsony"));
    }

    @Test
    public void should_translate_head() {
        assertThat(jiveTranslator.translate("head"), is("'haid"));
        assertThat(jiveTranslator.translate("aaa head aaa"), is("aaa 'haid aaa"));
        assertThat(jiveTranslator.translate("unheadny"), is("unheadny"));
    }

    @Test
    public void should_translate_boss() {
        assertThat(jiveTranslator.translate("boss"), is("main man"));
        assertThat(jiveTranslator.translate("aaa boss aaa"), is("aaa main man aaa"));
        assertThat(jiveTranslator.translate("unbossny"), is("unbossny"));
    }

    @Test
    public void should_translate_wife() {
        assertThat(jiveTranslator.translate("wife"), is("mama"));
        assertThat(jiveTranslator.translate("aaa wife aaa"), is("aaa mama aaa"));
        assertThat(jiveTranslator.translate("unwifeny"), is("unwifeny"));
    }

    @Test
    public void should_translate_people() {
        assertThat(jiveTranslator.translate("people"), is("sucka's"));
        assertThat(jiveTranslator.translate("aaa people aaa"), is("aaa sucka's aaa"));
        assertThat(jiveTranslator.translate("unpeopleny"), is("unpeopleny"));
    }

    @Test
    public void should_translate_money() {
        assertThat(jiveTranslator.translate("money"), is("bre'd"));
        assertThat(jiveTranslator.translate("aaa money aaa"), is("aaa bre'd aaa"));
        assertThat(jiveTranslator.translate("unmoneyny"), is("unmoneyny"));
    }

    @Test
    public void should_translate_colon() {
        assertThat(jiveTranslator.translate("a:"), is("a, dig dis:"));
        assertThat(jiveTranslator.translate("b:"), is("b, dig dis:"));
        assertThat(jiveTranslator.translate("c:"), is("c, dig dis:"));
        assertThat(jiveTranslator.translate("d:"), is("d, dig dis:"));
        assertThat(jiveTranslator.translate("e:"), is("e, dig dis:"));
        assertThat(jiveTranslator.translate("f:"), is("f, dig dis:"));
        assertThat(jiveTranslator.translate("g:"), is("g, dig dis:"));
        assertThat(jiveTranslator.translate("h:"), is("h, dig dis:"));
        assertThat(jiveTranslator.translate("i:"), is("i, dig dis:"));
        assertThat(jiveTranslator.translate("j:"), is("j, dig dis:"));
        assertThat(jiveTranslator.translate("k:"), is("k, dig dis:"));
        assertThat(jiveTranslator.translate("l:"), is("l, dig dis:"));
        assertThat(jiveTranslator.translate("m:"), is("m, dig dis:"));
        assertThat(jiveTranslator.translate("n:"), is("n, dig dis:"));
        assertThat(jiveTranslator.translate("o:"), is("o, dig dis:"));
        assertThat(jiveTranslator.translate("http:"), is("http:"));
        assertThat(jiveTranslator.translate("q:"), is("q, dig dis:"));
        assertThat(jiveTranslator.translate("r:"), is("r, dig dis:"));
        assertThat(jiveTranslator.translate("https:"), is("https:"));
        assertThat(jiveTranslator.translate("t:"), is("t, dig dis:"));
        assertThat(jiveTranslator.translate("u:"), is("u, dig dis:"));
        assertThat(jiveTranslator.translate("v:"), is("v, dig dis:"));
        assertThat(jiveTranslator.translate("w:"), is("w, dig dis:"));
        assertThat(jiveTranslator.translate("x:"), is("x, dig dis:"));
        assertThat(jiveTranslator.translate("y:"), is("y, dig dis:"));
        assertThat(jiveTranslator.translate("z:"), is("z, dig dis:"));
    }

    @Test
    public void should_translate_amateur() {
        assertThat(jiveTranslator.translate("amateur"), is("begina'"));
        assertThat(jiveTranslator.translate("aaa amateur aaa"), is("aaa begina' aaa"));
        assertThat(jiveTranslator.translate("unamateurny"), is("unamateurny"));
    }

    @Test
    public void should_translate_radio() {
        assertThat(jiveTranslator.translate("radio"), is("transista'"));
        assertThat(jiveTranslator.translate("aaa radio aaa"), is("aaa transista' aaa"));
        assertThat(jiveTranslator.translate("unradiony"), is("unradiony"));
    }

    @Test
    public void should_translate_of() {
        assertThat(jiveTranslator.translate("of"), is("uh'"));
        assertThat(jiveTranslator.translate("aaa of aaa"), is("aaa uh' aaa"));
        assertThat(jiveTranslator.translate("unofny"), is("unofny"));
    }

    @Test
    public void should_translate_what() {
        assertThat(jiveTranslator.translate("what"), is("whut"));
        assertThat(jiveTranslator.translate("aaa what aaa"), is("aaa whut aaa"));
        assertThat(jiveTranslator.translate("unwhatny"), is("unwhatny"));
    }

    @Test
    public void should_translate_does() {
        assertThat(jiveTranslator.translate("does"), is("duz"));
        assertThat(jiveTranslator.translate("aaa does aaa"), is("aaa duz aaa"));
        assertThat(jiveTranslator.translate("undoesny"), is("undoesny"));
    }

    @Test
    public void should_translate_was() {
        assertThat(jiveTranslator.translate("was"), is("wuz"));
        assertThat(jiveTranslator.translate("aaa was aaa"), is("aaa wuz aaa"));
        assertThat(jiveTranslator.translate("unwasny"), is("unwasny"));
    }

    @Test
    public void should_translate_were() {
        assertThat(jiveTranslator.translate("were"), is("wuz"));
        assertThat(jiveTranslator.translate("aaa were aaa"), is("aaa wuz aaa"));
        assertThat(jiveTranslator.translate("unwereny"), is("unwereny"));
    }

    @Test
    public void should_translate_understand() {
        assertThat(jiveTranslator.translate("understand"), is("dig it"));
        assertThat(jiveTranslator.translate("aaa understand aaa"), is("aaa dig it aaa"));
        assertThat(jiveTranslator.translate("ununderstandny"), is("ununderstandny"));
    }

    @Test
    public void should_translate_understand_it() {
        assertThat(jiveTranslator.translate("understand it"), is("dig it"));
        assertThat(jiveTranslator.translate("aaa understand it aaa"), is("aaa dig it aaa"));
        assertThat(jiveTranslator.translate("ununderstand itny"), is("ununderstand itny"));
    }

    @Test
    public void should_translate_my() {
        assertThat(jiveTranslator.translate("my"), is("mah"));
        assertThat(jiveTranslator.translate("aaa my aaa"), is("aaa mah aaa"));
        assertThat(jiveTranslator.translate("unmyny"), is("unmyny"));
    }

    @Test
    public void should_translate_I() {
        assertThat(jiveTranslator.translate("I"), is("ah'"));
        assertThat(jiveTranslator.translate("aaa I aaa"), is("aaa ah' aaa"));
        assertThat(jiveTranslator.translate("unIny"), is("unIny"));
    }

    @Test
    public void should_translate_meta() {
        assertThat(jiveTranslator.translate("meta"), is("meta-fuckin'"));
        assertThat(jiveTranslator.translate("aaa meta aaa"), is("aaa meta-fuckin' aaa"));
        assertThat(jiveTranslator.translate("unmetany"), is("unmetany"));
    }

    @Test
    public void should_translate_hair() {
        assertThat(jiveTranslator.translate("hair"), is("fro"));
        assertThat(jiveTranslator.translate("aaa hair aaa"), is("aaa fro aaa"));
        assertThat(jiveTranslator.translate("unhairny"), is("unhairny"));
    }

    @Test
    public void should_translate_talk() {
        assertThat(jiveTranslator.translate("talk"), is("rap"));
        assertThat(jiveTranslator.translate("aaa talk aaa"), is("aaa rap aaa"));
        assertThat(jiveTranslator.translate("untalkny"), is("untalkny"));
    }

    @Test
    public void should_translate_music() {
        assertThat(jiveTranslator.translate("music"), is("beat"));
        assertThat(jiveTranslator.translate("aaa music aaa"), is("aaa beat aaa"));
        assertThat(jiveTranslator.translate("unmusicny"), is("unmusicny"));
    }

    @Test
    public void should_translate_basket() {
        assertThat(jiveTranslator.translate("basket"), is("hoop"));
        assertThat(jiveTranslator.translate("aaa basket aaa"), is("aaa hoop aaa"));
        assertThat(jiveTranslator.translate("unbasketny"), is("unbasketny"));
    }

    @Test
    public void should_translate_football() {
        assertThat(jiveTranslator.translate("football"), is("ball"));
        assertThat(jiveTranslator.translate("aaa football aaa"), is("aaa ball aaa"));
        assertThat(jiveTranslator.translate("unfootballny"), is("unfootballny"));
    }

    @Test
    public void should_translate_friend() {
        assertThat(jiveTranslator.translate("friend"), is("homey"));
        assertThat(jiveTranslator.translate("aaa friend aaa"), is("aaa homey aaa"));
        assertThat(jiveTranslator.translate("unfriendny"), is("unfriendny"));
    }

    @Test
    public void should_translate_school() {
        assertThat(jiveTranslator.translate("school"), is("farm"));
        assertThat(jiveTranslator.translate("aaa school aaa"), is("aaa farm aaa"));
        assertThat(jiveTranslator.translate("unschoolny"), is("unschoolny"));
    }

    @Test
    public void should_translate_my_boss() {
        assertThat(jiveTranslator.translate("my boss"), is("The Man"));
        assertThat(jiveTranslator.translate("aaa my boss aaa"), is("aaa The Man aaa"));
        assertThat(jiveTranslator.translate("unmy bossny"), is("unmy bossny"));
    }

    @Test
    public void should_translate_want_to() {
        assertThat(jiveTranslator.translate("want to"), is("wanna"));
        assertThat(jiveTranslator.translate("aaa want to aaa"), is("aaa wanna aaa"));
        assertThat(jiveTranslator.translate("unwant tony"), is("unwant tony"));
    }

    @Test
    public void should_translate_wants_to() {
        assertThat(jiveTranslator.translate("wants to"), is("be hankerin' aftah"));
        assertThat(jiveTranslator.translate("aaa wants to aaa"), is("aaa be hankerin' aftah aaa"));
        assertThat(jiveTranslator.translate("unwants tony"), is("unwants tony"));
    }

    @Test
    public void should_translate_Well() {
        assertThat(jiveTranslator.translate("Well"), is("Sheeit"));
        assertThat(jiveTranslator.translate("aaa Well aaa"), is("aaa Sheeit aaa"));
        assertThat(jiveTranslator.translate("unWellny"), is("unWellny"));
    }

    @Test
    public void should_translate_well() {
        assertThat(jiveTranslator.translate("well"), is("sheeit"));
        assertThat(jiveTranslator.translate("aaa well aaa"), is("aaa sheeit aaa"));
        assertThat(jiveTranslator.translate("unwellny"), is("unwellny"));
    }

    @Test
    public void should_translate_big() {
        assertThat(jiveTranslator.translate("big"), is("big-ass"));
        assertThat(jiveTranslator.translate("aaa big aaa"), is("aaa big-ass aaa"));
        assertThat(jiveTranslator.translate("unbigny"), is("unbigny"));
    }

    @Test
    public void should_translate_bad() {
        assertThat(jiveTranslator.translate("bad"), is("bad-ass"));
        assertThat(jiveTranslator.translate("aaa bad aaa"), is("aaa bad-ass aaa"));
        assertThat(jiveTranslator.translate("unbadny"), is("unbadny"));
    }

    @Test
    public void should_translate_small() {
        assertThat(jiveTranslator.translate("small"), is("little-ass"));
        assertThat(jiveTranslator.translate("aaa small aaa"), is("aaa little-ass aaa"));
        assertThat(jiveTranslator.translate("unsmallny"), is("unsmallny"));
    }

    @Test
    public void should_translate_sort_of() {
        assertThat(jiveTranslator.translate("sort of"), is("radical"));
        assertThat(jiveTranslator.translate("aaa sort of aaa"), is("aaa radical aaa"));
        assertThat(jiveTranslator.translate("unsort ofny"), is("unsort ofny"));
    }

    @Test
    public void should_translate_is() {
        assertThat(jiveTranslator.translate("is"), is("be"));
        assertThat(jiveTranslator.translate("aaa is aaa"), is("aaa be aaa"));
        assertThat(jiveTranslator.translate("unisny"), is("unisny"));
    }

    @Test
    public void should_translate_water() {
        assertThat(jiveTranslator.translate("water"), is("booze"));
        assertThat(jiveTranslator.translate("aaa water aaa"), is("aaa booze aaa"));
        assertThat(jiveTranslator.translate("unwaterny"), is("unwaterny"));
    }

    @Test
    public void should_translate_book() {
        assertThat(jiveTranslator.translate("book"), is("scribblin'"));
        assertThat(jiveTranslator.translate("aaa book aaa"), is("aaa scribblin' aaa"));
        assertThat(jiveTranslator.translate("unbookny"), is("unbookny"));
    }

    @Test
    public void should_translate_magazine() {
        assertThat(jiveTranslator.translate("magazine"), is("issue of GQ"));
        assertThat(jiveTranslator.translate("aaa magazine aaa"), is("aaa issue of GQ aaa"));
        assertThat(jiveTranslator.translate("unmagazineny"), is("unmagazineny"));
    }

    @Test
    public void should_translate_paper() {
        assertThat(jiveTranslator.translate("paper"), is("sheet"));
        assertThat(jiveTranslator.translate("aaa paper aaa"), is("aaa sheet aaa"));
        assertThat(jiveTranslator.translate("unpaperny"), is("unpaperny"));
    }

    @Test
    public void should_translate_up() {
        assertThat(jiveTranslator.translate("up"), is("down"));
        assertThat(jiveTranslator.translate("aaa up aaa"), is("aaa down aaa"));
        assertThat(jiveTranslator.translate("unupny"), is("unupny"));
    }

    @Test
    public void should_translate_down() {
        assertThat(jiveTranslator.translate("down"), is("waaay down"));
        assertThat(jiveTranslator.translate("aaa down aaa"), is("aaa waaay down aaa"));
        assertThat(jiveTranslator.translate("undownny"), is("undownny"));
    }

    @Test
    public void should_translate_Hi() {
        assertThat(jiveTranslator.translate("Hi"), is("'Sup, dude"));
        assertThat(jiveTranslator.translate("aaa Hi aaa"), is("aaa 'Sup, dude aaa"));
        assertThat(jiveTranslator.translate("unHiny"), is("unHiny"));
    }

    @Test
    public void should_translate_VAX() {
        assertThat(jiveTranslator.translate("VAX"), is("Pink Cadillac"));
        assertThat(jiveTranslator.translate("aaa VAX aaa"), is("aaa Pink Cadillac aaa"));
        assertThat(jiveTranslator.translate("unVAXny"), is("unVAXny"));
    }

    @Test
    public void should_translate_statusWithEntities() {
        // Given
        String statusText = "RT @AndrewDunn10 .@CheerfulPodcast is a remarkably fun #podcast. Worth a listen if you're interested in progressive politics and trying to make the world a little better.";

        final EntitiesModel entitiesModel0 = EntitiesModel.translate(0,3, "RT ");
        final EntitiesModel entitiesModel1 = EntitiesModel.verbatim(3, 16, "@AndrewDunn10");
        final EntitiesModel entitiesModel2 = EntitiesModel.translate(16, 18, " .");
        final EntitiesModel entitiesModel3 = EntitiesModel.verbatim(18, 34, "@CheerfulPodcast");
        final EntitiesModel entitiesModel4 = EntitiesModel.translate(34, 55, " is a remarkably fun ");
        final EntitiesModel entitiesModel5 = EntitiesModel.verbatim(55, 63, "#podcast");
        final EntitiesModel entitiesModel6 = EntitiesModel.translate(63, 170, ". Worth a listen if you're interested in progressive politics and trying to make the world a little better.");
        final List<EntitiesModel> entitiesList = new ArrayList<>(3);

        entitiesList.add(entitiesModel0);
        entitiesList.add(entitiesModel1);
        entitiesList.add(entitiesModel2);
        entitiesList.add(entitiesModel3);
        entitiesList.add(entitiesModel4);
        entitiesList.add(entitiesModel5);
        entitiesList.add(entitiesModel6);

        // When
        final String result = jiveTranslator.translate(entitiesList);

        // Then
        assertThat(result, is("RT @AndrewDunn10 .@CheerfulPodcast be some remarkably fun #podcast. Word some listen if youse interested in progressive politics and tryin' t'make da damn world some little better. Ah be baaad..."));
    }
}
