package dev.teamdoom;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import dev.teamdoom.Settings;
import dev.teamdoom.CRUD.DataHandler;

public class App {
	private static List<DefaultScene> scenes;
	// private static Type typeOfSceneArray = new TypeToken<ArrayL÷

	public static void main(String[] args) {
		loadScenes();

		TitleScreen titleScreen = new TitleScreen(scenes);
		titleScreen.draw();

	}

	private static void loadScenes() {
		try {
			final Type SceneArray = new TypeToken<ArrayList<DefaultScene>>(){}.getType();
			scenes = new DataHandler<List<DefaultScene>>().deserializeObject(Settings.SCENE_FILE, SceneArray);
		} catch (Exception e) {
			System.out.println("There was an error loading scenes from the JSON file. oop");
		}
	}
}
