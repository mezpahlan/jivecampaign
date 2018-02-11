package co.uk.jiveelection.campaign.translator;

import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TranslationEntity;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Tests for InMemoryJiveTranslator.
 */
@RunWith(MockitoJUnitRunner.class)
public class InMemoryJiveTranslatorTest {

    @Mock
    Jive mockJive;

    private JiveTranslator jiveTranslator;

    @Before
    public void setUp() {
        jiveTranslator = new InMemoryJiveTranslator(mockJive);
    }

    @Test
    public void should_not_overwrite_previous_translations() {
        verifyTranslation("at the pub! yeah!", "at da damn pub. Right On! yeah. Right On!");
    }

    @Test
    public void should_translate_file() {
        verifyTranslation("aaa file aaa", "aaa stash aaa");
    }

    @Test
    public void should_not_translate_profiled() {
        verifyTranslation("profiled", "profiled");
    }

    @Test
    public void should_translate_send() {
        verifyTranslation("aaa send aaa", "aaa t'row aaa");
    }

    @Test
    public void should_not_translate_godsend() {
        verifyTranslation("godsend", "godsend");
    }

    @Test
    public void should_translate_program() {
        verifyTranslation("aaa program aaa", "aaa honky code aaa");
    }

    @Test
    public void should_translate_programmming() {
        verifyTranslation("programming", "programmin'");
    }

    @Test
    public void should_translate_atlas() {
        verifyTranslation("aaa atlas aaa", "aaa Isaac aaa");
    }

    @Test
    public void should_not_translate_atlases() {
        verifyTranslation("atlases", "atlases");
    }

    @Test
    public void should_translate_unix() {
        verifyTranslation("aaa unix aaa", "aaa slow mo-fo aaa");
    }

    @Test
    public void should_translate_UNIX() {
        verifyTranslation("aaa UNIX aaa", "aaa that slow mo-fo aaa");
    }

    @Test
    public void should_translate_take() {
        verifyTranslation("aaa take aaa", "aaa snatch aaa");
    }

    @Test
    public void should_not_translate_partake() {
        verifyTranslation("partake", "partake");
    }

    @Test
    public void should_translate_mexican() {
        verifyTranslation("aaa mexican aaa", "aaa wet-back aaa");
    }

    @Test
    public void should_translate_mexicans() {
        verifyTranslation("aaa mexicans aaa", "aaa wet-backs aaa");
    }

    @Test
    public void should_translate_Mexican() {
        verifyTranslation("aaa Mexican aaa", "aaa wet-back aaa");
    }

    @Test
    public void should_translate_Mexicans() {
        verifyTranslation("aaa Mexicans aaa", "aaa wet-backs aaa");
    }

    @Test
    public void should_translate_italian() {
        verifyTranslation("aaa italian aaa", "aaa greaser aaa");
    }

    @Test
    public void should_translate_italians() {
        verifyTranslation("aaa italians aaa", "aaa greasers aaa");
    }

    @Test
    public void should_translate_Italian() {
        verifyTranslation("aaa Italian aaa", "aaa greaser aaa");
    }

    @Test
    public void should_translate_Italians() {
        verifyTranslation("aaa Italians aaa", "aaa greasers aaa");
    }

    @Test
    public void should_translate_takes() {
        verifyTranslation("aaa takes aaa", "aaa snatch'd aaa");
    }

    @Test
    public void should_not_translate_partakes() {
        verifyTranslation("partakes", "partakes");
    }

    @Test
    public void should_translate_dont() {
        verifyTranslation("aaa don't aaa", "aaa duzn't aaa");
    }

    @Test
    public void should_translate_translator() {
        verifyTranslation("aaa translator aaa", "aaa jibe aaa");
    }

    @Test
    public void should_translate_fool() {
        verifyTranslation("aaa fool aaa", "aaa honkyfool aaa");
    }

    @Test
    public void should_not_translate_foolishly() {
        verifyTranslation("foolishly", "foolishly");
    }

    @Test
    public void should_translate_modem() {
        verifyTranslation("aaa modem aaa", "aaa doodad aaa");
    }

    @Test
    public void should_translate_the_e_variation() {
        verifyTranslation("aaa see the aaa", "aaa see da damn aaa");
    }

    @Test
    public void should_translate_the_a_variation() {
        verifyTranslation("aaa la the aaa", "aaa la da damn aaa");
    }

    @Test
    public void should_translate_the_t_variation() {
        verifyTranslation("aaa cat the aaa", "aaa cat da damn aaa");
    }

    @Test
    public void should_translate_the_d_variation() {
        verifyTranslation("aaa bad the aaa", "aaa bad da damn aaa");
    }

    @Test
    public void should_translate_man() {
        verifyTranslation("aaa man aaa", "aaa dude aaa");
    }

    @Test
    public void should_not_translate_manipulated() {
        verifyTranslation("manipulated", "manipulated");
    }

    @Test
    public void should_translate_woman() {
        verifyTranslation("chairwoman", "chairmama");
    }

    @Test
    public void should_translate_girl() {
        verifyTranslation("aaa girl aaa", "aaa goat aaa");
    }

    @Test
    public void should_not_translate_girlfriends() {
        verifyTranslation("girlfriends", "girlfriends");
    }

    @Test
    public void should_translate_something() {
        verifyTranslation("aaa something aaa", "aaa sump'n aaa");
    }

    @Test
    public void should_translate_lie() {
        verifyTranslation("lie", "honky jibe");
    }

    @Test
    public void should_not_translate_alien() {
        verifyTranslation("alien", "alien");
    }

    @Test
    public void should_translate_full_stop_a_variation() {
        verifyTranslation("aaa a. aaa", "aaa a. Sheeeiit. aaa");
    }

    @Test
    public void should_translate_full_stop_b_variation() {
        verifyTranslation("aaa b. aaa", "aaa b. Sheeeiit. aaa");
    }

    @Test
    public void should_translate_full_stop_e_variation() {
        verifyTranslation("aaa e. aaa", "aaa e. What it is, Mama! aaa");
    }

