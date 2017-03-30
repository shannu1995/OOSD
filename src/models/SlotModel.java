package models;

public class SlotModel {
	private String name;
	public SlotModel(String name){
		this.setName(name);
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}
