package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class PlayerView extends JComponent{
	
	private int boardHeight;
	private int indWidth;
	private int indHeight;
	private String type;
	private int player;
	
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
		int random = 1 + (int)(Math.random() * ((4 - 1) + 1));
		g.drawString("Player No. "+this.getPlayer(), 0, this.getBoardHeight()/2 + 100);
		switch(random){
			case 1:
				System.out.println("Building a plus");
				this.setType("PLUS");
				g.drawLine(100, 100 + (this.getBoardHeight()/2) + (this.getIndHeight()/2), 100, (this.getBoardHeight()/2) + (3 * this.getIndHeight()/2));
				g.drawLine(100 - this.getIndWidth()/2, 100 + this.getBoardHeight()/2, 100 + this.getIndWidth()/2,  100 + this.getBoardHeight()/2);
				break;
			case 2:
				this.setType("LINE");
				System.out.println("Building a line");
				g.drawLine(100, 200 + (this.getBoardHeight()/2) + (this.getIndHeight()/2), 100, 100 + (this.getBoardHeight()/2) + (3 * this.getIndHeight()/2));
				g.drawLine(150 - this.getIndWidth()/2, 200 + this.getBoardHeight()/2, 150 + this.getIndWidth()/2, 200 + this.getBoardHeight()/2);
				break;
			case 3:
				this.setType("SEVEN");
				System.out.println("Building a seven");
				g.drawLine(100 - this.getIndWidth()/2, 300 + this.getBoardHeight()/2, 100, 300 + this.getBoardHeight()/2);
				g.drawLine(100, 300 + this.getBoardHeight()/2, 100, 300 + this.getBoardHeight()/2 + this.getIndHeight()/2);
				
				g.drawLine(150 + this.getIndWidth()/2, 300 + this.getBoardHeight()/2, 150 + this.getIndWidth()/2, 
						300 + this.getBoardHeight()/2 + this.getIndHeight()/2);
				g.drawLine(150 + this.getIndWidth()/2, 300 + this.getBoardHeight()/2 + this.getIndHeight()/2, 150,
						300 + this.getBoardHeight()/2 + this.getIndHeight()/2);
				
				g.drawLine(200 + this.getIndWidth()/2, 300 + this.getBoardHeight()/2, 200 + this.getIndWidth()/2, 
						300 + this.getBoardHeight()/2 + this.getIndHeight()/2);
				g.drawLine(200 + this.getIndWidth()/2, 300 + this.getBoardHeight()/2 + this.getIndHeight()/2, 200 + this.getIndWidth(),
						300 + this.getBoardHeight()/2 + this.getIndHeight()/2);
				
				g.drawLine(250 + this.getIndWidth()/2, 300 + this.getBoardHeight()/2, 250 + this.getIndWidth()/2, 
						300 + this.getBoardHeight()/2 + this.getIndHeight()/2);
				g.drawLine(250 + this.getIndWidth()/2, 300 + this.getBoardHeight()/2, 250 + this.getIndWidth(), 
						300 + this.getBoardHeight()/2);
				break;
			case 4:
				this.setType("T");
				System.out.println("Building a t");
				g.drawLine(100 - this.getIndWidth()/2, 400 + this.getBoardHeight()/2 + this.getIndHeight()/2, 100 - this.getIndWidth()/2,
						400 + this.getBoardHeight()/2 + this.getIndHeight());
				g.drawLine(100 - this.getIndWidth(), 400 + this.getBoardHeight()/2 + this.getIndHeight()/2, 100,
						400 + this.getBoardHeight()/2 + this.getIndHeight()/2);
				
				g.drawLine(200 - this.getIndWidth()/2, 400 + this.getBoardHeight()/2 + this.getIndHeight()/2, 200 - this.getIndWidth()/2,
						400 + this.getBoardHeight()/2 + this.getIndHeight());
				g.drawLine(200 - this.getIndWidth(), 400 + this.getBoardHeight()/2 + this.getIndHeight(), 200,
						400 + this.getBoardHeight()/2 + this.getIndHeight());
						
				g.drawLine(300 - this.getIndWidth(), 400 + this.getBoardHeight()/2 + this.getIndHeight()/2, 300 - this.getIndWidth()/2,
						400 + this.getBoardHeight()/2 + this.getIndHeight()/2);
				g.drawLine(300 - this.getIndWidth()/2, 400 + this.getBoardHeight()/2, 300 - this.getIndWidth()/2,
						400 + this.getBoardHeight()/2 + this.getIndHeight());
						
				g.drawLine(400 - this.getIndWidth(), 400 + this.getBoardHeight()/2 + this.getIndHeight()/2, 400 - this.getIndWidth()/2,
						400 + this.getBoardHeight()/2 + this.getIndHeight()/2);
				g.drawLine(400 - this.getIndWidth(), 400 + this.getBoardHeight()/2, 400 - this.getIndWidth(),
						400 + this.getBoardHeight()/2 + this.getIndHeight());
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

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}
}