    @Test
    public void should_translate_full_stop_f_variation() {
        verifyTranslation("aaa f. aaa", "aaa f. What it is, Mama! aaa");
    }

    @Test
    public void should_translate_full_stop_i_variation() {
        verifyTranslation("aaa i. aaa", "aaa i. Ya' know? aaa");
    }

    @Test
    public void should_translate_full_stop_j_variation() {
        verifyTranslation("aaa j. aaa", "aaa j. Ya' know? aaa");
    }

    @Test
    public void should_translate_full_stop_m_variation() {
        verifyTranslation("aaa m. aaa", "aaa m. 'S coo', bro. aaa");
    }

    @Test
    public void should_translate_full_stop_n_variation() {
        verifyTranslation("aaa n. aaa", "aaa n. 'S coo', bro. aaa");
    }

    @Test
    public void should_translate_full_stop_q_variation() {
        verifyTranslation("aaa q. aaa", "aaa q. Ah be baaad... aaa");
    }

    @Test
    public void should_translate_full_stop_r_variation() {
        verifyTranslation("aaa r. aaa", "aaa r. Ah be baaad... aaa");
    }

    @Test
    public void should_translate_full_stop_u_variation() {
        verifyTranslation("aaa u. aaa", "aaa u. Man! aaa");
    }

    @Test
    public void should_translate_full_stop_v_variation() {
        verifyTranslation("aaa v. aaa", "aaa v. Man! aaa");
    }

    @Test
    public void should_translate_full_stop_y_variation() {
        verifyTranslation("aaa y. aaa", "aaa y. Slap mah fro! aaa");
    }

    @Test
    public void should_translate_full_stop_z_variation() {
        verifyTranslation("aaa z. aaa", "aaa z. Slap mah fro! aaa");
    }

    @Test
    public void should_translate_Sure() {
        verifyTranslation("aaa Sure aaa", "aaa Sho' nuff aaa");
    }

    @Test
    public void should_translate_sure() {
        verifyTranslation("aaa sure aaa", "aaa sho' nuff aaa");
    }

    @Test
    public void should_not_translate_pressure() {
        verifyTranslation("pressure", "pressure");
    }

    @Test
    public void should_translate_get() {
        verifyTranslation("getaway", "gitaway");
    }

    @Test
    public void should_not_translate_forget() {
        verifyTranslation("forget", "forget");
    }

    @Test
    public void should_translate_will_have() {
        verifyTranslation("aaa will have aaa", "aaa gots'ta aaa");
    }

    @Test
    public void should_translate_will() {
        verifyTranslation("aaa will aaa", "aaa gots'ta aaa");
    }

    @Test
    public void should_translate_got_to() {
        verifyTranslation("aaa got to aaa", "aaa gots'ta aaa");
    }

    @Test
    public void should_translate_I_am() {
        verifyTranslation("aaa I am aaa", "aaa I's gots'ta be aaa");
    }

    @Test
    public void should_translate_am_not() {
        verifyTranslation("aaa am not aaa", "aaa aint aaa");
    }

    @Test
    public void should_translate_is_not() {
        verifyTranslation("aaa is not aaa", "aaa aint aaa");
    }

    @Test
    public void should_translate_are_not() {
        verifyTranslation("aaa are not aaa", "aaa aint aaa");
    }

    @Test
    public void should_translate_are_your() {
        verifyTranslation("aaa are your aaa", "aaa is yo' aaa");
    }

    @Test
    public void should_translate_are_you() {
        verifyTranslation("aaa are you aaa", "aaa you is aaa");
    }

    @Test
    public void should_translate_hat() {
        verifyTranslation("aaa hat aaa", "aaa fedora aaa");
    }

    @Test
    public void should_not_translate_hatred() {
        verifyTranslation("hatred", "hatred");
    }

    @Test
    public void should_translate_shoe() {
        verifyTranslation("aaa shoe aaa", "aaa kicker aaa");
    }

    @Test
    public void should_not_translate_shoebox() {
        verifyTranslation("shoebox", "shoebox");
    }

    @Test
    public void should_translate_havent() {
        verifyTranslation("aaa haven't aaa", "aaa aint aaa");
    }

    @Test
    public void should_translate_have_to() {
        verifyTranslation("aaa have to aaa", "aaa gots'ta aaa");
    }

    @Test
    public void should_translate_have() {
        verifyTranslation("aaa have aaa", "aaa gots' aaa");
    }

    @Test
    public void should_translate_has() {
        verifyTranslation("aaa has aaa", "aaa gots'ta aaa");
    }

    @Test
    public void should_translate_come_over() {
        verifyTranslation("aaa come over aaa", "aaa mosey on down aaa");
    }

    @Test
    public void should_translate_come() {
        verifyTranslation("aaa come aaa", "aaa mosey on down aaa");
    }

    @Test
    public void should_not_translate_outcome() {
        verifyTranslation("outcome", "outcome");
    }

    @Test
    public void should_translate_exclamation_mark() {
        verifyTranslation("aaa! aaa", "aaa. Right On! aaa");
    }

    @Test
    public void should_translate_buy() {
        verifyTranslation("aaa buy aaa", "aaa steal aaa");
    }

    @Test
    public void should_translate_buyer() {
        verifyTranslation("buyer", "buya'");
    }

    @Test
    public void should_translate_car() {
        verifyTranslation("aaa car aaa", "aaa wheels aaa");
    }

    @Test
    public void should_translate_carcus() {
        verifyTranslation("carcus", "carcus");
    }

    @Test
    public void should_translate_drive() {
        verifyTranslation("aaa drive aaa", "aaa roll aaa");
    }

    @Test
    public void should_translate_screwdriver() {
        verifyTranslation("screwdriver", "screwdriva'");
    }

    @Test
    public void should_translate_eat() {
        verifyTranslation("aaa eat aaa", "aaa feed da bud aaa");
    }

    @Test
    public void should_not_translate_conceat() {
        verifyTranslation("concreat", "concreat");
    }

    @Test
    public void should_translate_black() {
        verifyTranslation("aaa black aaa", "aaa brother aaa");
    }

