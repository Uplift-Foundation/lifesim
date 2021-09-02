package dev.teamdoom;

import dev.teamdoom.CRUD.DataHandler;

public class Player implements IPlayer {
	public static enum Gender {
		MALE, FEMALE, NONBINARY
	}

	private int age;
	// private String name;

	public Player(int age, Gender gender, int reputation) {
		this.age = age;
		this.gender = gender;
		this.reputation = reputation;
		// this.setName(name);
	}
	/*
	 * in the future we may need name props public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 */

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

	public void saveToFile() {
		DataHandler.serializeObject(Settings.SAVE_FILE, this);
	}

	public static final Player loadPlayerFromGame() throws Exception {
			try {
			 return new DataHandler<Player>().deserializeObject(Settings.SAVE_FILE, Player.class);
			}
			catch (Exception e) {
				throw e;
	}
}

}
