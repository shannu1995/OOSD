package controllers;

public class GetTreasurePositions{
	private int rows;
	private int columns;
	
	public GetTreasurePositions(int rows, int columns){
		this.setRows(rows);
		this.setColumns(columns);
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
	public int[] selectTreasureSpots(){
		int[] array = new int[2];
		/*MODIFY THIS CODE SO THAT IT DOES NOT PRINT OUT OF BOUNDS*/
		array[0] = 1 + (int)(Math.random() * ((this.getRows() - 1) + 1));
		array[1] = 1 + (int)(Math.random() * ((this.getColumns() - 1) + 1));
		return array;
	}
}