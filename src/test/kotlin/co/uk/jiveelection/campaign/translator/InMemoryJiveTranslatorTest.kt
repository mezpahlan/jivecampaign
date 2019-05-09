package co.uk.jiveelection.campaign.translator

import co.uk.jiveelection.campaign.jive.Jive
import co.uk.jiveelection.campaign.output.twitter.TranslationEntity
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import java.util.ArrayList

import org.mockito.Mockito.verify

/**
 * Tests for InMemoryJiveTranslator.
 */
@RunWith(MockitoJUnitRunner::class)
class InMemoryJiveTranslatorTest {

    @Mock
    private lateinit var mockJive: Jive<*, *, *>

    private lateinit var jiveTranslator: JiveTranslator

    @Before
    fun setUp() {
        jiveTranslator = InMemoryJiveTranslator(mockJive)
    }

    @Test
    fun should_not_overwrite_previous_translations() {
        verifyTranslation("at the pub! yeah!", "at da damn pub. Right On! yeah. Right On!")
    }

    @Test
    fun should_translate_file() {
        verifyTranslation("aaa file aaa", "aaa stash aaa")
    }

    @Test
    fun should_not_translate_profiled() {
        verifyTranslation("profiled", "profiled")
    }

    @Test
    fun should_translate_send() {
        verifyTranslation("aaa send aaa", "aaa t'row aaa")
    }

    @Test
    fun should_not_translate_godsend() {
        verifyTranslation("godsend", "godsend")
    }

    @Test
    fun should_translate_program() {
        verifyTranslation("aaa program aaa", "aaa honky code aaa")
    }

    @Test
    fun should_translate_programmming() {
        verifyTranslation("programming", "programmin'")
    }

    @Test
    fun should_translate_atlas() {
        verifyTranslation("aaa atlas aaa", "aaa Isaac aaa")
    }

    @Test
    fun should_not_translate_atlases() {
        verifyTranslation("atlases", "atlases")
    }

    @Test
    fun should_translate_unix() {
        verifyTranslation("aaa unix aaa", "aaa slow mo-fo aaa")
    }

    @Test
    fun should_translate_UNIX() {
        verifyTranslation("aaa UNIX aaa", "aaa that slow mo-fo aaa")
    }

    @Test
    fun should_translate_take() {
        verifyTranslation("aaa take aaa", "aaa snatch aaa")
    }

    @Test
    fun should_not_translate_partake() {
        verifyTranslation("partake", "partake")
    }

    @Test
    fun should_translate_mexican() {
        verifyTranslation("aaa mexican aaa", "aaa wet-back aaa")
    }

    @Test
    fun should_translate_mexicans() {
        verifyTranslation("aaa mexicans aaa", "aaa wet-backs aaa")
    }

    @Test
    fun should_translate_Mexican() {
        verifyTranslation("aaa Mexican aaa", "aaa wet-back aaa")
    }

    @Test
    fun should_translate_Mexicans() {
        verifyTranslation("aaa Mexicans aaa", "aaa wet-backs aaa")
    }

    @Test
    fun should_translate_italian() {
        verifyTranslation("aaa italian aaa", "aaa greaser aaa")
    }

    @Test
    fun should_translate_italians() {
        verifyTranslation("aaa italians aaa", "aaa greasers aaa")
    }

    @Test
    fun should_translate_Italian() {
        verifyTranslation("aaa Italian aaa", "aaa greaser aaa")
    }

    @Test
    fun should_translate_Italians() {
        verifyTranslation("aaa Italians aaa", "aaa greasers aaa")
    }

    @Test
    fun should_translate_takes() {
        verifyTranslation("aaa takes aaa", "aaa snatch'd aaa")
    }

    @Test
    fun should_not_translate_partakes() {
        verifyTranslation("partakes", "partakes")
    }

    @Test
    fun should_translate_dont() {
        verifyTranslation("aaa don't aaa", "aaa duzn't aaa")
    }

    @Test
    fun should_translate_translator() {
        verifyTranslation("aaa translator aaa", "aaa jibe aaa")
    }

    @Test
    fun should_translate_fool() {
        verifyTranslation("aaa fool aaa", "aaa honkyfool aaa")
    }

    @Test
    fun should_not_translate_foolishly() {
        verifyTranslation("foolishly", "foolishly")
    }

    @Test
    fun should_translate_modem() {
        verifyTranslation("aaa modem aaa", "aaa doodad aaa")
    }

    @Test
    fun should_translate_the_e_variation() {
        verifyTranslation("aaa see the aaa", "aaa see da damn aaa")
    }

    @Test
    fun should_translate_the_a_variation() {
        verifyTranslation("aaa la the aaa", "aaa la da damn aaa")
    }

    @Test
    fun should_translate_the_t_variation() {
        verifyTranslation("aaa cat the aaa", "aaa cat da damn aaa")
    }

    @Test
    fun should_translate_the_d_variation() {
        verifyTranslation("aaa bad the aaa", "aaa bad da damn aaa")
    }

    @Test
    fun should_translate_man() {
        verifyTranslation("aaa man aaa", "aaa dude aaa")
    }

    @Test
    fun should_not_translate_manipulated() {
        verifyTranslation("manipulated", "manipulated")
    }

    @Test
    fun should_translate_woman() {
        verifyTranslation("chairwoman", "chairmama")
    }

    @Test
    fun should_translate_girl() {
        verifyTranslation("aaa girl aaa", "aaa goat aaa")
    }

    @Test
    fun should_not_translate_girlfriends() {
        verifyTranslation("girlfriends", "girlfriends")
    }

    @Test
    fun should_translate_something() {
        verifyTranslation("aaa something aaa", "aaa sump'n aaa")
    }

    @Test
    fun should_translate_lie() {
        verifyTranslation("lie", "honky jibe")
    }

    @Test
    fun should_not_translate_alien() {
        verifyTranslation("alien", "alien")
    }

    @Test
    fun should_translate_full_stop_a_variation() {
        verifyTranslation("aaa a. aaa", "aaa a. Sheeeiit. aaa")
    }

