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
		// TODO Auto-generated method stub

	}

	@Override
	public void printChoices() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getUserChoiceSelection(Console c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAppropriateResponse(int responseIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeTextColorAndPrint(int responseIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public UUID getNextScene(int responseIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
