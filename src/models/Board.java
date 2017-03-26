package models;


import java.util.Observable;
import java.util.Observer;

import view.*;
import controllers.SelectSquare;

public class Board implements Observer{
	private BoardLayer layer;
	private int rows;
	private int columns;
	
	private int clickXCoordinate;
	private int clickYCoordinate;
	private boolean beingSelected;
	private String[][] board;
	
	public Board(BoardLayer layer){
		this.setLayer(layer);
		
		SelectSquare select = (((DrawRectangle) this.getLayer().getBoard()).getSelector());
		select.addObserver(this);
		this.setRows(this.getLayer().getHeight());
		this.setColumns(this.getLayer().getWidth());
		String[][] board = new String[this.getRows()][this.getColumns()];
		for(int i = 0; i < this.getRows(); i ++){
			for(int j = 0; j < this.getColumns(); j++){
				board[i][j] = "EMPTY";
			}
		}
		this.setBoard(board);
	}

	@Override
	public void update(Observable o, Object arg1) {
		this.setBeingSelected(true);
		if(o == ((DrawRectangle) this.getLayer().getBoard()).getSelector()){
			this.setClickXCoordinate(((((DrawRectangle) this.getLayer().getBoard()).getSelector()).getEvent().getX() - 5)
					/ ((DrawRectangle) this.getLayer().getBoard()).getIndWidth() + 1);
			this.setClickYCoordinate(((((DrawRectangle) this.getLayer().getBoard()).getSelector()).getEvent().getY() - 5)
					/ ((DrawRectangle) this.getLayer().getBoard()).getIndWidth() + 1);
			System.out.println(clickXCoordinate +" , "+ clickYCoordinate);	
		}
		
	}
	public BoardLayer getLayer() {
		return layer;
	}
	public void setLayer(BoardLayer layer) {
		this.layer = layer;
	}
	public boolean isBeingSelected() {
		return beingSelected;
	}
	public void setBeingSelected(boolean beingSelected) {
		this.beingSelected = beingSelected;
	}
	public int getClickYCoordinate() {
		return clickYCoordinate;
	}
	public void setClickYCoordinate(int clickYCoordinate) {
		this.clickYCoordinate = clickYCoordinate;
	}
	public int getClickXCoordinate() {
		return clickXCoordinate;
	}
	public void setClickXCoordinate(int clickXCoordinate) {
		this.clickXCoordinate = clickXCoordinate;
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
	public String[][] getBoard() {
		return board;
	}
	public void setBoard(String[][] board) {
		this.board = board;
	}
	
}
