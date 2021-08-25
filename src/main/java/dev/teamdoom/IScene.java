package dev.teamdoom;

import java.util.ArrayList;
import java.util.UUID;

public interface IScene {
	void printQuestion();
	void printChoices();
	int getUserChoiceSelection();
	String getAppropriateResponse(int responseIndex);
	void changeTextColorAndPrint(int responseIndex);
	UUID getNextScene();
}