    @Test
    fun should_translate_full_stop_b_variation() {
        verifyTranslation("aaa b. aaa", "aaa b. Sheeeiit. aaa")
    }

    @Test
    fun should_translate_full_stop_e_variation() {
        verifyTranslation("aaa e. aaa", "aaa e. What it is, Mama! aaa")
    }

    @Test
    fun should_translate_full_stop_f_variation() {
        verifyTranslation("aaa f. aaa", "aaa f. What it is, Mama! aaa")
    }

    @Test
    fun should_translate_full_stop_i_variation() {
        verifyTranslation("aaa i. aaa", "aaa i. Ya' know? aaa")
    }

    @Test
    fun should_translate_full_stop_j_variation() {
        verifyTranslation("aaa j. aaa", "aaa j. Ya' know? aaa")
    }

    @Test
    fun should_translate_full_stop_m_variation() {
        verifyTranslation("aaa m. aaa", "aaa m. 'S coo', bro. aaa")
    }

    @Test
    fun should_translate_full_stop_n_variation() {
        verifyTranslation("aaa n. aaa", "aaa n. 'S coo', bro. aaa")
    }

    @Test
    fun should_translate_full_stop_q_variation() {
        verifyTranslation("aaa q. aaa", "aaa q. Ah be baaad... aaa")
    }

    @Test
    fun should_translate_full_stop_r_variation() {
        verifyTranslation("aaa r. aaa", "aaa r. Ah be baaad... aaa")
    }

    @Test
    fun should_translate_full_stop_u_variation() {
        verifyTranslation("aaa u. aaa", "aaa u. Man! aaa")
    }

    @Test
    fun should_translate_full_stop_v_variation() {
        verifyTranslation("aaa v. aaa", "aaa v. Man! aaa")
    }

    @Test
    fun should_translate_full_stop_y_variation() {
        verifyTranslation("aaa y. aaa", "aaa y. Slap mah fro! aaa")
    }

    @Test
    fun should_translate_full_stop_z_variation() {
        verifyTranslation("aaa z. aaa", "aaa z. Slap mah fro! aaa")
    }

    @Test
    fun should_translate_Sure() {
        verifyTranslation("aaa Sure aaa", "aaa Sho' nuff aaa")
    }

    @Test
    fun should_translate_sure() {
        verifyTranslation("aaa sure aaa", "aaa sho' nuff aaa")
    }

    @Test
    fun should_not_translate_pressure() {
        verifyTranslation("pressure", "pressure")
    }

    @Test
    fun should_translate_get() {
        verifyTranslation("getaway", "gitaway")
    }

    @Test
    fun should_not_translate_forget() {
        verifyTranslation("forget", "forget")
    }

    @Test
    fun should_translate_will_have() {
        verifyTranslation("aaa will have aaa", "aaa gots'ta aaa")
    }

    @Test
    fun should_translate_will() {
        verifyTranslation("aaa will aaa", "aaa gots'ta aaa")
    }

    @Test
    fun should_translate_got_to() {
        verifyTranslation("aaa got to aaa", "aaa gots'ta aaa")
    }

    @Test
    fun should_translate_I_am() {
        verifyTranslation("aaa I am aaa", "aaa I's gots'ta be aaa")
    }

    @Test
    fun should_translate_am_not() {
        verifyTranslation("aaa am not aaa", "aaa aint aaa")
    }

    @Test
    fun should_translate_is_not() {
        verifyTranslation("aaa is not aaa", "aaa aint aaa")
    }

    @Test
    fun should_translate_are_not() {
        verifyTranslation("aaa are not aaa", "aaa aint aaa")
    }

    @Test
    fun should_translate_are_your() {
        verifyTranslation("aaa are your aaa", "aaa is yo' aaa")
    }

    @Test
    fun should_translate_are_you() {
        verifyTranslation("aaa are you aaa", "aaa you is aaa")
    }

    @Test
    fun should_translate_hat() {
        verifyTranslation("aaa hat aaa", "aaa fedora aaa")
    }

    @Test
    fun should_not_translate_hatred() {
        verifyTranslation("hatred", "hatred")
    }

    @Test
    fun should_translate_shoe() {
        verifyTranslation("aaa shoe aaa", "aaa kicker aaa")
    }

    @Test
    fun should_not_translate_shoebox() {
        verifyTranslation("shoebox", "shoebox")
    }

    @Test
    fun should_translate_havent() {
        verifyTranslation("aaa haven't aaa", "aaa aint aaa")
    }

    @Test
    fun should_translate_have_to() {
        verifyTranslation("aaa have to aaa", "aaa gots'ta aaa")
    }

    @Test
    fun should_translate_have() {
        verifyTranslation("aaa have aaa", "aaa gots' aaa")
    }

    @Test
    fun should_translate_has() {
        verifyTranslation("aaa has aaa", "aaa gots'ta aaa")
    }

    @Test
    fun should_translate_come_over() {
        verifyTranslation("aaa come over aaa", "aaa mosey on down aaa")
    }

    @Test
    fun should_translate_come() {
        verifyTranslation("aaa come aaa", "aaa mosey on down aaa")
    }

    @Test
    fun should_not_translate_outcome() {
        verifyTranslation("outcome", "outcome")
    }

    @Test
    fun should_translate_exclamation_mark() {
        verifyTranslation("aaa! aaa", "aaa. Right On! aaa")
    }

    @Test
    fun should_translate_buy() {
        verifyTranslation("aaa buy aaa", "aaa steal aaa")
    }

    @Test
    fun should_translate_buyer() {
        verifyTranslation("buyer", "buya'")
    }

    @Test
    fun should_translate_car() {
        verifyTranslation("aaa car aaa", "aaa wheels aaa")
    }

    @Test
    fun should_translate_carcus() {
        verifyTranslation("carcus", "carcus")
    }

    @Test
    fun should_translate_drive() {
        verifyTranslation("aaa drive aaa", "aaa roll aaa")
    }

    @Test
    fun should_translate_screwdriver() {
        verifyTranslation("screwdriver", "screwdriva'")
    }

    @Test
    fun should_translate_eat() {
        verifyTranslation("aaa eat aaa", "aaa feed da bud aaa")
    }

