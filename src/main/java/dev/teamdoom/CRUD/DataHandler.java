package dev.teamdoom.CRUD;

import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.gson.Gson;

import dev.teamdoom.Settings;

public class DataHandler {
	public static void serializeObject(String fileName, Object object) {
		try {
		Reader json = Files.newBufferedReader(Paths.get(fileName));
		Object oldObject = new Gson().fromJson(json, object.getClass());

		if (object != oldObject) {
				Writer writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8,
						StandardOpenOption.CREATE);
				writer.write(new Gson().toJson(object));
				writer.close();
			}
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	}

	public static void deleteFile(String fileName) {
		try {
			Files.deleteIfExists(Paths.get(fileName));

		} catch (Exception e) {

		}
	}

	public static boolean doesFileExist(String fileName) {
		return Files.exists(Paths.get(fileName));
	}

	public static Object deserializeObject(String fileName, Object object) {
		try {
			Reader json = Files.newBufferedReader(Paths.get(Settings.SAVE_FILE));
			return new Gson().fromJson(json, object.getClass());

		} catch (Exception e) {
			e.printStackTrace();
			return new Object();
		}

	}
}
