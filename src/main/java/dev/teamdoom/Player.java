package dev.teamdoom;

public class Player implements IPlayer{
	public static enum Gender {
		MALE, FEMALE, NONBINARY
	}
	private int age;
	public Player(int age, Gender gender, int reputation) {
		this.age = age;
		this.gender = gender;
		this.reputation = reputation;
	}
	private Gender gender;
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	public String toString() {
		return this.getAge() + "," + this.getGender() + "," + this.getReputation();
	}

}