    @Test
    public void should_not_translate_blackest() {
        verifyTranslation("blackest", "blackest");
    }

    @Test
    public void should_translate_negro() {
        verifyTranslation("aaa negro aaa", "aaa brother aaa");
    }

    @Test
    public void should_translate_white() {
        verifyTranslation("aaa white aaa", "aaa honky aaa");
    }

    @Test
    public void should_translate_whiter() {
        verifyTranslation("whiter", "whita'");
    }

    @Test
    public void should_translate_nigger() {
        verifyTranslation("aaa nigger aaa", "aaa gentleman aaa");
    }

    @Test
    public void should_translate_nice() {
        verifyTranslation("aaa nice aaa", "aaa supa' fine aaa");
    }

    @Test
    public void should_note_translate_niceties() {
        verifyTranslation("niceties", "niceties");
    }

    @Test
    public void should_translate_person() {
        verifyTranslation("aaa person aaa", "aaa sucka' aaa");
    }

    @Test
    public void should_not_translate_personalities() {
        verifyTranslation("personalities", "personalities");
    }

    @Test
    public void should_translate_persons() {
        verifyTranslation("aaa persons aaa", "aaa sucka's aaa");
    }

    @Test
    public void should_translate_thing() {
        verifyTranslation("aaa thing aaa", "aaa wahtahmellun aaa");
    }

    @Test
    public void should_not_translate_clothing() {
        verifyTranslation("clothing", "clothing");
    }

    @Test
    public void should_translate_home() {
        verifyTranslation("aaa home aaa", "aaa crib aaa");
    }

    @Test
    public void should_translate_whomever() {
        verifyTranslation("whomever", "whomeva'");
    }

    @Test
    public void should_translate_name() {
        verifyTranslation("aaa name aaa", "aaa dojigger aaa");
    }

    @Test
    public void should_not_translate_tournament() {
        verifyTranslation("tournament", "tournament");
    }

    @Test
    public void should_translate_path() {
        verifyTranslation("aaa path aaa", "aaa alley aaa");
    }

    @Test
    public void should_not_translate_sociopath() {
        verifyTranslation("sociopath", "sociopath");
    }

    @Test
    public void should_translate_computer() {
        verifyTranslation("aaa computer aaa", "aaa clunker aaa");

    }

    @Test
    public void should_translate_or() {
        verifyTranslation("aaa or aaa", "aaa o' aaa");
    }

    @Test
    public void should_not_translate_orange() {
        verifyTranslation("orange", "orange");
    }

    @Test
    public void should_translate_killed() {
        verifyTranslation("aaa killed aaa", "aaa wasted aaa");
    }

    @Test
    public void should_not_translate_skilled() {
        verifyTranslation("skilled", "skilled");
    }

    @Test
    public void should_translate_president() {
        verifyTranslation("aaa president aaa", "aaa super-dude aaa");
    }

    @Test
    public void should_not_translate_presidential() {
        verifyTranslation("presidential", "presidential");
    }

    @Test
    public void should_translate_prime_minister() {
        verifyTranslation("aaa prime minister aaa", "aaa super honcho aaa");
    }

    @Test
    public void should_not_translate_prime_ministerial() {
        verifyTranslation("prime ministerial", "prime ministerial");
    }

    @Test
    public void should_translate_injured() {
        verifyTranslation("aaa injured aaa", "aaa hosed aaa");
    }

    @Test
    public void should_not_translate_reinjured() {
        verifyTranslation("reinjured", "reinjured");
    }

    @Test
    public void should_translate_government() {
        verifyTranslation("aaa government aaa", "aaa guv'ment aaa");
    }

    @Test
    public void should_translate_knew() {
        verifyTranslation("misknew", "misknew");
    }

    @Test
    public void should_not_translate_misknew() {
        verifyTranslation("misknew", "misknew");
    }

    @Test
    public void should_translate_Because() {
        verifyTranslation("aaa Because aaa", "aaa B'cuz aaa");
    }

    @Test
    public void should_translate_because() {
        verifyTranslation("aaa because aaa", "aaa b'cuz aaa");
    }

    @Test
    public void should_translate_Your() {
        verifyTranslation("Yourself", "Yo'self");
    }

    @Test
    public void should_translate_your() {
        verifyTranslation("yourself", "yo'self");
    }

    @Test
    public void should_translate_four() {
        verifyTranslation("fourteen", "foeteen");
    }

    @Test
    public void should_translate_got() {
        verifyTranslation("aaa got aaa", "aaa gots aaa");
    }

    @Test
    public void should_not_translate_gothic() {
        verifyTranslation("gothic", "gothic");
    }

    @Test
    public void should_translate_arent() {
        verifyTranslation("aaa aren't aaa", "aaa ain't aaa");
    }

    @Test
    public void should_translate_young() {
        verifyTranslation("aaa young aaa", "aaa yung aaa");
    }

    @Test
    public void should_translate_youngster() {
        verifyTranslation("youngster", "yungsta'");
    }

    @Test
    public void should_translate_you() {
        verifyTranslation("aaa you aaa", "aaa ya' aaa");
    }

    @Test
    public void should_translate_You() {
        verifyTranslation("aaa You aaa", "aaa You's aaa");
    }

    @Test
    public void should_translate_first() {
        verifyTranslation("firstly", "fustly");
    }

    @Test
    public void should_translate_police() {
        verifyTranslation("aaa police aaa", "aaa honky pigs aaa");
    }

    @Test
    public void should_not_translate_policed() {
        verifyTranslation("policed", "policed");
    }

    @Test
    public void should_translate_string() {
        verifyTranslation("aaa string aaa", "aaa chittlin' aaa");
    }

    @Test
    public void should_not_translate_hamstring() {
        verifyTranslation("hamstring", "hamstring");
    }

    @Test
    public void should_translate_read() {
        verifyTranslation("aaa read aaa", "aaa eyeball aaa");
    }

    @Test
    public void should_not_translate_readiness() {
        verifyTranslation("readiness", "readiness");
    }

    @Test
    public void should_translate_write() {
        verifyTranslation("aaa write aaa", "aaa scribble aaa");
    }

