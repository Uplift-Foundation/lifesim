package dev.teamdoom;

import java.io.Console;
import java.util.ArrayList;
import java.util.UUID;

public class DefaultScene implements IScene {
	public enum POINT_TYPE {
		PLAYER_REP, PLAYER_INT, PLAYER_FIT
	};
	private UUID id;
	private POINT_TYPE point_type;
	private String question;
	private ArrayList<String> choices;
	private ArrayList<Integer> choicePoints;
	private ArrayList<String> responses;

	public DefaultScene(UUID id, String question, ArrayList<String> choices, ArrayList<Integer> choicePoints,
			ArrayList<String> responses, POINT_TYPE pointTypeFromUser) {
		this.setId(id);
		this.setPointType(pointTypeFromUser);
		this.setQuestion(question);
		this.setChoices(choices);
		this.setChoicePoints(choicePoints);
		this.setResponses(responses);
	}

	public POINT_TYPE getPointType() {
		return point_type;
	}

	public void setPointType(POINT_TYPE point_type) {
		this.point_type = point_type;
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
<<<<<<< Updated upstream
		// TODO Auto-generated method stub

	}

	@Override
	public int getUserChoiceSelection(Console c) {
		// TODO Auto-generated method stub
		return 0;
=======
		for(int i = 1; i <= choices.size(); i++){
			System.out.println(i + ") " + choices.get(i - 1));
		}
	}

	//gets the selections
	public int getUserChoiceSelection() {
		System.out.println("You can enter the choice number, from 1 to " + (responses.size()));
		try {
		int userChoiceSelection = Integer.parseInt(System.console().readLine()); //maybe later we can also enter the choice by name
		return userChoiceSelection - 1;

	} catch(Exception e) {
		}
>>>>>>> Stashed changes
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
