package dev.teamdoom;

import java.util.List;

public class TitleScreen implements IConsoleScreen {
	private int[] dimensions = TerminalUtilities.getDimensions();

	private Player player;
	private List<DefaultScene> scenes;

	public TitleScreen(List<DefaultScene> scenes) {
		this.scenes = scenes;
	}

	public void draw() {
		TerminalUtilities.clearScreen();
		for (int i = 1; i <= dimensions[0]; i++) {
			System.out.print("X");
		}
		int paddingLines = Math.round(dimensions[1] / 3);
		for (int i = 1; i <= paddingLines; i++) {
			System.out.println("");
		}
		if (Player.saveFileExists()) {

			System.out.println("1. Continue Game");

		}
		System.out.println("2. New Game");
		System.out.println("3. Leaderboard");
		System.out.println("4. Exit");
		for (int i = 1; i <= paddingLines; i++) {
			System.out.println("");
		}
		for (int i = 1; i <= dimensions[0]; i++) {
			System.out.print("X");
		}
		System.out.println("Type in the option number:");
		int choice = Integer.parseInt(System.console().readLine());
		switch (choice) {
			case 1:
				break;
			case 2:
				TerminalUtilities.clearScreen();
				System.out.println("Name your character!");
				String name = System.console().readLine();
				System.out.println("What should your character's gender be?");
				Player.Gender gender = Player.Gender.valueOf(System.console().readLine().toUpperCase());

				player = new Player(name, 7, gender, 25);
				player.saveToFile();

				for(DefaultScene s: scenes) {
					s.printQuestion();
					s.printChoices();
					int userChoice = s.getUserChoiceSelection();
					s.changeTextColorAndPrint(userChoice);
				}
				break;
			case 3:
				LeaderboardScreen leaderboardScreen = new LeaderboardScreen();
				leaderboardScreen.draw();
				break;
			case 4:
				System.exit(0);
				break;
		}
	}
}