    @Test
    fun should_not_translate_conceat() {
        verifyTranslation("concreat", "concreat")
    }

    @Test
    fun should_translate_black() {
        verifyTranslation("aaa black aaa", "aaa brother aaa")
    }

    @Test
    fun should_not_translate_blackest() {
        verifyTranslation("blackest", "blackest")
    }

    @Test
    fun should_translate_negro() {
        verifyTranslation("aaa negro aaa", "aaa brother aaa")
    }

    @Test
    fun should_translate_white() {
        verifyTranslation("aaa white aaa", "aaa honky aaa")
    }

    @Test
    fun should_translate_whiter() {
        verifyTranslation("whiter", "whita'")
    }

    @Test
    fun should_translate_nigger() {
        verifyTranslation("aaa nigger aaa", "aaa gentleman aaa")
    }

    @Test
    fun should_translate_nice() {
        verifyTranslation("aaa nice aaa", "aaa supa' fine aaa")
    }

    @Test
    fun should_note_translate_niceties() {
        verifyTranslation("niceties", "niceties")
    }

    @Test
    fun should_translate_person() {
        verifyTranslation("aaa person aaa", "aaa sucka' aaa")
    }

    @Test
    fun should_not_translate_personalities() {
        verifyTranslation("personalities", "personalities")
    }

    @Test
    fun should_translate_persons() {
        verifyTranslation("aaa persons aaa", "aaa sucka's aaa")
    }

    @Test
    fun should_translate_thing() {
        verifyTranslation("aaa thing aaa", "aaa wahtahmellun aaa")
    }

    @Test
    fun should_not_translate_clothing() {
        verifyTranslation("clothing", "clothing")
    }

    @Test
    fun should_translate_home() {
        verifyTranslation("aaa home aaa", "aaa crib aaa")
    }

    @Test
    fun should_translate_whomever() {
        verifyTranslation("whomever", "whomeva'")
    }

    @Test
    fun should_translate_name() {
        verifyTranslation("aaa name aaa", "aaa dojigger aaa")
    }

    @Test
    fun should_not_translate_tournament() {
        verifyTranslation("tournament", "tournament")
    }

    @Test
    fun should_translate_path() {
        verifyTranslation("aaa path aaa", "aaa alley aaa")
    }

    @Test
    fun should_not_translate_sociopath() {
        verifyTranslation("sociopath", "sociopath")
    }

    @Test
    fun should_translate_computer() {
        verifyTranslation("aaa computer aaa", "aaa clunker aaa")

    }

    @Test
    fun should_translate_or() {
        verifyTranslation("aaa or aaa", "aaa o' aaa")
    }

    @Test
    fun should_not_translate_orange() {
        verifyTranslation("orange", "orange")
    }

    @Test
    fun should_translate_killed() {
        verifyTranslation("aaa killed aaa", "aaa wasted aaa")
    }

    @Test
    fun should_not_translate_skilled() {
        verifyTranslation("skilled", "skilled")
    }

    @Test
    fun should_translate_president() {
        verifyTranslation("aaa president aaa", "aaa super-dude aaa")
    }

    @Test
    fun should_not_translate_presidential() {
        verifyTranslation("presidential", "presidential")
    }

    @Test
    fun should_translate_prime_minister() {
        verifyTranslation("aaa prime minister aaa", "aaa super honcho aaa")
    }

    @Test
    fun should_not_translate_prime_ministerial() {
        verifyTranslation("prime ministerial", "prime ministerial")
    }

    @Test
    fun should_translate_injured() {
        verifyTranslation("aaa injured aaa", "aaa hosed aaa")
    }

    @Test
    fun should_not_translate_reinjured() {
        verifyTranslation("reinjured", "reinjured")
    }

    @Test
    fun should_translate_government() {
        verifyTranslation("aaa government aaa", "aaa guv'ment aaa")
    }

    @Test
    fun should_translate_knew() {
        verifyTranslation("misknew", "misknew")
    }

    @Test
    fun should_not_translate_misknew() {
        verifyTranslation("misknew", "misknew")
    }

    @Test
    fun should_translate_Because() {
        verifyTranslation("aaa Because aaa", "aaa B'cuz aaa")
    }

    @Test
    fun should_translate_because() {
        verifyTranslation("aaa because aaa", "aaa b'cuz aaa")
    }

    @Test
    fun should_translate_Your() {
        verifyTranslation("Yourself", "Yo'self")
    }

    @Test
    fun should_translate_your() {
        verifyTranslation("yourself", "yo'self")
    }

    @Test
    fun should_translate_four() {
        verifyTranslation("fourteen", "foeteen")
    }

    @Test
    fun should_translate_got() {
        verifyTranslation("aaa got aaa", "aaa gots aaa")
    }

    @Test
    fun should_not_translate_gothic() {
        verifyTranslation("gothic", "gothic")
    }

    @Test
    fun should_translate_arent() {
        verifyTranslation("aaa aren't aaa", "aaa ain't aaa")
    }

    @Test
    fun should_translate_young() {
        verifyTranslation("aaa young aaa", "aaa yung aaa")
    }

    @Test
    fun should_translate_youngster() {
        verifyTranslation("youngster", "yungsta'")
    }

    @Test
    fun should_translate_you() {
        verifyTranslation("aaa you aaa", "aaa ya' aaa")
    }

    @Test
    fun should_translate_You() {
        verifyTranslation("aaa You aaa", "aaa You's aaa")
    }

    @Test
    fun should_translate_first() {
        verifyTranslation("firstly", "fustly")
    }

    @Test
    fun should_translate_police() {
        verifyTranslation("aaa police aaa", "aaa honky pigs aaa")
    }

    @Test
    fun should_not_translate_policed() {
        verifyTranslation("policed", "policed")
    }

    @Test
    fun should_translate_string() {
        verifyTranslation("aaa string aaa", "aaa chittlin' aaa")
    }

    @Test
    fun should_not_translate_hamstring() {
        verifyTranslation("hamstring", "hamstring")
    }

    @Test
    fun should_translate_read() {
        verifyTranslation("aaa read aaa", "aaa eyeball aaa")
    }

