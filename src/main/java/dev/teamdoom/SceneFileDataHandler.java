// package dev.teamdoom;

// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Arrays;
// import java.util.Scanner;
// import java.util.UUID;

// public class SceneFileDataHandler {

// 	private String fileLocation;
// 	private File file;
// 	Scanner scanner;

// 	public SceneFileDataHandler(String fileLocationFromUser) {
// 		this.fileLocation = fileLocationFromUser;
// 		try {
// 			this.file = new File(fileLocationFromUser);
// 			this.scanner = new Scanner(this.file);
// 		} catch (FileNotFoundException e) {
// 			e.printStackTrace();
// 		}
// 	}

// 	@Override
// 	public void createScene(Scene scene) {
// 		BufferedWriter bw;
// 		try {
// 			bw = new BufferedWriter(new FileWriter(this.fileLocation, true));
// 			bw.write(scene.toString());
// 			bw.newLine();
// 			bw.flush();
// 			bw.close();
// 		} catch (IOException e1) {
// 			e1.printStackTrace();
// 		}
// 	}

// 	@Override
// 	public Scene readScene() throws Exception {
// 		if (this.file != null) {
// 			try {
// 				this.scanner = new Scanner(this.file);
// 			} catch (FileNotFoundException e) {
// 				e.printStackTrace();
// 			}
// 			while (this.scanner != null && this.scanner.hasNextLine()) {
// 				String line = this.scanner.nextLine();
// 				String[] props = line.split(","); 
// 				// if (line.indexOf(UUID.fromString(props[3])) != -1) {
// 					return new Scene(UUID.fromString(props[0]), props[1],
// 					Arrays.asList(props[2].split(";")), Arrays.asList((props[3].split(";")));
// 				// }
// 			}
// 		}
// 		return new Scene(18, Player.Gender.MALE, 0, UUID.randomUUID());
// 	}

// 	@Override
// 	public Scene updateScene(Scene scene) {

// 		try {
// 			this.deleteScene(scene);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		this.createScene(scene);
// 		return scene
// 	}

// 	@Override
// 	public void deleteScene(Scene scene) throws Exception {
// 			if (this.file != null) {
// 				try {
// 					this.scanner = new Scanner(this.file);
// 				} catch (FileNotFoundException e) {
// 					e.printStackTrace();
// 				}
// 				while (this.scanner != null && this.scanner.hasNextLine()) {
// 					String line = this.scanner.nextLine();
// 					if (line.indexOf(player.getUuid().toString()) != -1) {
// 						// this should delete the line
// 					}
// 				}
// 			}
// 		}

// 	}

// // package dev.teamdoom;

// // public class SceneFileDataHandler {
    
// // This would go in it's own FileDataHandler - like SceneFileDataHandler.java
// 	// public Scene readScene(String fileName) {
// 	// 	if (this.file != null) {
// 	// 		try {
// 	// 			this.scanner = new Scanner(this.file);
// 	// 		} catch (FileNotFoundException e) {
// 	// 			e.printStackTrace();
// 	// 		}
// 	// 		while (this.scanner != null && this.scanner.hasNextLine()) {
// 	// 			String line = this.scanner.nextLine();
// 	// 			String[] props = line.split(",");
// 	// 			return new Scene(props[0], props[1], props[2], props[3], props[4], props[5], props[6], props[7], props[8], props[9]);
// 	// 		}
// 	// 	}
// 	// 	return new Player(18, Player.Gender.MALE, 0);
// 	// }

// // }