    @Test
    public void should_translate_th() {
        verifyTranslation("that", "dat");
    }

    @Test
    public void should_translate_Th() {
        verifyTranslation("That", "Dat");
    }

    @Test
    public void should_translate_ing() {
        verifyTranslation("winning", "winnin'");
    }

    @Test
    public void should_translate_a() {
        verifyTranslation("aaa a aaa", "aaa some aaa");
    }

    @Test
    public void should_not_translate_aweseome() {
        verifyTranslation("awesome", "awesome");
    }

    @Test
    public void should_translate_to() {
        verifyTranslation("to town", "t'town");
    }

    @Test
    public void should_not_translate_too() {
        verifyTranslation("too", "too");
    }

    @Test
    public void should_translate_tion() {
        verifyTranslation("election", "elecshun");
    }

    @Test
    public void should_translate_almost() {
        verifyTranslation("aaa almost aaa", "aaa mos' aaa");
    }

    @Test
    public void should_translate_from() {
        verifyTranslation("aaa from aaa", "aaa fum aaa");
    }

    @Test
    public void should_not_translate_wherefrom() {
        verifyTranslation("wherefrom", "wherefrom");
    }

    @Test
    public void should_translate_Youre() {
        verifyTranslation("aaa You're aaa", "aaa Youse aaa");
    }

    @Test
    public void should_translate_youre() {
        verifyTranslation("aaa you're aaa", "aaa youse aaa");
    }

    @Test
    public void should_translate_alright() {
        verifyTranslation("aaa alright aaa", "aaa coo' aaa");
    }

    @Test
    public void should_translate_okay() {
        verifyTranslation("aaa okay aaa", "aaa coo' aaa");
    }

    @Test
    public void should_translate_er() {
        verifyTranslation("winter", "winta'");
    }

    @Test
    public void should_not_translate_error() {
        verifyTranslation("error", "error");
    }

    @Test
    public void should_translate_known() {
        verifyTranslation("aaa known aaa", "aaa knode aaa");
    }

    @Test
    public void should_translate_want() {
        verifyTranslation("aaa want aaa", "aaa wants' aaa");
    }

    @Test
    public void should_translate_beat() {
        verifyTranslation("aaa beat aaa", "aaa whup' aaa");
    }

    @Test
    public void should_translate_beating() {
        verifyTranslation("aaa beat aaa", "aaa whup' aaa");
        verifyTranslation("beating", "beatin'");
    }

    @Test
    public void should_translate_exp() {
        verifyTranslation("explain", "'splain");
    }

    @Test
    public void should_translate_exs() {
        verifyTranslation("exsert", "'sert");
    }

    @Test
    public void should_translate_exc() {
        verifyTranslation("exclaim", "'slaim");
    }

    @Test
    public void should_translate_ex() {
        verifyTranslation("extra", "'estra");
    }

    @Test
    public void should_translate_like() {
        verifyTranslation("aaa like aaa", "aaa likes aaa");
    }

    @Test
    public void should_not_translate_likes() {
        verifyTranslation("likes", "likes");
    }

    @Test
    public void should_translate_did() {
        verifyTranslation("aaa did aaa", "aaa dun did aaa");
    }

    @Test
    public void should_not_translate_candid() {
        verifyTranslation("candid", "candid");
    }

    @Test
    public void should_translate_kind_of() {
        verifyTranslation("aaa kind of aaa", "aaa kind'a aaa");
    }

    @Test
    public void should_translate_mankind_offered() {
        verifyTranslation("mankind offered", "mankind offered");
    }

    @Test
    public void should_translate_women() {
        verifyTranslation("aaa women aaa", "aaa honky chicks aaa");
    }

    @Test
    public void should_not_translate_anchorwomen() {
        verifyTranslation("anchorwomen", "anchorwomen");
    }

    @Test
    public void should_translate_men() {
        verifyTranslation("aaa men aaa", "aaa dudes aaa");
    }

    @Test
    public void should_translate_dead() {
        verifyTranslation("aaa dead aaa", "aaa wasted aaa");
    }

    @Test
    public void should_not_translate_deadliest() {
        verifyTranslation("deadliest", "deadliest");
    }

    @Test
    public void should_translate_good() {
        verifyTranslation("aaa good aaa", "aaa baaaad aaa");
    }

    @Test
    public void should_not_translate_goodbye() {
        verifyTranslation("goodbye", "goodbye");
    }

    @Test
    public void should_translate_open() {
        verifyTranslation("aaa open aaa", "aaa jimmey aaa");
    }

    @Test
    public void should_translate_opened() {
        verifyTranslation("opened", "jimmey'd");
    }

    @Test
    public void should_not_translate_unopened() {
        verifyTranslation("unopened", "unopened");
    }

    @Test
    public void should_translate_very() {
        verifyTranslation("aaa very aaa", "aaa real aaa");
    }

    @Test
    public void should_not_translate_avery() {
        verifyTranslation("avery", "avery");
    }

    @Test
    public void should_translate_per() {
        verifyTranslation("aaa per aaa", "aaa puh' aaa");
    }

    @Test
    public void should_not_translate_copper() {
        verifyTranslation("copper", "copper");
    }

    @Test
    public void should_translate_oar() {
        verifyTranslation("aaa oar aaa", "aaa o' aaa");
    }

    @Test
    public void should_not_translate_soar() {
        verifyTranslation("soar", "soar");
    }

    @Test
    public void should_translate_can() {
        verifyTranslation("aaa can aaa", "aaa kin aaa");
    }

    @Test
    public void should_not_translate_uncanny() {
        verifyTranslation("uncanny", "uncanny");
    }

    @Test
    public void should_translate_just() {
        verifyTranslation("aaa just aaa", "aaa plum aaa");
    }

    @Test
    public void should_not_translate_adjust() {
        verifyTranslation("adjust", "adjust");
    }

    @Test
    public void should_translate_Detroit() {
        verifyTranslation("aaa Detroit aaa", "aaa Mo-town aaa");
    }

