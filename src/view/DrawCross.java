package view;

import java.awt.Graphics;

import javax.swing.JComponent;

public class DrawCross extends JComponent{
	private int totalWidth;
	private int totalHeight;
	private int xPosition;
	private int yPosition;
	private int widthOfRect;
	private int heightOfRect;
	private int firstRectangleX;
	private int firstRectangleY;
	private int[][] positionsArray;
	private int spots;
	
	public DrawCross(int totalWidth, int totalHeight,
			int widthOfRect, int heightOfRect, int firstRectangleX, int firstRectangleY, int[][] positionsArray, int spots){
		this.setTotalHeight(totalHeight);
		this.setTotalWidth(totalWidth);
		this.setxPosition(xPosition);
		this.setyPosition(yPosition);
		this.setWidthOfRect(widthOfRect);
		this.setHeightOfRect(heightOfRect);
		this.setFirstRectangleX(firstRectangleX);
		this.setFirstRectangleY(firstRectangleY);
		this.setPositionsArray(positionsArray);
		this.setSpots(spots);
		setSize(totalWidth, totalHeight);
	}
	public void paint(Graphics g){
		for(int i = 0; i < this.getSpots(); i++){
			for(int j = 0; j < 1; j++){
				g.drawLine(firstRectangleX + widthOfRect*(positionsArray[i][j] - 1), firstRectangleY + heightOfRect*(positionsArray[i][j + 1] - 1), 
						widthOfRect + firstRectangleX + widthOfRect*(positionsArray[i][j] - 1),
						heightOfRect + firstRectangleY + heightOfRect*(positionsArray[i][j + 1]-1));
				
				g.drawLine(widthOfRect + firstRectangleX + widthOfRect*(positionsArray[i][j] - 1), firstRectangleY + heightOfRect*(positionsArray[i][j + 1]-1), 
						firstRectangleX + widthOfRect*(positionsArray[i][j] - 1),
						heightOfRect + firstRectangleY + heightOfRect*(positionsArray[i][j + 1]-1));
			}
		}
	}
	public int getTotalWidth() {
		return totalWidth;
	}
	public void setTotalWidth(int totalWidth) {
		this.totalWidth = totalWidth;
	}
	public int getTotalHeight() {
		return totalHeight;
	}
	public void setTotalHeight(int totalHeight) {
		this.totalHeight = totalHeight;
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
	public int getWidthOfRect() {
		return widthOfRect;
	}
	public void setWidthOfRect(int widthOfRect) {
		this.widthOfRect = widthOfRect;
	}
	public int getHeightOfRect() {
		return heightOfRect;
	}
	public void setHeightOfRect(int heightOfRect) {
		this.heightOfRect = heightOfRect;
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
	public int[][] getPositionsArray() {
		return positionsArray;
	}
	public void setPositionsArray(int[][] positionsArray) {
		this.positionsArray = positionsArray;
	}
	public int getSpots() {
		return spots;
	}
	public void setSpots(int spots) {
		this.spots = spots;
	}
}
