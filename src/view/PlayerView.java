package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class PlayerView extends JComponent{
	
	private int boardHeight;
	private int indWidth;
	private int indHeight;
	private String type;
	
	public PlayerView(int boardHeight, int indWidth, int indHeight){
		this.setBoardHeight(boardHeight);
		this.setIndWidth(indWidth);
		this.setIndHeight(indHeight);
		setSize(1000, 1000);
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public void setBoardHeight(int boardHeight) {
		this.boardHeight = boardHeight;
	}
	public void paint(Graphics g){
		
		System.out.println("I have no idea!");
		int random = 1 + (int)(Math.random() * ((4 - 1) + 1));
		g.drawLine(100, 100 + (this.getBoardHeight()/2) + (this.getIndHeight()/2), 100, (this.getBoardHeight()/2) + (3 * this.getIndHeight()/2));
		g.drawLine(100 - this.getIndWidth()/2, 100 + this.getBoardHeight()/2, 100 + this.getIndWidth()/2,  100 + this.getBoardHeight()/2);
		switch(random){
			case 1:
				System.out.println("Building a plus");
				this.setType("PLUS");
//				g.drawLine(100, 100 + (this.getBoardHeight()/2) + (this.getIndHeight()/2), 100, (this.getBoardHeight()/2) + (3 * this.getIndHeight()/2));
//				g.drawLine(100 - this.getIndWidth()/2, 100 + this.getBoardHeight()/2, 100 + this.getIndWidth()/2,  100 + this.getBoardHeight()/2);
				break;
			case 2:
				this.setType("LINE");
				System.out.println("Building a line");
				g.drawLine(100, 100 + (this.getBoardHeight()/2) + (this.getIndHeight()/2), 100, (this.getBoardHeight()/2) + (3 * this.getIndHeight()/2));
				break;
			case 3:
				this.setType("SEVEN");
				System.out.println("Building a seven");
				break;
			case 4:
				this.setType("T");
				System.out.println("Building a t");
				break;
			default:
				System.out.println("Should not see this");
				break;
		}
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}