    @Test
    public void should_translate_detroit() {
        verifyTranslation("aaa detroit aaa", "aaa Mo-town aaa");
    }

    @Test
    public void should_translate_believe() {
        verifyTranslation("aaa believe aaa", "aaa recon' aaa");
    }

    @Test
    public void should_translate_Indianapolis() {
        verifyTranslation("aaa Indianapolis aaa", "aaa Nap-town aaa");
    }

    @Test
    public void should_translate_indianapolis() {
        verifyTranslation("aaa indianapolis aaa", "aaa Nap-town aaa");
    }

    @Test
    public void should_translate_Jack() {
        verifyTranslation("aaa Jack aaa", "aaa Buckwheat aaa");
    }

    @Test
    public void should_not_translate_Jackal() {
        verifyTranslation("Jackal", "Jackal");
    }

    @Test
    public void should_translate_jack() {
        verifyTranslation("aaa jack aaa", "aaa Buckwheat aaa");
    }

    @Test
    public void should_not_translate_jackal() {
        verifyTranslation("jackal", "jackal");
    }

    @Test
    public void should_translate_Bob() {
        verifyTranslation("aaa Bob aaa", "aaa Liva' Lips aaa");
    }

    @Test
    public void should_nottranslate_Bobby() {
        verifyTranslation("Bobby", "Bobby");
    }

    @Test
    public void should_translate_bob() {
        verifyTranslation("aaa bob aaa", "aaa Liva' Lips aaa");
    }

    @Test
    public void should_nottranslate_bobby() {
        verifyTranslation("bobby", "bobby");
    }

    @Test
    public void should_translate_Phil() {
        verifyTranslation("aaa Phil aaa", "aaa dat fine soul aaa");
    }

    @Test
    public void should_translate_Phillip() {
        verifyTranslation("Phillip", "Phillip");
    }

    @Test
    public void should_translate_phil() {
        verifyTranslation("aaa phil aaa", "aaa dat fine soul aaa");
    }

    @Test
    public void should_translate_phillip() {
        verifyTranslation("phillip", "phillip");
    }

    @Test
    public void should_translate_Mark() {
        verifyTranslation("aaa Mark aaa", "aaa Amos aaa");
    }

    @Test
    public void should_translate_mark() {
        verifyTranslation("aaa mark aaa", "aaa Amos aaa");
    }

    @Test
    public void should_translate_Robert() {
        verifyTranslation("Roberto", "Roberto");
    }

    @Test
    public void should_not_translate_Roberto() {
        verifyTranslation("Roberto", "Roberto");
    }

    @Test
    public void should_translate_robert() {
        verifyTranslation("aaa robert aaa", "aaa Leroy aaa");
    }

    @Test
    public void should_not_translate_roberto() {
        verifyTranslation("roberto", "roberto");
    }

    @Test
    public void should_translate_Sandy() {
        verifyTranslation("aaa Sandy aaa", "aaa dat fine femahnaine ladee aaa");
    }

    @Test
    public void should_translate_sandy() {
        verifyTranslation("aaa sandy aaa", "aaa dat fine femahnaine ladee aaa");
    }

    @Test
    public void should_translate_John() {
        verifyTranslation("aaa John aaa", "aaa Raz'tus aaa");
    }

    @Test
    public void should_not_translate_Johnny() {
        verifyTranslation("Johnny", "Johnny");
    }

    @Test
    public void should_translate_john() {
        verifyTranslation("aaa john aaa", "aaa Raz'tus aaa");
    }

    @Test
    public void should_not_translate_johnny() {
        verifyTranslation("johnny", "johnny");
    }

    @Test
    public void should_translate_Paul() {
        verifyTranslation("aaa Paul aaa", "aaa Fuh'rina aaa");
    }

    @Test
    public void should_not_translate_Paula() {
        verifyTranslation("Paula", "Paula");
    }

    @Test
    public void should_translate_paul() {
        verifyTranslation("aaa paul aaa", "aaa Fuh'rina aaa");
    }

    @Test
    public void should_not_translate_paula() {
        verifyTranslation("paula", "paula");
    }

    @Test
    public void should_translate_Reagan() {
        verifyTranslation("aaa Reagan aaa", "aaa Kingfish aaa");
    }

    @Test
    public void should_translate_Reaganomics() {
        verifyTranslation("Reaganomics", "Reaganomics");
    }

    @Test
    public void should_translate_reagan() {
        verifyTranslation("aaa reagan aaa", "aaa Kingfish aaa");
    }

    @Test
    public void should_not_translate_reaganomics() {
        verifyTranslation("reaganomics", "reaganomics");
    }

    @Test
    public void should_translate_David() {
        verifyTranslation("aaa David aaa", "aaa Issac aaa");
    }

    @Test
    public void should_translate_david() {
        verifyTranslation("aaa david aaa", "aaa Issac aaa");
    }

    @Test
    public void should_translate_Ronald() {
        verifyTranslation("aaa Ronald aaa", "aaa Rolo aaa");
    }

    @Test
    public void should_translate_ronald() {
        verifyTranslation("aaa ronald aaa", "aaa Rolo aaa");
    }

    @Test
    public void should_translate_Jim() {
        verifyTranslation("aaa Jim aaa", "aaa Bo-Jangles aaa");
    }

    @Test
    public void should_not_translate_Jimmy() {
        verifyTranslation("Jimmy", "Jimmy");
    }

    @Test
    public void should_translate_jim() {
        verifyTranslation("aaa jim aaa", "aaa Bo-Jangles aaa");
    }

    @Test
    public void should_not_translate_jimmy() {
        verifyTranslation("jimmy", "jimmy");
    }

    @Test
    public void should_translate_Mary() {
        verifyTranslation("aaa Mary aaa", "aaa Snow Flake aaa");
    }

    @Test
    public void should_not_translate_Maryanne() {
        verifyTranslation("Maryanne", "Maryanne");
    }

    @Test
    public void should_translate_mary() {
        verifyTranslation("aaa mary aaa", "aaa Snow Flake aaa");
    }

    @Test
    public void should_not_translate_maryanne() {
        verifyTranslation("maryanne", "maryanne");
    }

