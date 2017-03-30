package view;

import java.awt.Graphics;

import javax.swing.JComponent;

public class DrawPathCard extends JComponent{
	private String type;
	private int xPosition;
	private int yPosition;
	
	public DrawPathCard(String type){
		this.setType(type);
	}
	public void paint(Graphics g){
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
