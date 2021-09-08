package dev.teamdoom.CRUD;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.gson.Gson;

import dev.teamdoom.Settings;

public class DataHandler<T> { // You broke your contract - needs to implement an interface

	// I understand what you are going for here and it's valid
	// For this course - separate your Create and Update into two 
	// separate methods
	public void serializeObject(String fileName, T newObject) throws Exception {
		try {
			Reader json = Files.newBufferedReader(Paths.get(fileName));
			Object oldObject = new Gson().fromJson(json, newObject.getClass());

			if (newObject != oldObject) {
				Writer writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8,
						StandardOpenOption.CREATE);
				writer.write(new Gson().toJson(newObject));
				writer.close();
			}
		} catch (Exception e) {
			// the file probably doesn't exist, so we'll make it.
			Writer writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8,
					StandardOpenOption.CREATE);
			writer.write(new Gson().toJson(newObject));
			writer.close();
			e.printStackTrace();
		}

	}

	public static void deleteFile(String fileName) {
		try {
			Files.deleteIfExists(Paths.get(fileName));
		} catch (Exception e) {

		}
	}

	// This can probably be private and not a part of your interface 
	// (It's exclusive to the file DataHandler - wouldn't be required by other storage mechanisms)
	public static boolean doesFileExist(String fileName) {
		return Files.exists(Paths.get(fileName));
	}

	public T deserializeObject(String fileName, Type type) throws Exception {
		try {
			Reader json = Files.newBufferedReader(Paths.get(Settings.SCENE_FILE));
			return new Gson().fromJson(json, type);
		} catch (Exception e) {
			throw e;
		}
	}
}
