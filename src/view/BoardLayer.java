package view;

import java.awt.Graphics;

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
	private JComponent DrawPathCard;
	
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
		
		JLayeredPane layers = getLayeredPane();
		layers.add(board, new Integer(1));
		layers.validate();
		
		layers.add(cross, new Integer(2));
		layers.validate();
		
		layers.add(start, new Integer(2));
		layers.validate();
		
		layers.add(player, new Integer(3));
		layers.validate();
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
}