    @Test
    fun should_not_translate_readiness() {
        verifyTranslation("readiness", "readiness")
    }

    @Test
    fun should_translate_write() {
        verifyTranslation("aaa write aaa", "aaa scribble aaa")
    }

    @Test
    fun should_translate_th() {
        verifyTranslation("that", "dat")
    }

    @Test
    fun should_translate_Th() {
        verifyTranslation("That", "Dat")
    }

    @Test
    fun should_translate_ing() {
        verifyTranslation("winning", "winnin'")
    }

    @Test
    fun should_translate_a() {
        verifyTranslation("aaa a aaa", "aaa some aaa")
    }

    @Test
    fun should_not_translate_aweseome() {
        verifyTranslation("awesome", "awesome")
    }

    @Test
    fun should_translate_to() {
        verifyTranslation("to town", "t'town")
    }

    @Test
    fun should_not_translate_too() {
        verifyTranslation("too", "too")
    }

    @Test
    fun should_translate_tion() {
        verifyTranslation("election", "elecshun")
    }

    @Test
    fun should_translate_almost() {
        verifyTranslation("aaa almost aaa", "aaa mos' aaa")
    }

    @Test
    fun should_translate_from() {
        verifyTranslation("aaa from aaa", "aaa fum aaa")
    }

    @Test
    fun should_not_translate_wherefrom() {
        verifyTranslation("wherefrom", "wherefrom")
    }

    @Test
    fun should_translate_Youre() {
        verifyTranslation("aaa You're aaa", "aaa Youse aaa")
    }

    @Test
    fun should_translate_youre() {
        verifyTranslation("aaa you're aaa", "aaa youse aaa")
    }

    @Test
    fun should_translate_alright() {
        verifyTranslation("aaa alright aaa", "aaa coo' aaa")
    }

    @Test
    fun should_translate_okay() {
        verifyTranslation("aaa okay aaa", "aaa coo' aaa")
    }

    @Test
    fun should_translate_er() {
        verifyTranslation("winter", "winta'")
    }

    @Test
    fun should_not_translate_error() {
        verifyTranslation("error", "error")
    }

    @Test
    fun should_translate_known() {
        verifyTranslation("aaa known aaa", "aaa knode aaa")
    }

    @Test
    fun should_translate_want() {
        verifyTranslation("aaa want aaa", "aaa wants' aaa")
    }

    @Test
    fun should_translate_beat() {
        verifyTranslation("aaa beat aaa", "aaa whup' aaa")
    }

    @Test
    fun should_translate_beating() {
        verifyTranslation("aaa beat aaa", "aaa whup' aaa")
        verifyTranslation("beating", "beatin'")
    }

    @Test
    fun should_translate_exp() {
        verifyTranslation("explain", "'splain")
    }

    @Test
    fun should_translate_exs() {
        verifyTranslation("exsert", "'sert")
    }

    @Test
    fun should_translate_exc() {
        verifyTranslation("exclaim", "'slaim")
    }

    @Test
    fun should_translate_ex() {
        verifyTranslation("extra", "'estra")
    }

    @Test
    fun should_translate_like() {
        verifyTranslation("aaa like aaa", "aaa likes aaa")
    }

    @Test
    fun should_not_translate_likes() {
        verifyTranslation("likes", "likes")
    }

    @Test
    fun should_translate_did() {
        verifyTranslation("aaa did aaa", "aaa dun did aaa")
    }

    @Test
    fun should_not_translate_candid() {
        verifyTranslation("candid", "candid")
    }

    @Test
    fun should_translate_kind_of() {
        verifyTranslation("aaa kind of aaa", "aaa kind'a aaa")
    }

    @Test
    fun should_translate_mankind_offered() {
        verifyTranslation("mankind offered", "mankind offered")
    }

    @Test
    fun should_translate_women() {
        verifyTranslation("aaa women aaa", "aaa honky chicks aaa")
    }

    @Test
    fun should_not_translate_anchorwomen() {
        verifyTranslation("anchorwomen", "anchorwomen")
    }

    @Test
    fun should_translate_men() {
        verifyTranslation("aaa men aaa", "aaa dudes aaa")
    }

    @Test
    fun should_translate_dead() {
        verifyTranslation("aaa dead aaa", "aaa wasted aaa")
    }

    @Test
    fun should_not_translate_deadliest() {
        verifyTranslation("deadliest", "deadliest")
    }

    @Test
    fun should_translate_good() {
        verifyTranslation("aaa good aaa", "aaa baaaad aaa")
    }

    @Test
    fun should_not_translate_goodbye() {
        verifyTranslation("goodbye", "goodbye")
    }

    @Test
    fun should_translate_open() {
        verifyTranslation("aaa open aaa", "aaa jimmey aaa")
    }

    @Test
    fun should_translate_opened() {
        verifyTranslation("opened", "jimmey'd")
    }

    @Test
    fun should_not_translate_unopened() {
        verifyTranslation("unopened", "unopened")
    }

    @Test
    fun should_translate_very() {
        verifyTranslation("aaa very aaa", "aaa real aaa")
    }

    @Test
    fun should_not_translate_avery() {
        verifyTranslation("avery", "avery")
    }

    @Test
    fun should_translate_per() {
        verifyTranslation("aaa per aaa", "aaa puh' aaa")
    }

    @Test
    fun should_not_translate_copper() {
        verifyTranslation("copper", "copper")
    }

    @Test
    fun should_translate_oar() {
        verifyTranslation("aaa oar aaa", "aaa o' aaa")
    }

    @Test
    fun should_not_translate_soar() {
        verifyTranslation("soar", "soar")
    }

    @Test
    fun should_translate_can() {
        verifyTranslation("aaa can aaa", "aaa kin aaa")
    }

    @Test
    fun should_not_translate_uncanny() {
        verifyTranslation("uncanny", "uncanny")
    }

    @Test
    fun should_translate_just() {
        verifyTranslation("aaa just aaa", "aaa plum aaa")
    }

    @Test
    fun should_not_translate_adjust() {
        verifyTranslation("adjust", "adjust")
    }

