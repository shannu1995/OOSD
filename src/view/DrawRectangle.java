package view;

import java.awt.Event;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import controllers.SelectSquare;

public class DrawRectangle extends JComponent implements Observer{
	
	private int xPosition;
	private int yPosition;
	private int indWidth;
	private int indHeight;
	private int rows; 
	private int columns;
	private int totalWidth;
	private int totalHeight;
	private SelectSquare selector;
	
	private int clickXCoordinate;
	private int clickYCoordinate;
	private boolean beingSelected;
	
	public DrawRectangle(int xPosition, int yPosition, int width, int height, int rows,
			int columns, int totalWidth, int totalHeight){
		
		this.setTotalHeight(totalHeight);
		this.setTotalWidth(totalWidth);
		setSize(totalWidth, totalHeight);
		this.setxPosition(xPosition);
		this.setyPosition(yPosition);
		this.setRows(rows);
		this.setColumns(columns);
		setIndWidth(width);
		setIndHeight(height);
		addActionListener();
	}
	public void addActionListener(){
		SelectSquare selector = new SelectSquare(getxPosition(), getyPosition(), getIndWidth(),
				getIndHeight(), getRows(), getColumns(), getTotalWidth(), getTotalHeight());
		setSelector(selector);
		addMouseListener(selector);
		selector.addObserver(this);
	}
	public Event dispatchEvent(Event e){
		return e;
	}
	public void paint(Graphics g){
		System.out.println("Being painted");
		for(int j = 0; j < columns; j++){
			for(int i = 0; i < rows; i++){
				g.drawRect(xPosition + indWidth*i, yPosition + indHeight*j, indWidth, indHeight);
			}
		}	
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
	public SelectSquare getSelector() {
		return selector;
	}
	public void setSelector(SelectSquare selector) {
		this.selector = selector;
	}
	@Override
	public void update(Observable o, Object arg) {
		this.setBeingSelected(true);
		System.out.println("LOL Clicked!");
		if(o == this.getSelector()){
			this.setClickXCoordinate(((this.getSelector().getEvent().getX() - 5) / this.indWidth) + 1);
			this.setClickYCoordinate(((this.getSelector().getEvent().getY() - 5) / this.indHeight) + 1);
			System.out.println(clickXCoordinate +" , "+ clickYCoordinate);
		}
	}
	public int getClickXCoordinate() {
		return clickXCoordinate;
	}
	public void setClickXCoordinate(int clickXCoordinate) {
		this.clickXCoordinate = clickXCoordinate;
	}
	public int getClickYCoordinate() {
		return clickYCoordinate;
	}
	public void setClickYCoordinate(int clickYCoordinate) {
		this.clickYCoordinate = clickYCoordinate;
	}
	public boolean isBeingSelected() {
		return beingSelected;
	}
	public void setBeingSelected(boolean beingSelected) {
		this.beingSelected = beingSelected;
	}
}