    @Test
    public void should_translate_Larry() {
        verifyTranslation("aaa Larry aaa", "aaa Remus aaa");
    }

    @Test
    public void should_translate_larry() {
        verifyTranslation("aaa larry aaa", "aaa Remus aaa");
    }

    @Test
    public void should_translate_Mohammed() {
        verifyTranslation("aaa Mohammed aaa", "aaa Home Boy aaa");
    }

    @Test
    public void should_translate_mohammed() {
        verifyTranslation("aaa mohammed aaa", "aaa Home Boy aaa");
    }

    @Test
    public void should_translate_Pope() {
        verifyTranslation("aaa Pope aaa", "aaa wiz' aaa");
    }

    @Test
    public void should_translate_pope() {
        verifyTranslation("aaa pope aaa", "aaa wiz' aaa");
    }

    @Test
    public void should_translate_Pontiff() {
        verifyTranslation("aaa Pontiff aaa", "aaa wiz' aaa");
    }

    @Test
    public void should_translate_pontiff() {
        verifyTranslation("aaa pontiff aaa", "aaa wiz' aaa");
    }

    @Test
    public void should_translate_Pravda() {
        verifyTranslation("aaa Pravda aaa", "aaa dat commie rag aaa");
    }

    @Test
    public void should_translate_pravda() {
        verifyTranslation("aaa pravda aaa", "aaa dat commie rag aaa");
    }

    @Test
    public void should_translate_broken() {
        verifyTranslation("aaa broken aaa", "aaa bugger'd aaa");
    }

    @Test
    public void should_not_translate_unbrokenny() {
        verifyTranslation("unbrokenny", "unbrokenny");
    }

    @Test
    public void should_translate_strange() {
        verifyTranslation("unstrangeny", "unstrangeny");
    }

    @Test
    public void should_not_translate_unstrangeny() {
        verifyTranslation("unstrangeny", "unstrangeny");
    }

    @Test
    public void should_translate_dance() {
        verifyTranslation("aaa dance aaa", "aaa boogy aaa");
    }

    @Test
    public void should_not_translate_undanceny() {
        verifyTranslation("undanceny", "undanceny");
    }

    @Test
    public void should_translate_house() {
        verifyTranslation("aaa house aaa", "aaa crib aaa");
    }

    @Test
    public void should_translate_ask() {
        verifyTranslation("aaa ask aaa", "aaa ax' aaa");
    }

    @Test
    public void should_not_translate_unaskny() {
        verifyTranslation("unaskny", "unaskny");
    }

    @Test
    public void should_translate_so() {
        verifyTranslation("aaa so aaa", "aaa so's aaa");
    }

    @Test
    public void should_not_translate_unsony() {
        verifyTranslation("unsony", "unsony");
    }

    @Test
    public void should_translate_head() {
        verifyTranslation("aaa head aaa", "aaa 'haid aaa");
    }

    @Test
    public void should_not_translate_unheadny() {
        verifyTranslation("unheadny", "unheadny");
    }

    @Test
    public void should_translate_boss() {
        verifyTranslation("aaa boss aaa", "aaa main man aaa");
    }

    @Test
    public void should_not_translate_unbossny() {
        verifyTranslation("unbossny", "unbossny");
    }

    @Test
    public void should_translate_wife() {
        verifyTranslation("aaa wife aaa", "aaa mama aaa");
    }

    @Test
    public void should_not_translate_unwifeny() {
        verifyTranslation("unwifeny", "unwifeny");
    }

    @Test
    public void should_translate_people() {
        verifyTranslation("aaa people aaa", "aaa sucka's aaa");
    }

    @Test
    public void should_not_translate_unpeopleny() {
        verifyTranslation("unpeopleny", "unpeopleny");
    }

    @Test
    public void should_translate_money() {
        verifyTranslation("aaa money aaa", "aaa bre'd aaa");
    }

    @Test
    public void should_not_translate_unmoneyny() {
        verifyTranslation("unmoneyny", "unmoneyny");
    }

    @Test
    public void should_translate_a_colon() {
        verifyTranslation("a:", "a, dig dis:");
    }

    @Test
    public void should_translate_b_colon() {
        verifyTranslation("b:", "b, dig dis:");
    }

    @Test
    public void should_translate_c_colon() {
        verifyTranslation("c:", "c, dig dis:");
    }

    @Test
    public void should_translate_d_colon() {
        verifyTranslation("d:", "d, dig dis:");
    }

    @Test
    public void should_translate_e_colon() {
        verifyTranslation("e:", "e, dig dis:");
    }

    @Test
    public void should_translate_f_colon() {
        verifyTranslation("f:", "f, dig dis:");
    }

    @Test
    public void should_translate_g_colon() {
        verifyTranslation("g:", "g, dig dis:");
    }

    @Test
    public void should_translate_h_colon() {
        verifyTranslation("h:", "h, dig dis:");
    }

    @Test
    public void should_translate_i_colon() {
        verifyTranslation("i:", "i, dig dis:");
    }

    @Test
    public void should_translate_j_colon() {
        verifyTranslation("j:", "j, dig dis:");
    }

    @Test
    public void should_translate_k_colon() {
        verifyTranslation("k:", "k, dig dis:");
    }

    @Test
    public void should_translate_l_colon() {
        verifyTranslation("l:", "l, dig dis:");
    }

    @Test
    public void should_translate_m_colon() {
        verifyTranslation("m:", "m, dig dis:");
    }

    @Test
    public void should_translate_n_colon() {
        verifyTranslation("n:", "n, dig dis:");
    }

    @Test
    public void should_translate_o_colon() {
        verifyTranslation("o:", "o, dig dis:");
    }

    @Test
    public void should_translate_p_colon() {
        verifyTranslation("http:", "http:");
    }

    @Test
    public void should_translate_q_colon() {
        verifyTranslation("q:", "q, dig dis:");
    }

    @Test
    public void should_translate_r_colon() {
        verifyTranslation("r:", "r, dig dis:");
    }

    @Test
    public void should_translate_s_colon() {
        verifyTranslation("https:", "https:");
    }

