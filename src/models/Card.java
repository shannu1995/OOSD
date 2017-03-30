package models;

public abstract class Card {
	private int xPosition;
	private int yPosition;
	private String type;
	
	public Card(int xPosition, int yPosition, String type){
		this.setxPosition(xPosition);
		this.setyPosition(yPosition);
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
