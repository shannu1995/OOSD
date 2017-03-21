package controllers;

public class SaveCoordinates {
	
	private int x = 0;
	private int y = 0;
	
	public SaveCoordinates(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return this.x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
