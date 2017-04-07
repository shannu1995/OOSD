package models;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import controllers.SelectSquare;
import view.BoardLayer;
import view.DrawActionCard;
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
	private DrawPathCard pathCard;

	private ArrayList<ActionCard> actionCards;
	private ActionCard actionCard;
	
	private int playerCount;
	private String cardType = "EMPTY";
			
	public Board(BoardLayer layer, int[][] treasureArray, int playerCount){
	
		this.setLayer(layer);
		SelectSquare select = (((DrawRectangle) this.getLayer().getBoard()).getSelector());
		select.addObserver(this);
		this.setRows(((DrawRectangle) this.getLayer().getBoard()).getRows());
		this.setColumns(((DrawRectangle) this.getLayer().getBoard()).getColumns());
		this.setPlayerCount(playerCount);
		ArrayList<DrawPathCard> pathCardsList = new ArrayList<DrawPathCard>();
		this.setPathCards(pathCardsList);
		ArrayList<ActionCard> acionCardsList = new ArrayList<ActionCard>();
		this.setActionCards(acionCardsList);

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
						pathCard = new DrawPathCard("PLUS", true);
						this.cardType = "PATH";
					}
					else if(this.getClickYCoordinate() <= 4){
						System.out.println("You selected a LINE!");
						if(this.getClickXCoordinate() == this.getRows() + 2){
							System.out.println(" and it is vertical");
							pathCard = new DrawPathCard("VLINE", true);
						}
						else{
							System.out.println(" and it is horizontal");
							pathCard = new DrawPathCard("HLINE", true);
						}
						this.cardType = "PATH";
					}
					else if(this.getClickYCoordinate() <= 5){
						System.out.println("You selected a SEVEN!");
						if(this.getClickXCoordinate() == this.getRows() + 2){
							System.out.println(" and it is upright");
							pathCard = new DrawPathCard("USEVEN", true);
						}
						else if(this.getClickXCoordinate() == this.getRows() + 3){
							System.out.println(" and it is upside down");
							pathCard = new DrawPathCard("UDSEVEN", true);
						}
						else if(this.getClickXCoordinate() <= this.getRows() + 5){
							System.out.println(" and it is upside down with reverse horizontal");
							pathCard = new DrawPathCard("UDRSEVEN", true);
						}
						else{
							System.out.println(" and it is a mirror image");
							pathCard = new DrawPathCard("UMSEVEN", true);
						}
						this.cardType = "PATH";
					}
					else if (this.getClickYCoordinate() <= 7){
						System.out.println("You selected a T!");
						if(this.getClickXCoordinate() <= this.getRows() + 3){
							System.out.println("and it is Upright!");
							pathCard = new DrawPathCard("UT", true);
						}
						else if(this.getClickXCoordinate() <= this.getRows() + 5){
							System.out.println("and it is Upside Down!");
							pathCard = new DrawPathCard("UDT", true);
						}
						else if(this.getClickXCoordinate() <= this.getRows() + 6){
							System.out.println("and it is rotated colckwise");
							pathCard = new DrawPathCard("CRT", true);
						}
						else{
							System.out.println("and it is rotated anti-colckwise");
							pathCard = new DrawPathCard("ART", true);
						}
						this.cardType = "PATH";
					}
					else {
						if(this.getClickYCoordinate() <= 8){
							System.out.println("You selected a BOMB!");
							this.actionCard = new ActionCard("BOMB");
						}
						else if(this.getClickYCoordinate() <= 9){
							System.out.println("You selected a BOMB DEFUSE!");
							this.actionCard = new ActionCard("DBOMB");
						}
						else if(this.getClickYCoordinate() <= 10){
							System.out.println("You selected a SPILL!");
							this.actionCard = new ActionCard("SPILL");
						}
						else if(this.getClickYCoordinate() <= 11){
							System.out.println("You selected a SPILL CLEANER!");
							this.actionCard = new ActionCard("CSPILL");
						}
						else if(this.getClickYCoordinate() <= 12){
							System.out.println("You selected a REMOVE PATH!");
							this.actionCard = new ActionCard("RMP");
						}
						else {
							System.out.println("You selected a ROTATE PATH!");
							this.actionCard = new ActionCard("RTP");
						}
						this.cardType = "ACTION";
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
				if(this.cardType.equals("PATH")){
					this.getPathCard().setFirstRectangleX(((DrawRectangle)this.getLayer().getBoard()).getxPosition());
					this.getPathCard().setFirstRectangleY(((DrawRectangle)this.getLayer().getBoard()).getyPosition());
					this.getPathCard().setIndHeight(((DrawRectangle) this.getLayer().getBoard()).getIndHeight());
					this.getPathCard().setIndWidth(((DrawRectangle) this.getLayer().getBoard()).getIndWidth());
					
					this.getPathCard().setxPosition(this.getPositions().getxPos());
					this.getPathCard().setyPosition(this.getPositions().getyPos());
					this.addPathCard(pathCard);
					this.getLayer().setPathCards(this.getPathCards());
				}
				else if(this.cardType.equals("ACTION")){
					if(this.getBoard()[this.getPositions().getyPos() - 1][this.getPositions().getxPos() - 1] == "PATH"){
						this.getActionCard().setFirstRectangleX(((DrawRectangle)this.getLayer().getBoard()).getxPosition());
						this.getActionCard().setFirstRectangleY(((DrawRectangle)this.getLayer().getBoard()).getyPosition());
						this.getActionCard().setIndHeight(((DrawRectangle) this.getLayer().getBoard()).getIndHeight());
						this.getActionCard().setIndWidth(((DrawRectangle) this.getLayer().getBoard()).getIndWidth());
						
						this.getActionCard().setxPosition(this.getPositions().getxPos());
						this.getActionCard().setyPosition(this.getPositions().getyPos());
						this.addActionCard(this.actionCard);
						this.getLayer().setActionCards(this.getActionCards());	
					}else{
						this.cardType = "EMPTY";
					}
				}
				this.updateBoard(this.getPositions().getxPos(), this.getPositions().getyPos(), cardType);
				((PlayerView)this.getLayer().getPlayer()).setPlayer(iterator);
				this.getLayer().getPlayer().repaint();
			}
	}
	public void updateBoard(int x, int y, String cardType){
		String[][] board = this.board;
		board[y - 1][x - 1] = cardType;
		this.printBoard();
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
		board[y - 1][x - 1] = "SPOT";
	}
	this.setStartSpot(((DrawStart) this.getLayer().getStart()).getPositions());
	int[] array = this.getStartSpot();
	board[array[1]][array[0] - 1] = "PLUS";
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

	public DrawPathCard getPathCard() {
		return pathCard;
	}

	public void setCard(DrawPathCard card) {
		this.pathCard = card;
	}
	public void addPathCard(DrawPathCard card){
		ArrayList<DrawPathCard> cards = this.getPathCards();
		cards.add(card);
		this.setPathCards(cards);
	}
	public void addActionCard(ActionCard card){
		ArrayList<ActionCard> cards = this.getActionCards();
		cards.add(card);
		this.setActionCards(cards);
	}
	public void printBoard(){
		for(int i = 0; i < this.getColumns(); i++){
			for(int j = 0; j < this.getRows(); j++){
					System.out.print(board[i][j]+" , ");
				}
				System.out.println();
			}
	}

	public ActionCard getActionCard() {
		return actionCard;
	}

	public void setActionCard(ActionCard actionCard) {
		this.actionCard = actionCard;
	}

	public ArrayList<ActionCard> getActionCards() {
		return actionCards;
	}

	public void setActionCards(ArrayList<ActionCard> actionCards) {
		this.actionCards = actionCards;
	}
}
