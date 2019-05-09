package co.uk.jiveelection.campaign.output

/**
 * Outputs translated Jive strings.
 */
interface Output<in O> {
    fun outputJive(jive: String)

    fun onOutputComplete(status: O)
}
