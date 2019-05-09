package co.uk.jiveelection.campaign.injection

import co.uk.jiveelection.campaign.injection.ge2015.CameronModule
import co.uk.jiveelection.campaign.injection.ge2015.CleggModule
import co.uk.jiveelection.campaign.injection.ge2015.MilibandModule
import co.uk.jiveelection.campaign.injection.ge2017.*
import co.uk.jiveelection.campaign.jive.ge2015.CameronJive
import co.uk.jiveelection.campaign.jive.ge2015.CleggJive
import co.uk.jiveelection.campaign.jive.ge2015.MilibandJive
import co.uk.jiveelection.campaign.jive.ge2017.*
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    CameronModule::class,
    MilibandModule::class,
    CleggModule::class,
    MayModule::class,
    CorbynModule::class,
    FarronModule::class,
    SturgeonModule::class,
    WoodModule::class,
    LucasModule::class
])
@Singleton
interface JiveCampaign {

    fun cameron(): CameronJive

    fun miliband(): MilibandJive

    fun clegg(): CleggJive

    fun may(): MayJive

    fun corbyn(): CorbynJive

    fun farron(): FarronJive

    fun sturgeon(): SturgeonJive

    fun wood(): WoodJive

    fun lucas(): LucasJive
}
