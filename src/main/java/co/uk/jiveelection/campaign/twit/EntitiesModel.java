package co.uk.jiveelection.campaign.twit;

public class EntitiesModel implements Comparable<EntitiesModel>{
	private int start;
	private int end;
	private String text;
	private String type;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public EntitiesModel(int start, int end, String text, String type) {
		this.start = start;
		this.end = end;
		this.text = text;
		this.type = type;
	}
	
	@Override
	public int compareTo(EntitiesModel o) {
		return this.getStart() - o.getStart();
	}

}
