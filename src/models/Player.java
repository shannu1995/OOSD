package models;

import java.util.ArrayList;


public abstract class Player {
	private int id;
	private int score;

	public Player(int id){
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
