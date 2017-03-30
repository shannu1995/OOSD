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
	private int[][] treasureArray;
	private int[] startSpot;
			
	public Board(BoardLayer layer, int[][] treasureArray){
	
		this.setLayer(layer);
		SelectSquare select = (((DrawRectangle) this.getLayer().getBoard()).getSelector());
		select.addObserver(this);
		this.setRows(((DrawRectangle) this.getLayer().getBoard()).getRows());
		this.setColumns(((DrawRectangle) this.getLayer().getBoard()).getColumns());
		
		String[][] board = new String[this.getRows() + 1][this.getColumns() + 1];
		this.setTreasureArray(treasureArray);	
		this.setBoard(board);
	}

	@Override
	public void update(Observable o, Object arg1) {
		this.setBeingSelected(true);
		//2,12
		//3,12
		if(o == ((DrawRectangle) this.getLayer().getBoard()).getSelector()){
			this.setClickXCoordinate(((((DrawRectangle) this.getLayer().getBoard()).getSelector()).getEvent().getX() - 5)
					/ ((DrawRectangle) this.getLayer().getBoard()).getIndWidth() + 1);
			this.setClickYCoordinate(((((DrawRectangle) this.getLayer().getBoard()).getSelector()).getEvent().getY() - 5)
					/ ((DrawRectangle) this.getLayer().getBoard()).getIndWidth() + 1);
			System.out.println(clickXCoordinate +" , "+ clickYCoordinate);
			if(this.getClickYCoordinate() > this.getRows()){
				if(this.getClickXCoordinate() == 2 || this.getClickXCoordinate() == 3){
					System.out.println("You selected a PLUS!");
					System.out.println("Now select an empty slot");
				}
			}
		}
		
	}
	public void updateBoard(String[][] board){
		
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
	for(int i = 0; i < this.getRows(); i ++){
		for(int j = 0; j < this.getColumns(); j++){
			board[i][j] = "EMPTY";
		}
	}
	for(int i = 0; i < this.getTreasureArray().length; i++)
	{
		int x = this.getTreasureArray()[i][0];
		int y = this.getTreasureArray()[i][1];
		System.out.print( x + ", ");
		System.out.println(y);
		board[y - 1][x - 1] = "SPOT";
	}
	this.setStartSpot(((DrawStart) this.getLayer().getStart()).getPositions());
	int[] array = this.getStartSpot();
	board[array[1]][array[0] - 1] = "PLUS";
	System.out.println(this.getColumns());
	System.out.println(this.getRows());
	
		for(int i = 0; i < this.getColumns(); i++){
			for(int j = 0; j < this.getRows(); j++){
					System.out.print(board[i][j]+" , ");
				}
				System.out.println();
			}
			this.board = board;
	}

	public int[][] getTreasureArray() {
		return treasureArray;
	}

	public void setTreasureArray(int[][] treasureArray) {
		this.treasureArray = treasureArray;
	}

	public int[] getStartSpot() {
		return startSpot;
	}

	public void setStartSpot(int[] startSpot) {
		this.startSpot = startSpot;
	}
	
}
