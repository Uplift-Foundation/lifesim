package dev.teamdoom;

import com.google.gson.Gson;

public class LeaderboardScreen implements IConsoleScreen{
	Gson gson = new Gson();
	public void prepare() {

	}
	public void draw() {
		TerminalUtilities.clearScreen();
	}
}
