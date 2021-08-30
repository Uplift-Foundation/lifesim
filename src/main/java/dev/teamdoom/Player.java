package dev.teamdoom;

import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.gson.Gson;

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

	public static final Boolean saveFileExists() {
		return Files.exists(Paths.get(Settings.SAVE_FILE));
	}

	public void saveToFile() {
		try {
			Writer writer = Files.newBufferedWriter(Paths.get(Settings.SAVE_FILE), StandardCharsets.UTF_8,
					StandardOpenOption.CREATE);
			writer.write(new Gson().toJson(this));
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static final Player loadPlayerFromGame() {
		try {
			// checks if player savefile exists
			Reader reader = Files.newBufferedReader(Paths.get(Settings.SAVE_FILE));
			Player player = new Gson().fromJson(reader, Player.class);
			return player;
		} catch (Exception e) {
			// later handle more exceptions, but for the moment assume we don't have a
			// savefile
			return new Player(10, Gender.MALE, 10);

		}
	}

}