    @Test
    public void should_translate_t_colon() {
        verifyTranslation("t:", "t, dig dis:");
    }

    @Test
    public void should_translate_u_colon() {
        verifyTranslation("u:", "u, dig dis:");
    }

    @Test
    public void should_translate_v_colon() {
        verifyTranslation("v:", "v, dig dis:");
    }

    @Test
    public void should_translate_w_colon() {
        verifyTranslation("w:", "w, dig dis:");
    }

    @Test
    public void should_translate_x_colon() {
        verifyTranslation("x:", "x, dig dis:");
    }

    @Test
    public void should_translate_y_colon() {
        verifyTranslation("y:", "y, dig dis:");
    }

    @Test
    public void should_translate_z_colon() {
        verifyTranslation("z:", "z, dig dis:");
    }

    @Test
    public void should_translate_amateur() {
        verifyTranslation("aaa amateur aaa", "aaa begina' aaa");
    }

    @Test
    public void should_not_translate_unamateurny() {
        verifyTranslation("unamateurny", "unamateurny");
    }

    @Test
    public void should_translate_radio() {
        verifyTranslation("aaa radio aaa", "aaa transista' aaa");
    }

    @Test
    public void should_not_translate_unradiony() {
        verifyTranslation("unradiony", "unradiony");
    }

    @Test
    public void should_translate_of() {
        verifyTranslation("aaa of aaa", "aaa uh' aaa");
    }

    @Test
    public void should_not_translate_unofny() {
        verifyTranslation("unofny", "unofny");
    }

    @Test
    public void should_translate_what() {
        verifyTranslation("aaa what aaa", "aaa whut aaa");
    }

    @Test
    public void should_not_translate_unwhatny() {
        verifyTranslation("unwhatny", "unwhatny");
    }

    @Test
    public void should_translate_does() {
        verifyTranslation("aaa does aaa", "aaa duz aaa");
    }

    @Test
    public void should_not_translate_undoesny() {
        verifyTranslation("undoesny", "undoesny");
    }

    @Test
    public void should_translate_was() {
        verifyTranslation("aaa was aaa", "aaa wuz aaa");
    }

    @Test
    public void should_not_translate_unwasny() {
        verifyTranslation("unwasny", "unwasny");
    }

    @Test
    public void should_translate_were() {
        verifyTranslation("aaa were aaa", "aaa wuz aaa");
    }

    @Test
    public void should_not_translate_unwereny() {
        verifyTranslation("unwereny", "unwereny");
    }

    @Test
    public void should_translate_understand() {
        verifyTranslation("aaa understand aaa", "aaa dig it aaa");
    }

    @Test
    public void should_not_translate_ununderstandny() {
        verifyTranslation("ununderstandny", "ununderstandny");
    }

    @Test
    public void should_translate_understand_it() {
        verifyTranslation("aaa understand it aaa", "aaa dig it aaa");
    }

    @Test
    public void should_not_translate_ununderstand_itny() {
        verifyTranslation("ununderstand itny", "ununderstand itny");
    }

    @Test
    public void should_translate_my() {
        verifyTranslation("aaa my aaa", "aaa mah aaa");
    }

    @Test
    public void should_not_translate_unmyny() {
        verifyTranslation("unmyny", "unmyny");
    }

    @Test
    public void should_translate_I() {
        verifyTranslation("aaa I aaa", "aaa ah' aaa");
    }

    @Test
    public void should_not_translate_unIny() {
        verifyTranslation("unIny", "unIny");
    }

    @Test
    public void should_translate_meta() {
        verifyTranslation("aaa meta aaa", "aaa meta-fuckin' aaa");
    }

    @Test
    public void should_not_translate_unmetany() {
        verifyTranslation("unmetany", "unmetany");
    }

    @Test
    public void should_translate_hair() {
        verifyTranslation("aaa hair aaa", "aaa fro aaa");
    }

    @Test
    public void should_not_translate_unhairny() {
        verifyTranslation("unhairny", "unhairny");
    }

    @Test
    public void should_translate_talk() {
        verifyTranslation("aaa talk aaa", "aaa rap aaa");
    }

    @Test
    public void should_not_translate_untalkny() {
        verifyTranslation("untalkny", "untalkny");
    }

    @Test
    public void should_translate_music() {
        verifyTranslation("aaa music aaa", "aaa beat aaa");
    }

    @Test
    public void should_not_translate_unmusicny() {
        verifyTranslation("unmusicny", "unmusicny");
    }

    @Test
    public void should_translate_basket() {
        verifyTranslation("aaa basket aaa", "aaa hoop aaa");
    }

    @Test
    public void should_not_translate_unbasketny() {
        verifyTranslation("unbasketny", "unbasketny");
    }

    @Test
    public void should_translate_football() {
        verifyTranslation("aaa football aaa", "aaa ball aaa");
    }

    @Test
    public void should_ntot_translate_unfootballny() {
        verifyTranslation("unfootballny", "unfootballny");
    }

    @Test
    public void should_translate_friend() {
        verifyTranslation("aaa friend aaa", "aaa homey aaa");
    }

    @Test
    public void should_not_translate_unfriendny() {
        verifyTranslation("unfriendny", "unfriendny");
    }

    @Test
    public void should_translate_school() {
        verifyTranslation("aaa school aaa", "aaa farm aaa");
    }

    @Test
    public void should_not_translate_unschoolny() {
        verifyTranslation("unschoolny", "unschoolny");
    }

    @Test
    public void should_translate_my_boss() {
        verifyTranslation("aaa my boss aaa", "aaa The Man aaa");
    }

    @Test
    public void should_not_translate_unmy_bossny() {
        verifyTranslation("unmy bossny", "unmy bossny");
    }

    @Test
    public void should_translate_want_to() {
        verifyTranslation("aaa want to aaa", "aaa wanna aaa");
    }

    @Test
    public void should_not_translate_unwant_tony() {
        verifyTranslation("unwant tony", "unwant tony");
    }

    @Test
    public void should_translate_wants_to() {
        verifyTranslation("aaa wants to aaa", "aaa be hankerin' aftah aaa");
    }