    @Test
    fun should_translate_Detroit() {
        verifyTranslation("aaa Detroit aaa", "aaa Mo-town aaa")
    }

    @Test
    fun should_translate_detroit() {
        verifyTranslation("aaa detroit aaa", "aaa Mo-town aaa")
    }

    @Test
    fun should_translate_believe() {
        verifyTranslation("aaa believe aaa", "aaa recon' aaa")
    }

    @Test
    fun should_translate_Indianapolis() {
        verifyTranslation("aaa Indianapolis aaa", "aaa Nap-town aaa")
    }

    @Test
    fun should_translate_indianapolis() {
        verifyTranslation("aaa indianapolis aaa", "aaa Nap-town aaa")
    }

    @Test
    fun should_translate_Jack() {
        verifyTranslation("aaa Jack aaa", "aaa Buckwheat aaa")
    }

    @Test
    fun should_not_translate_Jackal() {
        verifyTranslation("Jackal", "Jackal")
    }

    @Test
    fun should_translate_jack() {
        verifyTranslation("aaa jack aaa", "aaa Buckwheat aaa")
    }

    @Test
    fun should_not_translate_jackal() {
        verifyTranslation("jackal", "jackal")
    }

    @Test
    fun should_translate_Bob() {
        verifyTranslation("aaa Bob aaa", "aaa Liva' Lips aaa")
    }

    @Test
    fun should_nottranslate_Bobby() {
        verifyTranslation("Bobby", "Bobby")
    }

    @Test
    fun should_translate_bob() {
        verifyTranslation("aaa bob aaa", "aaa Liva' Lips aaa")
    }

    @Test
    fun should_nottranslate_bobby() {
        verifyTranslation("bobby", "bobby")
    }

    @Test
    fun should_translate_Phil() {
        verifyTranslation("aaa Phil aaa", "aaa dat fine soul aaa")
    }

    @Test
    fun should_translate_Phillip() {
        verifyTranslation("Phillip", "Phillip")
    }

    @Test
    fun should_translate_phil() {
        verifyTranslation("aaa phil aaa", "aaa dat fine soul aaa")
    }

    @Test
    fun should_translate_phillip() {
        verifyTranslation("phillip", "phillip")
    }

    @Test
    fun should_translate_Mark() {
        verifyTranslation("aaa Mark aaa", "aaa Amos aaa")
    }

    @Test
    fun should_translate_mark() {
        verifyTranslation("aaa mark aaa", "aaa Amos aaa")
    }

    @Test
    fun should_translate_Robert() {
        verifyTranslation("Roberto", "Roberto")
    }

    @Test
    fun should_not_translate_Roberto() {
        verifyTranslation("Roberto", "Roberto")
    }

    @Test
    fun should_translate_robert() {
        verifyTranslation("aaa robert aaa", "aaa Leroy aaa")
    }

    @Test
    fun should_not_translate_roberto() {
        verifyTranslation("roberto", "roberto")
    }

    @Test
    fun should_translate_Sandy() {
        verifyTranslation("aaa Sandy aaa", "aaa dat fine femahnaine ladee aaa")
    }

    @Test
    fun should_translate_sandy() {
        verifyTranslation("aaa sandy aaa", "aaa dat fine femahnaine ladee aaa")
    }

    @Test
    fun should_translate_John() {
        verifyTranslation("aaa John aaa", "aaa Raz'tus aaa")
    }

    @Test
    fun should_not_translate_Johnny() {
        verifyTranslation("Johnny", "Johnny")
    }

    @Test
    fun should_translate_john() {
        verifyTranslation("aaa john aaa", "aaa Raz'tus aaa")
    }

    @Test
    fun should_not_translate_johnny() {
        verifyTranslation("johnny", "johnny")
    }

    @Test
    fun should_translate_Paul() {
        verifyTranslation("aaa Paul aaa", "aaa Fuh'rina aaa")
    }

    @Test
    fun should_not_translate_Paula() {
        verifyTranslation("Paula", "Paula")
    }

    @Test
    fun should_translate_paul() {
        verifyTranslation("aaa paul aaa", "aaa Fuh'rina aaa")
    }

    @Test
    fun should_not_translate_paula() {
        verifyTranslation("paula", "paula")
    }

    @Test
    fun should_translate_Reagan() {
        verifyTranslation("aaa Reagan aaa", "aaa Kingfish aaa")
    }

    @Test
    fun should_translate_Reaganomics() {
        verifyTranslation("Reaganomics", "Reaganomics")
    }

    @Test
    fun should_translate_reagan() {
        verifyTranslation("aaa reagan aaa", "aaa Kingfish aaa")
    }

    @Test
    fun should_not_translate_reaganomics() {
        verifyTranslation("reaganomics", "reaganomics")
    }

    @Test
    fun should_translate_David() {
        verifyTranslation("aaa David aaa", "aaa Issac aaa")
    }

    @Test
    fun should_translate_david() {
        verifyTranslation("aaa david aaa", "aaa Issac aaa")
    }

    @Test
    fun should_translate_Ronald() {
        verifyTranslation("aaa Ronald aaa", "aaa Rolo aaa")
    }

    @Test
    fun should_translate_ronald() {
        verifyTranslation("aaa ronald aaa", "aaa Rolo aaa")
    }

    @Test
    fun should_translate_Jim() {
        verifyTranslation("aaa Jim aaa", "aaa Bo-Jangles aaa")
    }

    @Test
    fun should_not_translate_Jimmy() {
        verifyTranslation("Jimmy", "Jimmy")
    }

    @Test
    fun should_translate_jim() {
        verifyTranslation("aaa jim aaa", "aaa Bo-Jangles aaa")
    }

    @Test
    fun should_not_translate_jimmy() {
        verifyTranslation("jimmy", "jimmy")
    }

    @Test
    fun should_translate_Mary() {
        verifyTranslation("aaa Mary aaa", "aaa Snow Flake aaa")
    }

    @Test
    fun should_not_translate_Maryanne() {
        verifyTranslation("Maryanne", "Maryanne")
    }

