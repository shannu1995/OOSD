package view;

import javax.swing.JComponent;

import models.ActionCard;

public class DrawActionCard extends JComponent{
	
	private ActionCard card;
	
	public DrawActionCard(ActionCard card){
		this.setCard(card);
		setSize(1000, 1000);
	}
	public ActionCard getCard() {
		return card;
	}
	public void setCard(ActionCard card) {
		this.card = card;
	}
}
