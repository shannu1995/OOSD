package models;

import java.util.ArrayList;

import controllers.PlayerPath;

public abstract class Player {
	private int id;
	private int score;
	private PlayerPath path;
	private ArrayList<Card> deck;

	public Player(int id, ArrayList<Card> deck){
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

	public PlayerPath getPath() {
		return path;
	}

	public void setPath(PlayerPath path) {
		this.path = path;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
}
