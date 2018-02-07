package co.uk.jiveelection.campaign.output;

/**
 * Outputs translated Jive strings.
 */
public interface Output<O> {
    void outputJive(String jive);

    void onOutputComplete(O status);
}
