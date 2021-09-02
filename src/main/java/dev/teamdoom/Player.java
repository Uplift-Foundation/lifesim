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

	public Player() {
		try {
			Player savedPlayer = new DataHandler<Player>().deserializeObject(Settings.SAVE_FILE, Player.class);
			this.gender = savedPlayer.gender;
			this.reputation = savedPlayer.reputation;
			this.age = savedPlayer.age;
		} catch (Exception e) {
			//assume that there is no player if this fails
			System.out.println("What gender is your player?");
			Player.Gender selectedGender = Player.Gender.valueOf(System.console().readLine().trim().toUpperCase());
			System.out.println("Want name do you want your player to have?");

			this.setGender(selectedGender);
			this.setReputation(0);
			
			this.saveToFile();
		}
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

}
