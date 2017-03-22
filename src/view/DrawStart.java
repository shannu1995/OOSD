package view;

import java.awt.Graphics;

import javax.swing.JComponent;

public class DrawStart extends JComponent{
	private int indWidth;
	private int indHeight;
	private int xPosition;
	private int yPosition;
	private int rows;
	private int columns;
	private int[] positions;
	
	public DrawStart(int xPosition, int yPosition, int indWidth, int indHeight, int rows, int columns){
		this.setIndWidth(indWidth);
		this.setIndHeight(indHeight);
		this.setxPosition(xPosition);
		this.setyPosition(yPosition);
		this.setRows(rows);
		this.setColumns(columns);
		this.positions = this.getPositions();
		setSize(this.getIndWidth()* this.getColumns(), this.getIndHeight()* this.getRows());
	}
	public int[] getPositions(){
		int x;
		int y;
		if((this.getRows() % 2) == 0 && this.getColumns() == 0){
			x = this.getRows() / 2;
			y = this.getColumns() / 2;
		}
		else if((this.getRows() % 2) == 0 && this.getColumns() != 0){
			x = this.getRows() / 2;
			y = (this.getColumns() / 2) - 1 ;
		}
		else if((this.getRows() % 2) != 0 && this.getColumns() == 0){
			x = (this.getRows() / 2) - 1;
			y = this.getColumns() / 2;
		}
		else{
			x = (this.getRows() / 2) - 1;
			y = (this.getColumns() / 2) - 1;
		}
		int[] array = new int[2];
		array[0] = x;
		array[1] = y;
		return array;
	}
	public void paint(Graphics g){
		int[] array = this.positions;
		System.out.println("This is being executed");
		g.drawLine((xPosition + (array[0] * indWidth) + (indWidth/2)), yPosition + (array[1] * indHeight), 
				(xPosition + (array[0] * indWidth) + (indWidth/2)), yPosition + ((array[1] - 1) * indHeight));
		g.drawLine(xPosition + (array[0] * indWidth), yPosition + ((array[1] - 1) * indHeight) + (indHeight/2), xPosition + ((array[0] + 1) * indWidth) , 
				yPosition + ((array[1] - 1) * indHeight) + (indHeight/2));
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
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}

}
