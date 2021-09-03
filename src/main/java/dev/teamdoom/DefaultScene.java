package dev.teamdoom;

import java.io.Console;
import java.util.ArrayList;
import java.util.UUID;

public class DefaultScene implements IScene {
	private UUID id;
	private String question;
	private ArrayList<String> choices;
	private ArrayList<Integer> choicePoints;
	private ArrayList<String> responses;

	public DefaultScene(UUID id, String question, ArrayList<String> choices, ArrayList<Integer> choicePoints,
			ArrayList<String> responses) {
		this.setId(id);
		this.setQuestion(question);
		this.setChoices(choices);
		this.setChoicePoints(choicePoints);
		this.setResponses(responses);
	}

	public ArrayList<String> getResponses() {
		return responses;
	}

	public void setResponses(ArrayList<String> responses) {
		this.responses = responses;
	}

	public ArrayList<Integer> getChoicePoints() {
		return choicePoints;
	}

	public void setChoicePoints(ArrayList<Integer> choicePoints) {
		this.choicePoints = choicePoints;
	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public void printQuestion() {
		System.out.println(question);	
	}

	@Override
	//prints the choices
	public void printChoices() {
		for(int i = 0; i < choices.size() - 1; i++){
			System.out.println(i + ") " + choices.get(i));
		}
	}

	//gets the selections
	public int getUserChoiceSelection() {
		System.out.println("You can enter the choice number, from 0 to " + (responses.size() - 1));
		int userChoiceSelection = Integer.parseInt(System.console().readLine()); //maybe later we can also enter the choice by name
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

	// @Override
	public UUID getNextScene(int responseIndex) {
		//TO BE IMPLEMENTED
		return null;	
	}

}
