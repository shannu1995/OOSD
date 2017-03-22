package controllers;

import java.util.StringTokenizer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Board;
import view.BoardLayer;
import view.DrawCross;
import view.DrawRectangle;
import view.DrawStart;
import view.OptionSelction; 

public class Creator extends JFrame{
	
	public static final int IND_WIDTH = 50;
	public static final int IND_HEIGHT = 50;
	public static final int FIRST_RECTANGLE_X = 15;
	public static final int FIRST_RECTANGLE_Y = 15;
	public static final int NUMBER_OF_SPOTS = 3;
	
	public static void main(String[] args) {
		
		/*Get the options of the Game*/
		OptionSelction options = new OptionSelction();
		JPanel optionsPanel = new JPanel();
		options.showOptions(optionsPanel);
		
		int players = Integer.parseInt(options.getPlayerCountSelected());
		
		String delimeter = "x";
		String gridSizeInString = options.getSizeSelected();
		StringTokenizer st 	= new StringTokenizer(gridSizeInString, delimeter);
		String swidth =  (String) st.nextElement();
		String sheight = (String) st.nextElement();
		
		int width = Integer.parseInt(swidth);
		int height = Integer.parseInt(sheight);
		int totalWidth = IND_WIDTH * 2 * width;
		int totalHeight = IND_HEIGHT * 2 * height;
		
		System.out.println("You selected a grid of width: "+ width+" and height: "+ height +"\nNumber of players is: "+players);
		Board gameBoard = new Board(width, height);
	    JComponent boardComponent = new DrawRectangle(FIRST_RECTANGLE_X, FIRST_RECTANGLE_Y, IND_WIDTH, IND_HEIGHT, height, width, totalWidth, totalHeight);
	    JComponent crossComponent = null;
	    
	    GetTreasurePositions spots = new GetTreasurePositions(height, width);
	    int[][] array = new int[NUMBER_OF_SPOTS][2];
	    for(int i = 0; i < NUMBER_OF_SPOTS; i++){
	    	array[i] = spots.selectTreasureSpots();
	    	System.out.println("One potential treasure spot is "+array[i][0]+
	    			" from the top and "+array[i][1]+" from the left");
	    }
	    crossComponent = new DrawCross(totalWidth, totalHeight,IND_WIDTH, IND_HEIGHT, FIRST_RECTANGLE_X, FIRST_RECTANGLE_Y, array, NUMBER_OF_SPOTS);
	    JComponent start = new DrawStart(FIRST_RECTANGLE_X, FIRST_RECTANGLE_Y, IND_WIDTH, IND_HEIGHT, width, height);
	    BoardLayer layer = new BoardLayer(totalWidth, totalHeight, boardComponent, crossComponent, start);
	    
		layer.setVisible(true);
		}
	}
