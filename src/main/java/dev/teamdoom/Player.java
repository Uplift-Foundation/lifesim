package dev.teamdoom;

public class Player implements IPlayer{
	private int age;
	public Player(int age, int gender, int reputation) {
		this.age = age;
		this.gender = gender;
		this.reputation = reputation;
	}
	private int gender;
	private int reputation;
	public int getReputation() {
		return reputation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}


}
