package dev.teamdoom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDataHandler implements IDataHandler {

	private String fileLocation;
	private File file;
	Scanner scanner;

	public FileDataHandler(String fileLocationFromUser) {
		this.fileLocation = fileLocationFromUser;
		try {
			this.file = new File(fileLocationFromUser);
			this.scanner = new Scanner(this.file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createPlayer(Player player) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(this.fileLocation, true));
			bw.write(player.toString());
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// This would go in it's own FileDataHandler - like SceneFileDataHandler.java
	// public Scene readScene(String fileName) {
	// 	if (this.file != null) {
	// 		try {
	// 			this.scanner = new Scanner(this.file);
	// 		} catch (FileNotFoundException e) {
	// 			e.printStackTrace();
	// 		}
	// 		while (this.scanner != null && this.scanner.hasNextLine()) {
	// 			String line = this.scanner.nextLine();
	// 			String[] props = line.split(",");
	// 			return new Scene(props[0], props[1], props[2], props[3], props[4], props[5], props[6], props[7], props[8], props[9]);
	// 		}
	// 	}
	// 	return new Player(18, Player.Gender.MALE, 0);
	// }
		

	@Override
	public Player readPlayer() throws Exception {
		if (this.file != null) {
			try {
				this.scanner = new Scanner(this.file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while (this.scanner != null && this.scanner.hasNextLine()) {
				String line = this.scanner.nextLine();
				String[] props = line.split(",");
				return new Player(Integer.parseInt(props[0]), Player.Gender.valueOf(props[1]),
						Integer.parseInt(props[2]));
			}
		}
		return new Player(18, Player.Gender.MALE, 0);
	}

	@Override
	public Player updatePlayer(Player player) {

		try {
			this.deletePlayer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.createPlayer(player);
		return player;
	}

	@Override
	public void deletePlayer() throws Exception {
		this.file.delete();

	}

	// @Override
	// public void deletePlayer(String fileName) throws Exception
	// {
	// // This is delete from a file
	// //now read the file line by line...
	// ArrayList<String> lines = new ArrayList<String>();
	// if (this.file != null)
	// {
	// this.scanner = new Scanner(this.file);
	// while (this.scanner != null && this.scanner.hasNextLine())
	// {
	// String line = this.scanner.nextLine();
	// }
	// }

	// BufferedWriter bw;
	// try
	// {
	// bw = new BufferedWriter(new FileWriter(this.fileLocation));
	// lines.forEach(lineToWrite ->
	// {
	// try
	// {
	// bw.write(lineToWrite);
	// bw.newLine();
	// } catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	// }
	// );
	// bw.flush();
	// bw.close();
	// return true;
	// } catch (IOException e1)
	// {
	// e1.printStackTrace();
	// }
	// // We throw a custom error here if we can't find anything with that ID
	// throw new Exception("Item not found with that ID");
	// }
}