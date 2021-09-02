package dev.teamdoom.CRUD;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import dev.teamdoom.Settings;
import dev.teamdoom.TerminalColor;

public class DataHandler <T> {
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

	public T deserializeObject(String fileName, Type type) throws Exception {
		try {
			Reader json = Files.newBufferedReader(Paths.get(Settings.SCENE_FILE));
			return new Gson().fromJson(json, type);

		} catch(JsonSyntaxException e) {
			e.printStackTrace();
			throw e;
		} catch(JsonIOException e) {
			e.printStackTrace();
			throw e;
		} catch(JsonParseException e) {
			e.printStackTrace();
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
