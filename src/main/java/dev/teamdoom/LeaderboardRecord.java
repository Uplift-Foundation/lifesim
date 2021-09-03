package dev.teamdoom;

import java.util.UUID;

public class LeaderboardRecord {
	private int maxage;
	private int maxrep;
	private String nickname;
	private UUID id;
	public LeaderboardRecord(int maxage, int maxrep, String nickname, UUID id) {
		this.setMaxage(maxage);
		this.setMaxrep(maxrep);
		this.setNickname(nickname);
		this.setId(id);
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getMaxrep() {
		return maxrep;
	}
	public void setMaxrep(int maxrep) {
		this.maxrep = maxrep;
	}
	public int getMaxage() {
		return maxage;
	}
	public void setMaxage(int maxage) {
		this.maxage = maxage;
	}
	

}