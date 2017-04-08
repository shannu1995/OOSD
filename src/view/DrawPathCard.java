package view;

import java.awt.Graphics;

import javax.swing.JComponent;

import models.ActionCard;
import models.PathCard;

public class DrawPathCard extends JComponent{
	private boolean selection;
	private PathCard card;
	
	public DrawPathCard(PathCard pathCard, boolean selection){
		this.setCard(pathCard);
		this.setSelection(selection);
		setSize(1000, 1000);
	}
	public void paint(Graphics g){
		System.out.println("Why isn\'t the type: "+this.getCard().getType()+" printing?");
		if(selection == true){
				switch(this.getCard().getType()){
				case "PLUS":
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth() + (this.getCard().getIndWidth() / 2),
							this.getCard().getFirstRectangleY() + ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()),
							(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth()) + (this.getCard().getIndWidth()/ 2), 
							this.getCard().getFirstRectangleY() + (this.getCard().getyPosition()* this.getCard().getIndHeight()));				
					g.drawLine(this.getCard().getFirstRectangleX() + ((this.getCard().getxPosition() - 1) * this.getCard().getIndWidth()), 
							this.getCard().getFirstRectangleY()+ ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()+ (this.getCard().getIndHeight()/2)),
							this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() * this.getCard().getIndWidth()), 
							this.getCard().getFirstRectangleY()+ ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()+ (this.getCard().getIndHeight()/2)));
					break;
				case "VLINE":
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth() + (this.getCard().getIndWidth() / 2),
							this.getCard().getFirstRectangleY() + ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()),
							(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth()) + (this.getCard().getIndWidth()/ 2), 
							this.getCard().getFirstRectangleY() + (this.getCard().getyPosition()* this.getCard().getIndHeight()));
					break;
				case "HLINE":
					g.drawLine(this.getCard().getFirstRectangleX() + ((this.getCard().getxPosition() - 1) * this.getCard().getIndWidth()), 
							this.getCard().getFirstRectangleY()+ ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()+ (this.getCard().getIndHeight()/2)),
							this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() * this.getCard().getIndWidth()), 
							this.getCard().getFirstRectangleY()+ ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()+ (this.getCard().getIndHeight()/2)));
					break;
				case "USEVEN":
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					
					g.drawLine(this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(),
							this.getCard().getFirstRectangleY() + this.getCard().getIndHeight()/2 + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(),
							this.getCard().getFirstRectangleY() + this.getCard().getIndHeight() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					break;
				case "UDSEVEN":
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth() + (this.getCard().getIndWidth() / 2),
							this.getCard().getFirstRectangleY() + ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()),
							(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth()) + (this.getCard().getIndWidth()/ 2), 
							this.getCard().getFirstRectangleY() - this.getCard().getIndHeight()/2 + (this.getCard().getyPosition()* this.getCard().getIndHeight()));
					break;
				case "UDRSEVEN":
					g.drawLine(this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth() + (this.getCard().getIndWidth() / 2),
							this.getCard().getFirstRectangleY() + ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()),
							(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth()) + (this.getCard().getIndWidth()/ 2), 
							this.getCard().getFirstRectangleY() - this.getCard().getIndHeight()/2 + (this.getCard().getyPosition()* this.getCard().getIndHeight()));
					break;
				case "UMSEVEN":
					g.drawLine(this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					
					g.drawLine(this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(),
							this.getCard().getFirstRectangleY() + this.getCard().getIndHeight()/2 + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(),
							this.getCard().getFirstRectangleY() + this.getCard().getIndHeight() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					break;
				case "UT":
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					
					g.drawLine(this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(),
							this.getCard().getFirstRectangleY() + this.getCard().getIndHeight()/2 + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(),
							this.getCard().getFirstRectangleY() + this.getCard().getIndHeight() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					break;
				case "UDT":
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					
					g.drawLine(this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(),
							this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(),
							this.getCard().getFirstRectangleY() + this.getCard().getIndHeight()/2 + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					break;
				case "CRT":
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth() + (this.getCard().getIndWidth()/ 2),
							this.getCard().getFirstRectangleY() + ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()),
							(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth()) + (this.getCard().getIndWidth()/ 2), 
							this.getCard().getFirstRectangleY() + (this.getCard().getyPosition()* this.getCard().getIndHeight()));
					break;
				case "ART":
					g.drawLine(this.getCard().getFirstRectangleX() + this.getCard().getIndWidth()/2 + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight(),
							this.getCard().getFirstRectangleX() + this.getCard().getIndWidth() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth(), 
							this.getCard().getIndHeight()/2 + this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() - 1) * this.getCard().getIndHeight());
					
					g.drawLine(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth() + (this.getCard().getIndWidth() / 2),
							this.getCard().getFirstRectangleY() + ((this.getCard().getyPosition() - 1) * this.getCard().getIndHeight()),
							(this.getCard().getFirstRectangleX() + (this.getCard().getxPosition() - 1) * this.getCard().getIndWidth()) + (this.getCard().getIndWidth()/ 2), 
							this.getCard().getFirstRectangleY() + (this.getCard().getyPosition() * this.getCard().getIndHeight()));
					break;
			}
		}
		else{
			System.out.println("This should print!");
		}
	}
	public boolean isSelection() {
		return selection;
	}
	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	public PathCard getCard() {
		return card;
	}
	public void setCard(PathCard card) {
		this.card = card;
	}
}
