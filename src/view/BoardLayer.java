package view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import controllers.SelectSquare;

public class BoardLayer extends JFrame{
	private int boardWidth;
	private int boardHeight;
	private JComponent board;
	private JComponent cross;
	private JComponent start;
	
	public int pleaseWork;
	
	public BoardLayer(int boardHeight, int boardWidth, JComponent board, JComponent cross, JComponent start){
		super("Saboteur");
		this.setBoardHeight(boardHeight);
		this.setBoardWidth(boardWidth);
		this.setBoard(board);
		this.setCross(cross);
		this.setStart(start);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(boardWidth, boardHeight);
		
		JLayeredPane layers = getLayeredPane();
		layers.add(board, new Integer(1));
		layers.add(cross, new Integer(2));
		layers.add(start, new Integer(2));
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
}