    @Test
    fun should_translate_mary() {
        verifyTranslation("aaa mary aaa", "aaa Snow Flake aaa")
    }

    @Test
    fun should_not_translate_maryanne() {
        verifyTranslation("maryanne", "maryanne")
    }

    @Test
    fun should_translate_Larry() {
        verifyTranslation("aaa Larry aaa", "aaa Remus aaa")
    }

    @Test
    fun should_translate_larry() {
        verifyTranslation("aaa larry aaa", "aaa Remus aaa")
    }

    @Test
    fun should_translate_Mohammed() {
        verifyTranslation("aaa Mohammed aaa", "aaa Home Boy aaa")
    }

    @Test
    fun should_translate_mohammed() {
        verifyTranslation("aaa mohammed aaa", "aaa Home Boy aaa")
    }

    @Test
    fun should_translate_Pope() {
        verifyTranslation("aaa Pope aaa", "aaa wiz' aaa")
    }

    @Test
    fun should_translate_pope() {
        verifyTranslation("aaa pope aaa", "aaa wiz' aaa")
    }

    @Test
    fun should_translate_Pontiff() {
        verifyTranslation("aaa Pontiff aaa", "aaa wiz' aaa")
    }

    @Test
    fun should_translate_pontiff() {
        verifyTranslation("aaa pontiff aaa", "aaa wiz' aaa")
    }

    @Test
    fun should_translate_Pravda() {
        verifyTranslation("aaa Pravda aaa", "aaa dat commie rag aaa")
    }

    @Test
    fun should_translate_pravda() {
        verifyTranslation("aaa pravda aaa", "aaa dat commie rag aaa")
    }

    @Test
    fun should_translate_broken() {
        verifyTranslation("aaa broken aaa", "aaa bugger'd aaa")
    }

    @Test
    fun should_not_translate_unbrokenny() {
        verifyTranslation("unbrokenny", "unbrokenny")
    }

    @Test
    fun should_translate_strange() {
        verifyTranslation("unstrangeny", "unstrangeny")
    }

    @Test
    fun should_not_translate_unstrangeny() {
        verifyTranslation("unstrangeny", "unstrangeny")
    }

    @Test
    fun should_translate_dance() {
        verifyTranslation("aaa dance aaa", "aaa boogy aaa")
    }

    @Test
    fun should_not_translate_undanceny() {
        verifyTranslation("undanceny", "undanceny")
    }

    @Test
    fun should_translate_house() {
        verifyTranslation("aaa house aaa", "aaa crib aaa")
    }

    @Test
    fun should_translate_ask() {
        verifyTranslation("aaa ask aaa", "aaa ax' aaa")
    }

    @Test
    fun should_not_translate_unaskny() {
        verifyTranslation("unaskny", "unaskny")
    }

    @Test
    fun should_translate_so() {
        verifyTranslation("aaa so aaa", "aaa so's aaa")
    }

    @Test
    fun should_not_translate_unsony() {
        verifyTranslation("unsony", "unsony")
    }

    @Test
    fun should_translate_head() {
        verifyTranslation("aaa head aaa", "aaa 'haid aaa")
    }

    @Test
    fun should_not_translate_unheadny() {
        verifyTranslation("unheadny", "unheadny")
    }

    @Test
    fun should_translate_boss() {
        verifyTranslation("aaa boss aaa", "aaa main man aaa")
    }

    @Test
    fun should_not_translate_unbossny() {
        verifyTranslation("unbossny", "unbossny")
    }

    @Test
    fun should_translate_wife() {
        verifyTranslation("aaa wife aaa", "aaa mama aaa")
    }

    @Test
    fun should_not_translate_unwifeny() {
        verifyTranslation("unwifeny", "unwifeny")
    }

    @Test
    fun should_translate_people() {
        verifyTranslation("aaa people aaa", "aaa sucka's aaa")
    }

    @Test
    fun should_not_translate_unpeopleny() {
        verifyTranslation("unpeopleny", "unpeopleny")
    }

    @Test
    fun should_translate_money() {
        verifyTranslation("aaa money aaa", "aaa bre'd aaa")
    }

    @Test
    fun should_not_translate_unmoneyny() {
        verifyTranslation("unmoneyny", "unmoneyny")
    }

    @Test
    fun should_translate_a_colon() {
        verifyTranslation("a:", "a, dig dis:")
    }

    @Test
    fun should_translate_b_colon() {
        verifyTranslation("b:", "b, dig dis:")
    }

    @Test
    fun should_translate_c_colon() {
        verifyTranslation("c:", "c, dig dis:")
    }

    @Test
    fun should_translate_d_colon() {
        verifyTranslation("d:", "d, dig dis:")
    }

    @Test
    fun should_translate_e_colon() {
        verifyTranslation("e:", "e, dig dis:")
    }

    @Test
    fun should_translate_f_colon() {
        verifyTranslation("f:", "f, dig dis:")
    }

    @Test
    fun should_translate_g_colon() {
        verifyTranslation("g:", "g, dig dis:")
    }

    @Test
    fun should_translate_h_colon() {
        verifyTranslation("h:", "h, dig dis:")
    }

    @Test
    fun should_translate_i_colon() {
        verifyTranslation("i:", "i, dig dis:")
    }

    @Test
    fun should_translate_j_colon() {
        verifyTranslation("j:", "j, dig dis:")
    }

    @Test
    fun should_translate_k_colon() {
        verifyTranslation("k:", "k, dig dis:")
    }

    @Test
    fun should_translate_l_colon() {
        verifyTranslation("l:", "l, dig dis:")
    }

    @Test
    fun should_translate_m_colon() {
        verifyTranslation("m:", "m, dig dis:")
    }

    @Test
    fun should_translate_n_colon() {
        verifyTranslation("n:", "n, dig dis:")
    }

    @Test
    fun should_translate_o_colon() {
        verifyTranslation("o:", "o, dig dis:")
    }

    @Test
    fun should_translate_p_colon() {
        verifyTranslation("http:", "http:")
    }

    @Test
    fun should_translate_q_colon() {
        verifyTranslation("q:", "q, dig dis:")
    }

