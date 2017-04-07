package view;

import java.awt.Graphics;

import javax.swing.JComponent;

import models.ActionCard;

public class DrawActionCard extends JComponent{
	
	private ActionCard card;
	public DrawActionCard(ActionCard card){
		this.setCard(card);
		setSize(1000, 1000);
	}
	public void paint(Graphics g){
		g.drawString(this.getCard().getType(), (this.getCard().getFirstRectangleX()) + ((this.getCard().getxPosition() - 1)*this.getCard().getIndWidth()),
				(this.getCard().getFirstRectangleY()) + (this.getCard().getyPosition()*this.getCard().getIndHeight()));
	}
	public ActionCard getCard() {
		return card;
	}
	public void setCard(ActionCard card) {
		this.card = card;
	}
}
