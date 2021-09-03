package dev.teamdoom;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dev.teamdoom.CRUD.DataHandler;

public class Scene implements IScene {
	private UUID id;
	private String question;
	private ArrayList<String> choices;
	private ArrayList<Integer> choicePoints;
	private ArrayList<String> responses;
	private Player playerCharacter;
	private String textColor;
	private ArrayList<UUID> nextScene;
	Console c;
	
	public Scene(
		UUID id, 
		String question, 
		ArrayList<String> choices, 
		ArrayList<Integer> choicePoints,
		int userChoiceSelection,
		ArrayList<String> responses, 
		Player playerCharacter, 
		String textColor, 
		ArrayList<UUID> nextScene
	) {
		this.id = id;
		this.question = question;
		this.choices = choices;
		this.choicePoints =  choicePoints;
		this.responses = responses;
		this.playerCharacter = playerCharacter;
		this.textColor = textColor;
		this.nextScene = nextScene;
	}	
    
	public static void saveToFile(List<Scene> scenes) {
		// new DataHandler<()>.serializeObject(Settings.SCENE_FILE, Scene.class);
	}

	@Override
	//asks the question
	public void printQuestion() {
		System.out.println(question);	
	}

	@Override
	//prints the choices
	public void printChoices() {
		System.out.println("You can enter choices 0 through " + choices.size());
		for(String choice : choices){
			System.out.println(choice);
		}
	}

	//gets the selections
	public int getUserChoiceSelection(Console c) {
		System.out.println("You can enter the choice number, from 0 to " + responses.size() );
		int userChoiceSelection = Integer.parseInt(c.readLine()); //maybe later we can also enter the choice by name
		return userChoiceSelection;
	}

	@Override
	//gets appropriate responses
	public String getAppropriateResponse(int responseIndex) {
		String response = responses.get(responseIndex);
		return response;
	}
	

	@Override
	public void changeTextColorAndPrint(int responseIndex) {
		int points = choicePoints.get(responseIndex);
		if (points > 0) {
			TerminalUtilities.printLine(responses.get(responseIndex), TerminalUtilities.GREEN_BRIGHT);
		}
		if (points == 0) {
			TerminalUtilities.printLine(responses.get(responseIndex), TerminalUtilities.YELLOW_BRIGHT);
		}
		if (points < 0) {
			TerminalUtilities.printLine(responses.get(responseIndex), TerminalUtilities.RED_BRIGHT);
		}
	}

	@Override
	public UUID getNextScene(int responseIndex) {
		UUID UUIDtoReturn = nextScene.get(responseIndex);
		return UUIDtoReturn;	
	}
	
}
