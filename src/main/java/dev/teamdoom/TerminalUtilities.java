package dev.teamdoom;


// No copy paste code unless you can tell me in detail what it does.
public class TerminalUtilities {
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String BLACK_BRIGHT = "\033[0;90m"; // BLACK
	public static final String RED_BRIGHT = "\033[0;91m"; // RED
	public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
	public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
	public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
	public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
	public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
	public static final String WHITE_BRIGHT = "\033[0;97m"; // WHITE

	public static final void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static final void printLine(String s, String color) {
		System.out.println(color + s + ANSI_RESET);

	}

	public static final String colorString(String s, String color) {
		return color + s + ANSI_RESET;
	}

	public static final int[] getDimensions() {
		int columns;
		int lines;
		try {
			columns = Integer.parseInt(System.getenv("COLUMNS"));
			lines = Integer.parseInt(System.getenv("LINES"));
		} catch (Exception e) {
			printLine("NOTE: Width and height of console could not be determined. Using 200x100. To fix this, export LINES and COLUMN variables.", YELLOW_BRIGHT);
			columns = 200;
			lines = 100;
		}
		return new int[] { columns, lines };

	}
}
