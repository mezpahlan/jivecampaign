package co.uk.jiveelection.campaign.twit;

public class EntitiesModel implements Comparable<EntitiesModel> {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public EntitiesModel(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(EntitiesModel o) {
        return this.getStart() - o.getStart();
    }

}
