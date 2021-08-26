package dev.teamdoom;

import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class App {
	private static List<Scene> scenes;
	private static Player player;

	public static void newOrLoadPlayer() {
		System.out.println("Welcome to the game!");
		if (Player.saveFileExists()) {
			player = Player.loadPlayerFromGame();
			System.out.println("Welcome back, " + player.getName() + "!");
			System.out.println("Want to start a new game or continue?");
			System.out.println("1. New Game");
			System.out.println("2. Continue");
			System.out.println("3. Quit");
			int choice = Integer.parseInt(System.console().readLine());
			switch (choice) {
			case 1:
				System.out.println("Starting new game...");
				System.out.println("What is your name?");
				String name = System.console().readLine();
				player = new Player(7, Player.Gender.FEMALE, 25, name);
				Player.saveToFile(player);
				break;
			case 2:
			//continue game here
				System.out.println("Alright. Resuming Game");
			case 3:
				System.exit(0);
			}
		} else {
			System.out.println("Savefile doesn't exists");
		}
	}
		

	public static void main(String[] args) {
		// load from json
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("Yes");
		choices.add("No");
		ArrayList<Integer> choicePoints = new ArrayList<Integer>();
		choicePoints.add(5);
		choicePoints.add(-5);

		ArrayList<String> responses = new ArrayList<String>();
		choices.add("Yes");
		choices.add("No");

		ArrayList<UUID> nextScenes = new ArrayList<UUID>();
		nextScenes.add(UUID.randomUUID());
		nextScenes.add(UUID.randomUUID());

		scenes.add(new Scene(UUID.randomUUID(), "You have the choice to ditch school. Yes or no?", choices, choicePoints, 0, responses, player, TerminalColor.RED_BRIGHT, nextScenes));
		Scene.saveToFile(scenes);

		newOrLoadPlayer();

	}
}
