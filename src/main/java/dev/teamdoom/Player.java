package dev.teamdoom;

import java.util.UUID;

public class Player implements IPlayer{
	public static enum Gender {
		MALE, FEMALE, NONBINARY
	}

private UUID uuid;

	private int age;
	public Player(int age, Gender gender, int reputation, UUID uuid) {
		this.age = age;
		this.gender = gender;
		this.reputation = reputation;
		this.uuid = uuid;
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
		return this.getAge() + "," + this.getGender() + "," + this.getReputation() + "," + this.getUuid();
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getUuid() {
		return uuid;
	}
}