    @Test
    fun should_translate_r_colon() {
        verifyTranslation("r:", "r, dig dis:")
    }

    @Test
    fun should_translate_s_colon() {
        verifyTranslation("https:", "https:")
    }

    @Test
    fun should_translate_t_colon() {
        verifyTranslation("t:", "t, dig dis:")
    }

    @Test
    fun should_translate_u_colon() {
        verifyTranslation("u:", "u, dig dis:")
    }

    @Test
    fun should_translate_v_colon() {
        verifyTranslation("v:", "v, dig dis:")
    }

    @Test
    fun should_translate_w_colon() {
        verifyTranslation("w:", "w, dig dis:")
    }

    @Test
    fun should_translate_x_colon() {
        verifyTranslation("x:", "x, dig dis:")
    }

    @Test
    fun should_translate_y_colon() {
        verifyTranslation("y:", "y, dig dis:")
    }

    @Test
    fun should_translate_z_colon() {
        verifyTranslation("z:", "z, dig dis:")
    }

    @Test
    fun should_translate_amateur() {
        verifyTranslation("aaa amateur aaa", "aaa begina' aaa")
    }

    @Test
    fun should_not_translate_unamateurny() {
        verifyTranslation("unamateurny", "unamateurny")
    }

    @Test
    fun should_translate_radio() {
        verifyTranslation("aaa radio aaa", "aaa transista' aaa")
    }

    @Test
    fun should_not_translate_unradiony() {
        verifyTranslation("unradiony", "unradiony")
    }

    @Test
    fun should_translate_of() {
        verifyTranslation("aaa of aaa", "aaa uh' aaa")
    }

    @Test
    fun should_not_translate_unofny() {
        verifyTranslation("unofny", "unofny")
    }

    @Test
    fun should_translate_what() {
        verifyTranslation("aaa what aaa", "aaa whut aaa")
    }

    @Test
    fun should_not_translate_unwhatny() {
        verifyTranslation("unwhatny", "unwhatny")
    }

    @Test
    fun should_translate_does() {
        verifyTranslation("aaa does aaa", "aaa duz aaa")
    }

    @Test
    fun should_not_translate_undoesny() {
        verifyTranslation("undoesny", "undoesny")
    }

    @Test
    fun should_translate_was() {
        verifyTranslation("aaa was aaa", "aaa wuz aaa")
    }

    @Test
    fun should_not_translate_unwasny() {
        verifyTranslation("unwasny", "unwasny")
    }

    @Test
    fun should_translate_were() {
        verifyTranslation("aaa were aaa", "aaa wuz aaa")
    }

    @Test
    fun should_not_translate_unwereny() {
        verifyTranslation("unwereny", "unwereny")
    }

    @Test
    fun should_translate_understand() {
        verifyTranslation("aaa understand aaa", "aaa dig it aaa")
    }

    @Test
    fun should_not_translate_ununderstandny() {
        verifyTranslation("ununderstandny", "ununderstandny")
    }

    @Test
    fun should_translate_understand_it() {
        verifyTranslation("aaa understand it aaa", "aaa dig it aaa")
    }

    @Test
    fun should_not_translate_ununderstand_itny() {
        verifyTranslation("ununderstand itny", "ununderstand itny")
    }

    @Test
    fun should_translate_my() {
        verifyTranslation("aaa my aaa", "aaa mah aaa")
    }

    @Test
    fun should_not_translate_unmyny() {
        verifyTranslation("unmyny", "unmyny")
    }

    @Test
    fun should_translate_I() {
        verifyTranslation("aaa I aaa", "aaa ah' aaa")
    }

    @Test
    fun should_not_translate_unIny() {
        verifyTranslation("unIny", "unIny")
    }

    @Test
    fun should_translate_meta() {
        verifyTranslation("aaa meta aaa", "aaa meta-fuckin' aaa")
    }

    @Test
    fun should_not_translate_unmetany() {
        verifyTranslation("unmetany", "unmetany")
    }

    @Test
    fun should_translate_hair() {
        verifyTranslation("aaa hair aaa", "aaa fro aaa")
    }

    @Test
    fun should_not_translate_unhairny() {
        verifyTranslation("unhairny", "unhairny")
    }

    @Test
    fun should_translate_talk() {
        verifyTranslation("aaa talk aaa", "aaa rap aaa")
    }

    @Test
    fun should_not_translate_untalkny() {
        verifyTranslation("untalkny", "untalkny")
    }

    @Test
    fun should_translate_music() {
        verifyTranslation("aaa music aaa", "aaa beat aaa")
    }

    @Test
    fun should_not_translate_unmusicny() {
        verifyTranslation("unmusicny", "unmusicny")
    }

    @Test
    fun should_translate_basket() {
        verifyTranslation("aaa basket aaa", "aaa hoop aaa")
    }

    @Test
    fun should_not_translate_unbasketny() {
        verifyTranslation("unbasketny", "unbasketny")
    }

    @Test
    fun should_translate_football() {
        verifyTranslation("aaa football aaa", "aaa ball aaa")
    }

    @Test
    fun should_ntot_translate_unfootballny() {
        verifyTranslation("unfootballny", "unfootballny")
    }

    @Test
    fun should_translate_friend() {
        verifyTranslation("aaa friend aaa", "aaa homey aaa")
    }

    @Test
    fun should_not_translate_unfriendny() {
        verifyTranslation("unfriendny", "unfriendny")
    }

    @Test
    fun should_translate_school() {
        verifyTranslation("aaa school aaa", "aaa farm aaa")
    }

    @Test
    fun should_not_translate_unschoolny() {
        verifyTranslation("unschoolny", "unschoolny")
    }

    @Test
    fun should_translate_my_boss() {
        verifyTranslation("aaa my boss aaa", "aaa The Man aaa")
    }

    @Test
    fun should_not_translate_unmy_bossny() {
        verifyTranslation("unmy bossny", "unmy bossny")
    }

    @Test
    fun should_translate_want_to() {
        verifyTranslation("aaa want to aaa", "aaa wanna aaa")
    }

    @Test
    fun should_not_translate_unwant_tony() {
        verifyTranslation("unwant tony", "unwant tony")
    }