    @Test
    public void should_not_translate_unwants_tony() {
        verifyTranslation("unwants tony", "unwants tony");
    }

    @Test
    public void should_translate_Well() {
        verifyTranslation("aaa Well aaa", "aaa Sheeit aaa");
    }

    @Test
    public void should_not_translate_unWellny() {
        verifyTranslation("unWellny", "unWellny");
    }

    @Test
    public void should_translate_well() {
        verifyTranslation("aaa well aaa", "aaa sheeit aaa");
    }

    @Test
    public void should_not_translate_unwellny() {
        verifyTranslation("unwellny", "unwellny");
    }

    @Test
    public void should_translate_big() {
        verifyTranslation("aaa big aaa", "aaa big-ass aaa");
    }

    @Test
    public void should_not_translate_unbigny() {
        verifyTranslation("unbigny", "unbigny");
    }

    @Test
    public void should_translate_bad() {
        verifyTranslation("aaa bad aaa", "aaa bad-ass aaa");
    }

    @Test
    public void should_not_translate_unbadny() {
        verifyTranslation("unbadny", "unbadny");
    }

    @Test
    public void should_translate_small() {
        verifyTranslation("aaa small aaa", "aaa little-ass aaa");
    }

    @Test
    public void should_not_translate_unsmallny() {
        verifyTranslation("unsmallny", "unsmallny");
    }

    @Test
    public void should_translate_sort_of() {
        verifyTranslation("aaa sort of aaa", "aaa radical aaa");
    }

    @Test
    public void should_not_translate_unsort_ofny() {
        verifyTranslation("unsort ofny", "unsort ofny");
    }

    @Test
    public void should_translate_is() {
        verifyTranslation("aaa is aaa", "aaa be aaa");
    }

    @Test
    public void should_not_translate_unisny() {
        verifyTranslation("unisny", "unisny");
    }

    @Test
    public void should_translate_water() {
        verifyTranslation("aaa water aaa", "aaa booze aaa");
    }

    @Test
    public void should_not_translate_unwaterny() {
        verifyTranslation("unwaterny", "unwaterny");
    }

    @Test
    public void should_translate_book() {
        verifyTranslation("aaa book aaa", "aaa scribblin' aaa");
    }

    @Test
    public void should_not_translate_unbookny() {
        verifyTranslation("unbookny", "unbookny");
    }

    @Test
    public void should_translate_magazine() {
        verifyTranslation("aaa magazine aaa", "aaa issue of GQ aaa");
    }

    @Test
    public void should_not_translate_unmagazineny() {
        verifyTranslation("unmagazineny", "unmagazineny");
    }

    @Test
    public void should_translate_paper() {
        verifyTranslation("aaa paper aaa", "aaa sheet aaa");
    }

    @Test
    public void should_not_translate_unpaperny() {
        verifyTranslation("unpaperny", "unpaperny");
    }

    @Test
    public void should_translate_up() {
        verifyTranslation("aaa up aaa", "aaa down aaa");
    }

    @Test
    public void should_not_translate_unupny() {
        verifyTranslation("unupny", "unupny");
    }

    @Test
    public void should_translate_down() {
        verifyTranslation("aaa down aaa", "aaa waaay down aaa");
    }

    @Test
    public void should_not_translate_undownny() {
        verifyTranslation("undownny", "undownny");
    }

    @Test
    public void should_translate_Hi() {
        verifyTranslation("aaa Hi aaa", "aaa 'Sup, dude aaa");
    }

    @Test
    public void should_not_translate_unHiny() {
        verifyTranslation("unHiny", "unHiny");
    }

    @Test
    public void should_translate_VAX() {
        verifyTranslation("aaa VAX aaa", "aaa Pink Cadillac aaa");
    }

    @Test
    public void should_not_translate_unVAXy() {
        verifyTranslation("aaa unVAXy aaa", "aaa unVAXy aaa");
    }

    @Test
    public void should_translate_statusWithEntities() {
        // Given
        final String statusText = "RT @AndrewDunn10 .@CheerfulPodcast is a remarkably fun #podcast. Worth a listen if you're interested in progressive politics and trying to make the world a little better.";
        final String translated = "RT @AndrewDunn10 .@CheerfulPodcast be some remarkably fun #podcast. Word some listen if youse interested in progressive politics and tryin' t'make da damn world some little better. Ah be baaad...";


        final TranslationEntity translationEntity0 = TranslationEntity.translate(0, 3, "RT ");
        final TranslationEntity translationEntity1 = TranslationEntity.verbatim(3, 16, "@AndrewDunn10");
        final TranslationEntity translationEntity2 = TranslationEntity.translate(16, 18, " .");
        final TranslationEntity translationEntity3 = TranslationEntity.verbatim(18, 34, "@CheerfulPodcast");
        final TranslationEntity translationEntity4 = TranslationEntity.translate(34, 55, " is a remarkably fun ");
        final TranslationEntity translationEntity5 = TranslationEntity.verbatim(55, 63, "#podcast");
        final TranslationEntity translationEntity6 = TranslationEntity.translate(63, 170, ". Worth a listen if you're interested in progressive politics and trying to make the world a little better.");
        final List<TranslationEntity> entitiesList = new ArrayList<>(7);

        entitiesList.add(translationEntity0);
        entitiesList.add(translationEntity1);
        entitiesList.add(translationEntity2);
        entitiesList.add(translationEntity3);
        entitiesList.add(translationEntity4);
        entitiesList.add(translationEntity5);
        entitiesList.add(translationEntity6);

        // When
        jiveTranslator.translate(entitiesList);

        // Then
        verify(mockJive).onTranslationComplete(translated);
    }

    private void verifyTranslation(String text, String translation) {
        // Given
        final TranslationEntity translationEntity = TranslationEntity.translate(0, text.length(), text);
        final List<TranslationEntity> entityList = new ArrayList<>(1);
        entityList.add(translationEntity);

        // When
        jiveTranslator.translate(entityList);

        // Then
        verify(mockJive).onTranslationComplete(translation);
    }
}
