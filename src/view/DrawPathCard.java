package view;

import java.awt.Graphics;

import javax.swing.JComponent;

public class DrawPathCard extends JComponent{
	private String type;
	private int xPosition;
	private int yPosition;
	private int indWidth;
	private int indHeight;
	private int firstRectangleX;
	private int firstRectangleY;
	
	public DrawPathCard(String type){
		this.setType(type);
		setSize(1000, 1000);
	}
	public void paint(Graphics g){
		switch(this.getType()){
			case "PLUS":
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth() + (indWidth / 2),
						this.getFirstRectangleY() + ((this.getyPosition() - 1) * this.getIndHeight()),
						(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth()) + (this.getIndWidth()/ 2), 
						this.getFirstRectangleY() + (this.getyPosition()* this.getIndHeight()));				
				g.drawLine(this.getFirstRectangleX() + ((this.getxPosition() - 1) * this.getIndWidth()), 
						this.getFirstRectangleY()+ ((this.getyPosition() - 1) * this.getIndHeight()+ (this.getIndHeight()/2)),
						this.getFirstRectangleX() + (this.getxPosition() * indWidth), 
						this.getFirstRectangleY()+ ((this.getyPosition() - 1) * this.getIndHeight()+ (this.getIndHeight()/2)));
				break;
			case "VLINE":
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth() + (indWidth / 2),
						this.getFirstRectangleY() + ((this.getyPosition() - 1) * this.getIndHeight()),
						(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth()) + (this.getIndWidth()/ 2), 
						this.getFirstRectangleY() + (this.getyPosition()* this.getIndHeight()));
				break;
			case "HLINE":
				g.drawLine(this.getFirstRectangleX() + ((this.getxPosition() - 1) * this.getIndWidth()), 
						this.getFirstRectangleY()+ ((this.getyPosition() - 1) * this.getIndHeight()+ (this.getIndHeight()/2)),
						this.getFirstRectangleX() + (this.getxPosition() * indWidth), 
						this.getFirstRectangleY()+ ((this.getyPosition() - 1) * this.getIndHeight()+ (this.getIndHeight()/2)));
				break;
			case "USEVEN":
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight());
				
				g.drawLine(this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(),
						this.getFirstRectangleY() + this.getIndHeight()/2 + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(),
						this.getFirstRectangleY() + this.getIndHeight() + (this.getyPosition() - 1) * this.getIndHeight());
				break;
			case "UDSEVEN":
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight());
				
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth() + (indWidth / 2),
						this.getFirstRectangleY() + ((this.getyPosition() - 1) * this.getIndHeight()),
						(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth()) + (this.getIndWidth()/ 2), 
						this.getFirstRectangleY() - this.getIndHeight()/2 + (this.getyPosition()* this.getIndHeight()));
				break;
			case "UDRSEVEN":
				g.drawLine(this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight());
				
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth() + (indWidth / 2),
						this.getFirstRectangleY() + ((this.getyPosition() - 1) * this.getIndHeight()),
						(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth()) + (this.getIndWidth()/ 2), 
						this.getFirstRectangleY() - this.getIndHeight()/2 + (this.getyPosition()* this.getIndHeight()));
				break;
			case "UMSEVEN":
				g.drawLine(this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight());
				
				g.drawLine(this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(),
						this.getFirstRectangleY() + this.getIndHeight()/2 + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(),
						this.getFirstRectangleY() + this.getIndHeight() + (this.getyPosition() - 1) * this.getIndHeight());
				break;
			case "UT":
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight());
				
				g.drawLine(this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(),
						this.getFirstRectangleY() + this.getIndHeight()/2 + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(),
						this.getFirstRectangleY() + this.getIndHeight() + (this.getyPosition() - 1) * this.getIndHeight());
				break;
			case "UDT":
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight());
				
				g.drawLine(this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(),
						this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(),
						this.getFirstRectangleY() + this.getIndHeight()/2 + (this.getyPosition() - 1) * this.getIndHeight());
				break;
			case "CRT":
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight());
				
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth() + (indWidth / 2),
						this.getFirstRectangleY() + ((this.getyPosition() - 1) * this.getIndHeight()),
						(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth()) + (this.getIndWidth()/ 2), 
						this.getFirstRectangleY() + (this.getyPosition()* this.getIndHeight()));
				break;
			case "ART":
				g.drawLine(this.getFirstRectangleX() + this.getIndWidth()/2 + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight(),
						this.getFirstRectangleX() + this.getIndWidth() + (this.getxPosition() - 1) * this.getIndWidth(), 
						this.getIndHeight()/2 + this.getFirstRectangleY() + (this.getyPosition() - 1) * this.getIndHeight());
				
				g.drawLine(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth() + (indWidth / 2),
						this.getFirstRectangleY() + ((this.getyPosition() - 1) * this.getIndHeight()),
						(this.getFirstRectangleX() + (this.getxPosition() - 1) * this.getIndWidth()) + (this.getIndWidth()/ 2), 
						this.getFirstRectangleY() + (this.getyPosition() * this.getIndHeight()));
				break;
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
}
