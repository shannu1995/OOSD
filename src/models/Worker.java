package models;

import java.util.ArrayList;

public class Worker extends Player{
	private int positionOfVictory;
	public Worker(int id, ArrayList<Card> deck) {
		super(id);
	}
	
	public int getPositionOfVictory() {
		return positionOfVictory;
	}
	public void setPositionOfVictory(int positionOfVictory) {
		this.positionOfVictory = positionOfVictory;
	}

}
