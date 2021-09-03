package dev.teamdoom;

import java.util.UUID;
import java.io.Console;

public interface IScene {
	void printQuestion();
	void printChoices();
	int getUserChoiceSelection();
	String getAppropriateResponse(int responseIndex);
	void changeTextColorAndPrint(int responseIndex);
	UUID getNextScene(int responseIndex);
}
