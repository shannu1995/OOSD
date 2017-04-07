package view;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class BoardLayer extends JFrame{
	private int boardWidth;
	private int boardHeight;
	private JComponent board;
	private JComponent cross;
	private JComponent start;
	private JComponent player;
	private ArrayList<DrawPathCard> pathCards;
	private ArrayList<DrawActionCard> actionCards;
	private JLayeredPane layers;
	
	public int pleaseWork;
	
	public BoardLayer(int boardHeight, int boardWidth, JComponent board, JComponent cross, JComponent start, JComponent player){
		super("Saboteur");
		this.setBoardHeight(boardHeight);
		this.setBoardWidth(boardWidth);
		this.setBoard(board);
		this.setCross(cross);
		this.setStart(start);
		this.setPlayer(player);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(boardWidth, boardHeight);
		
		this.layers = getLayeredPane();
		this.layers.add(board, new Integer(1));
		this.layers.validate();
		
		this.layers.add(cross, new Integer(2));
		this.layers.validate();
		
		this.layers.add(start, new Integer(2));
		this.layers.validate();
		
		this.layers.add(player, new Integer(3));
		this.layers.validate();
		
	}
	public int getBoardWidth() {
		return boardWidth;
	}

	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public void setBoardHeight(int boardHeight) {
		this.boardHeight = boardHeight;
	}

	public JComponent getBoard() {
		return board;
	}

	public void setBoard(JComponent board) {
		this.board = board;
	}

	public JComponent getCross() {
		return cross;
	}

	public void setCross(JComponent cross) {
		this.cross = cross;
	}

	public JComponent getStart() {
		return start;
	}

	public void setStart(JComponent start) {
		this.start = start;
	}

	public JComponent getPlayer() {
		return player;
	}

	public void setPlayer(JComponent player) {
		this.player = player;
	}
	public ArrayList<DrawPathCard> getPathCards() {
		return pathCards;
	}
	public void setPathCards(ArrayList<DrawPathCard> pathCards) {
		for(int i = 0; i < pathCards.size(); i++){
			System.out.println("Once");
			this.layers.add(pathCards.get(i), new Integer(4));
		}
		this.pathCards = pathCards;
	}
	public ArrayList<DrawActionCard> getActionCards() {
		return actionCards;
	}
	public void setActionCards(ArrayList<DrawActionCard> actionCards) {
		this.actionCards = actionCards;
	}
}
