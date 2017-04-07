package models;

public abstract class Card {
	private int xPosition;
	private int yPosition;
	private String type;
	private int firstRectangleX;
	private int firstRectangleY;
	private int indWidth;
	private int indHeight;
	
	public Card(String type){
		this.setType(type);
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

	public int getFirstRectangleX() {
		return firstRectangleX;
	}

	public void setFirstRectangleX(int firstRectangleX) {
		this.firstRectangleX = firstRectangleX;
	}

	public int getFirstRectangleY() {
		return firstRectangleY;
	}

	public void setFirstRectangleY(int firstRectangleY) {
		this.firstRectangleY = firstRectangleY;
	}

	public int getIndWidth() {
		return indWidth;
	}

	public void setIndWidth(int indWidth) {
		this.indWidth = indWidth;
	}

	public int getIndHeight() {
		return indHeight;
	}

	public void setIndHeight(int indHeight) {
		this.indHeight = indHeight;
	}
}
