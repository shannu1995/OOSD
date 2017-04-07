package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class PlayerView extends JComponent{
	
	private int boardHeight;
	private int boardWidth;
	private int indWidth;
	private int indHeight;
	private String type;
	private int player;
	
	public PlayerView(int boardWidth, int boardHeight, int indWidth, int indHeight){
		this.setBoardHeight(boardHeight);
		this.setIndWidth(indWidth);
		this.setIndHeight(indHeight);
		this.setBoardWidth(boardWidth);
		setSize(this.boardWidth * 2, this.boardHeight * 2);
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public void setBoardHeight(int boardHeight) {
		this.boardHeight = boardHeight;
	}
	public void paint(Graphics g){
		int random = 1 + (int)(Math.random() * ((10 - 1) + 1));
		g.drawString("Player "+this.getPlayer()+"\'s turn", this.getBoardWidth()/2 + 100, 10);
		switch(random){
			case 1:
				System.out.println("Building a plus");
				this.setType("PLUS");
				g.drawLine(100 + (this.getBoardWidth()/2),  (this.getIndHeight()/2), 100 + (this.getBoardWidth()/2), (3 * this.getIndHeight()/2));
				g.drawLine(100 + this.getBoardWidth()/2 - this.getIndWidth()/2, this.getIndHeight(), 100 + this.getBoardWidth()/2 + this.getIndWidth()/2, this.getIndHeight());
				break;
			case 2:
				this.setType("LINE");
				System.out.println("Building a line");
				
				g.drawLine(100 + (this.getBoardWidth()/2), 100 + (this.getIndHeight()/2), 100 + (this.getBoardWidth()/2), 100 + (3 * this.getIndHeight()/2));
				g.drawLine(150 + (this.getBoardWidth()/2), 150, 150 + (this.getBoardWidth()/2) + this.getIndWidth(), 150);
				break;
			case 3:
				this.setType("SEVEN");
				System.out.println("Building a seven");
				g.drawLine(100 + (this.getBoardWidth()/2), 200 + (this.getIndHeight()/2), 100 + (this.getBoardWidth()/2), 200 + (this.getIndHeight()));
				g.drawLine(100 + this.getBoardWidth()/2 - this.getIndWidth()/2, 200 + this.getIndHeight()/2, 100 + this.getBoardWidth()/2, 200 + this.getIndHeight()/2);
		
				g.drawLine(150 + (this.getBoardWidth()/2), 200 + (this.getIndHeight()/2), 150 + (this.getBoardWidth()/2), 200 + (this.getIndHeight()));
				g.drawLine(150 + this.getBoardWidth()/2 - this.getIndWidth()/2, 200 + this.getIndHeight(), 150 + this.getBoardWidth()/2, 200 + this.getIndHeight());
		
				g.drawLine(200 + (this.getBoardWidth()/2), 200 + (this.getIndHeight()/2), 200 + (this.getBoardWidth()/2), 200 + (this.getIndHeight()));
				g.drawLine(200 + this.getBoardWidth()/2, 200 + this.getIndHeight(), 200 + this.getBoardWidth()/2 + this.getIndWidth()/2, 200 + this.getIndHeight());
		
				g.drawLine(300 + (this.getBoardWidth()/2), 200 + (this.getIndHeight()/2), 300 + (this.getBoardWidth()/2), 200 + (this.getIndHeight()));
				g.drawLine(300 + this.getBoardWidth()/2 + this.getIndWidth()/2, 200 + this.getIndHeight()/2, 300 + this.getBoardWidth()/2, 200 + this.getIndHeight()/2);
				break;
			case 4:
				this.setType("T");
				System.out.println("Building a t");						
								
			g.drawLine(100 + (this.getBoardWidth()/2), 300 + (this.getIndHeight()/2), 100 + (this.getBoardWidth()/2), 300 + (this.getIndHeight()));
			g.drawLine(100 + this.getBoardWidth()/2 - this.getIndWidth()/2, 300 + this.getIndHeight()/2, 100 + this.getBoardWidth()/2 + this.getIndWidth()/2,
			 300	+ this.getIndHeight()/2);
			
			g.drawLine(200 + (this.getBoardWidth()/2), 300 + (this.getIndHeight()/2), 200 + (this.getBoardWidth()/2), 300 + (this.getIndHeight()));
			g.drawLine(200 + this.getBoardWidth()/2 - this.getIndWidth()/2, 300 + this.getIndHeight(), 200 + this.getBoardWidth()/2 + this.getIndWidth()/2, 
			300 + this.getIndHeight());
			
			g.drawLine(300 + (this.getBoardWidth()/2), 300 , 300 + (this.getBoardWidth()/2), 300 + (this.getIndHeight()));
			g.drawLine(300 + this.getBoardWidth()/2 - this.getIndWidth()/2, 300 + this.getIndHeight()/2, 300 + this.getBoardWidth()/2,
			300 + this.getIndHeight()/2);
			
			g.drawLine(400 + (this.getBoardWidth()/2) - this.getIndWidth()/2, 300 , 400 + (this.getBoardWidth()/2) - this.getIndWidth()/2, 300 + (this.getIndHeight()));
			g.drawLine(400 + this.getBoardWidth()/2 - this.getIndWidth()/2, 300 + this.getIndHeight()/2, 400 + this.getBoardWidth()/2,
			300 + this.getIndHeight()/2);
				break;
			case 5:
				g.drawString("BOMB", 100 + this.getBoardWidth()/2, 350 + this.getIndHeight()/2);
				break;
			case 6:
				g.drawString("DEFUSE BOMB", 100 + this.getBoardWidth()/2, 400 + this.getIndHeight()/2);
				break;
			case 7:
				g.drawString("SPILL", 100 + this.getBoardWidth()/2, 450 + this.getIndHeight()/2);
				break;
			case 8:
				g.drawString("CLEAN SPILL", 100 + this.getBoardWidth()/2, 500 + this.getIndHeight()/2);
				break;
			case 9:
				g.drawString("REMOVE PATH", 100 + this.getBoardWidth()/2, 550 + this.getIndHeight()/2);
				break;
			case 10:
				g.drawString("ROTATE PATH", 100 + this.getBoardWidth()/2, 600 + this.getIndHeight()/2);
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

	public int getBoardWidth() {
		return boardWidth;
	}

	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}
}