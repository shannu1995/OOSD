package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectSquare implements MouseListener{
	private int xPosition;
	private int yPosition;
	private int indWidth;
	private int indHeight;
	private int rows; 
	private int columns;
	private int totalWidth;
	private int totalHeight;
	private SaveCoordinates save;
	
	public SelectSquare(int getxPosition, int getyPosition, int indWidth, int indHeight, int rows, int columns,
			int totalWidth, int totalHeight) {
		this.setTotalHeight(totalHeight);
		this.setTotalWidth(totalWidth);
		this.setxPosition(xPosition);
		this.setyPosition(yPosition);
		this.setRows(rows);
		this.setColumns(columns);
		setIndWidth(indWidth);
		setIndHeight(indHeight);
	}
	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
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

	@Override
	public void mouseClicked(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		System.out.println("X co-ordinate of click is "+x+" and Y co-oridante of click is "+y);
		this.setSave(new SaveCoordinates(x, y));
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public SaveCoordinates getSave() {
		return save;
	}
	public void setSave(SaveCoordinates save) {
		this.save = save;
	}
}