    @Test
    fun should_translate_wants_to() {
        verifyTranslation("aaa wants to aaa", "aaa be hankerin' aftah aaa")
    }

    @Test
    fun should_not_translate_unwants_tony() {
        verifyTranslation("unwants tony", "unwants tony")
    }

    @Test
    fun should_translate_Well() {
        verifyTranslation("aaa Well aaa", "aaa Sheeit aaa")
    }

    @Test
    fun should_not_translate_unWellny() {
        verifyTranslation("unWellny", "unWellny")
    }

    @Test
    fun should_translate_well() {
        verifyTranslation("aaa well aaa", "aaa sheeit aaa")
    }

    @Test
    fun should_not_translate_unwellny() {
        verifyTranslation("unwellny", "unwellny")
    }

    @Test
    fun should_translate_big() {
        verifyTranslation("aaa big aaa", "aaa big-ass aaa")
    }

    @Test
    fun should_not_translate_unbigny() {
        verifyTranslation("unbigny", "unbigny")
    }

    @Test
    fun should_translate_bad() {
        verifyTranslation("aaa bad aaa", "aaa bad-ass aaa")
    }

    @Test
    fun should_not_translate_unbadny() {
        verifyTranslation("unbadny", "unbadny")
    }

    @Test
    fun should_translate_small() {
        verifyTranslation("aaa small aaa", "aaa little-ass aaa")
    }

    @Test
    fun should_not_translate_unsmallny() {
        verifyTranslation("unsmallny", "unsmallny")
    }

    @Test
    fun should_translate_sort_of() {
        verifyTranslation("aaa sort of aaa", "aaa radical aaa")
    }

    @Test
    fun should_not_translate_unsort_ofny() {
        verifyTranslation("unsort ofny", "unsort ofny")
    }

    @Test
    fun should_translate_is() {
        verifyTranslation("aaa is aaa", "aaa be aaa")
    }

    @Test
    fun should_not_translate_unisny() {
        verifyTranslation("unisny", "unisny")
    }

    @Test
    fun should_translate_water() {
        verifyTranslation("aaa water aaa", "aaa booze aaa")
    }

    @Test
    fun should_not_translate_unwaterny() {
        verifyTranslation("unwaterny", "unwaterny")
    }

    @Test
    fun should_translate_book() {
        verifyTranslation("aaa book aaa", "aaa scribblin' aaa")
    }

    @Test
    fun should_not_translate_unbookny() {
        verifyTranslation("unbookny", "unbookny")
    }

    @Test
    fun should_translate_magazine() {
        verifyTranslation("aaa magazine aaa", "aaa issue of GQ aaa")
    }

    @Test
    fun should_not_translate_unmagazineny() {
        verifyTranslation("unmagazineny", "unmagazineny")
    }

    @Test
    fun should_translate_paper() {
        verifyTranslation("aaa paper aaa", "aaa sheet aaa")
    }

    @Test
    fun should_not_translate_unpaperny() {
        verifyTranslation("unpaperny", "unpaperny")
    }

    @Test
    fun should_translate_up() {
        verifyTranslation("aaa up aaa", "aaa down aaa")
    }

    @Test
    fun should_not_translate_unupny() {
        verifyTranslation("unupny", "unupny")
    }

    @Test
    fun should_translate_down() {
        verifyTranslation("aaa down aaa", "aaa waaay down aaa")
    }

    @Test
    fun should_not_translate_undownny() {
        verifyTranslation("undownny", "undownny")
    }

    @Test
    fun should_translate_Hi() {
        verifyTranslation("aaa Hi aaa", "aaa 'Sup, dude aaa")
    }

    @Test
    fun should_not_translate_unHiny() {
        verifyTranslation("unHiny", "unHiny")
    }

    @Test
    fun should_translate_VAX() {
        verifyTranslation("aaa VAX aaa", "aaa Pink Cadillac aaa")
    }

    @Test
    fun should_not_translate_unVAXy() {
        verifyTranslation("aaa unVAXy aaa", "aaa unVAXy aaa")
    }

    @Test
    fun should_translate_statusWithEntities() {
        // Given
        val statusText = "RT @AndrewDunn10 .@CheerfulPodcast is a remarkably fun #podcast. Worth a listen if you're interested in progressive politics and trying to make the world a little better."
        val translated = "RT @AndrewDunn10 .@CheerfulPodcast be some remarkably fun #podcast. Word some listen if youse interested in progressive politics and tryin' t'make da damn world some little better. Ah be baaad..."


        val translationEntity0 = TranslationEntity.translate(0, 3, "RT ")
        val translationEntity1 = TranslationEntity.verbatim(3, 16, "@AndrewDunn10")
        val translationEntity2 = TranslationEntity.translate(16, 18, " .")
        val translationEntity3 = TranslationEntity.verbatim(18, 34, "@CheerfulPodcast")
        val translationEntity4 = TranslationEntity.translate(34, 55, " is a remarkably fun ")
        val translationEntity5 = TranslationEntity.verbatim(55, 63, "#podcast")
        val translationEntity6 = TranslationEntity.translate(63, 170, ". Worth a listen if you're interested in progressive politics and trying to make the world a little better.")
        val entitiesList = ArrayList<TranslationEntity>(7)

        entitiesList.add(translationEntity0)
        entitiesList.add(translationEntity1)
        entitiesList.add(translationEntity2)
        entitiesList.add(translationEntity3)
        entitiesList.add(translationEntity4)
        entitiesList.add(translationEntity5)
        entitiesList.add(translationEntity6)

        // When
        jiveTranslator.translate(entitiesList)

        // Then
        verify<Jive<*, *, *>>(mockJive).onTranslationComplete(translated)
    }

    private fun verifyTranslation(text: String, translation: String) {
        // Given
        val translationEntity = TranslationEntity.translate(0, text.length, text)
        val entityList = ArrayList<TranslationEntity>(1)
        entityList.add(translationEntity)

        // When
        jiveTranslator.translate(entityList)

        // Then
        verify<Jive<*, *, *>>(mockJive).onTranslationComplete(translation)
    }
}
