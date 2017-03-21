package models;

public class PathCard extends Card {
	private int startXPosition;
	private int startYPosition;
	public PathCard(int startXPosition, int startYPosition, int xPosition, int yPosition){
		super(xPosition, yPosition);
		this.setStartXPosition(startXPosition);
		this.setStartYPosition(startYPosition);
	}
	public int getStartXPosition() {
		return startXPosition;
	}
	public void setStartXPosition(int startXPosition) {
		this.startXPosition = startXPosition;
	}
	public int getStartYPosition() {
		return startYPosition;
	}
	public void setStartYPosition(int startYPosition) {
		this.startYPosition = startYPosition;
	}
}
