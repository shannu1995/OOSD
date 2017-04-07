package models;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import controllers.SelectSquare;
import view.BoardLayer;
import view.DrawPathCard;
import view.DrawRectangle;
import view.DrawStart;
import view.PlayerView;
import view.PositionSelection;

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
	private PositionSelection positions;
	private ArrayList<DrawPathCard> pathCards;
	private DrawPathCard card;
	private int playerCount;
			
	public Board(BoardLayer layer, int[][] treasureArray, int playerCount){
	
		this.setLayer(layer);
		SelectSquare select = (((DrawRectangle) this.getLayer().getBoard()).getSelector());
		select.addObserver(this);
		this.setRows(((DrawRectangle) this.getLayer().getBoard()).getRows());
		this.setColumns(((DrawRectangle) this.getLayer().getBoard()).getColumns());
		this.setPlayerCount(playerCount);
		ArrayList<DrawPathCard> cardsList = new ArrayList<DrawPathCard>();
		this.setPathCards(cardsList);
		((PlayerView) this.getLayer().getPlayer()).setPlayer(1);
		String[][] board = new String[this.getRows() + 1][this.getColumns() + 1];
		this.setTreasureArray(treasureArray);	
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
				
				if(this.getClickXCoordinate() > this.getColumns()){
					if(this.getClickYCoordinate() <= 2){
						System.out.println("You selected a PLUS!");
						card = new DrawPathCard("PLUS", true);
					}
					else if(this.getClickYCoordinate() <= 4){
						System.out.println("You selected a LINE!");
						if(this.getClickXCoordinate() == this.getRows() + 2){
							System.out.println(" and it is vertical");
							card = new DrawPathCard("VLINE", true);
						}
						else{
							System.out.println(" and it is horizontal");
							card = new DrawPathCard("HLINE", true);
						}
					}
					else if(this.getClickYCoordinate() <= 5){
						System.out.println("You selected a SEVEN!");
						if(this.getClickXCoordinate() == this.getRows() + 2){
							System.out.println(" and it is upright");
							card = new DrawPathCard("USEVEN", true);
						}
						else if(this.getClickXCoordinate() == this.getRows() + 3){
							System.out.println(" and it is upside down");
							card = new DrawPathCard("UDSEVEN", true);
						}
						else if(this.getClickXCoordinate() <= this.getRows() + 5){
							System.out.println(" and it is upside down with reverse horizontal");
							card = new DrawPathCard("UDRSEVEN", true);
						}
						else{
							System.out.println(" and it is a mirror image");
							card = new DrawPathCard("UMSEVEN", true);
						}
					}
					else{
						System.out.println("You selected a T!");
						if(this.getClickXCoordinate() <= this.getRows() + 3){
							System.out.println("and it is Upright!");
							card = new DrawPathCard("UT", true);
						}
						else if(this.getClickXCoordinate() <= this.getRows() + 5){
							System.out.println("and it is Upside Down!");
							card = new DrawPathCard("UDT", true);
						}
						else if(this.getClickXCoordinate() <= this.getRows() + 6){
							System.out.println("and it is rotated colckwise");
							card = new DrawPathCard("CRT", true);
						}
						else{
							System.out.println("and it is rotated anti-colckwise");
							card = new DrawPathCard("ART", true);
						}

					}
					PositionSelection positions = new PositionSelection();
					JFrame optionsPanel = new JFrame();
					positions.selectPosition(optionsPanel);
					positions.addObserver(this);
					this.setPositions(positions);
				}
			}
			else if(o == this.getPositions()){
				int iterator;
				System.out.println(this.getPositions().getxPos() + " from the left and "+this.getPositions().getyPos()+" from the top");
				if(((PlayerView)this.getLayer().getPlayer()).getPlayer() < this.getPlayerCount()){
					iterator = ((PlayerView)this.getLayer().getPlayer()).getPlayer();
					iterator++;
				}
				else{
					iterator = 1;
				}
				this.getCard().setFirstRectangleX(((DrawRectangle)this.getLayer().getBoard()).getxPosition());
				this.getCard().setFirstRectangleY(((DrawRectangle)this.getLayer().getBoard()).getyPosition());
				this.getCard().setIndHeight(((DrawRectangle) this.getLayer().getBoard()).getIndHeight());
				this.getCard().setIndWidth(((DrawRectangle) this.getLayer().getBoard()).getIndWidth());
				
				this.getCard().setxPosition(this.getPositions().getxPos());
				this.getCard().setyPosition(this.getPositions().getyPos());
				this.addCard(card);
				this.getLayer().setPathCards(this.getPathCards());
				((PlayerView)this.getLayer().getPlayer()).setPlayer(iterator);
				this.getLayer().getPlayer().repaint();
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

	public PositionSelection getPositions() {
		return positions;
	}

	public void setPositions(PositionSelection positions) {
		this.positions = positions;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	public ArrayList<DrawPathCard> getPathCards() {
		return pathCards;
	}

	public void setPathCards(ArrayList<DrawPathCard> pathCards) {
		this.pathCards = pathCards;
	}

	public DrawPathCard getCard() {
		return card;
	}

	public void setCard(DrawPathCard card) {
		this.card = card;
	}
	public void addCard(DrawPathCard card){
		ArrayList<DrawPathCard> cards = this.getPathCards();
		cards.add(card);
		this.setPathCards(cards);
	}
}
