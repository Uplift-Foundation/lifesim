package dev.teamdoom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SceneTest {
	private final PrintStream standardOut = System.out;
    private Scene systemUnderTest;
	private Player defaultPlayer;

	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void createDeleteDataTest() {
		System.setOut(new PrintStream(outputStreamCaptor));
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("AAAAA");
		choices.add("BBBBB");
		ArrayList<Integer> choicePoints = new ArrayList<Integer>();
		choicePoints.add(5);
		choicePoints.add(-5);
		ArrayList<String> responses = new ArrayList<String>();
		responses.add("AAAAA");
		responses.add("BBBBB");
		this.systemUnderTest = new Scene(UUID.randomUUID(), "Do you go to school or ditch?", choices, choicePoints, responses, new Player(), TerminalColor.ANSI_BLACK, new ArrayList<UUID>());
		this.defaultPlayer = new Player(10, Player.Gender.MALE, 10);
        // this.systemUnderTest = new Scene(UUID.randomUUID(), "Do you go to school or ditch?", new ArrayList<String>(), new ArrayList<Integer>(), new ArrayList<String>(), defaultPlayer, "RED", UUID.randomUUID());
    }
    
    @Test
    void testScenePrintQuestion() {   
        this.systemUnderTest.printQuestion();
		assertEquals("Do you go to school or ditch?", outputStreamCaptor.toString().trim());
    } 	

    @Test
    void testScenePrintChoices() {   
        this.systemUnderTest.printChoices();
		assertEquals(this.systemUnderTest, outputStreamCaptor.toString().trim());
    }
    @Test  
    void testGetUserChoiceSelection() {   
        this.systemUnderTest.getUserChoiceSelection();
		assertEquals(this.systemUnderTest, outputStreamCaptor.toString().trim());
    } 

    @Test
    void testSceneAppropriateResponse() {   
        this.systemUnderTest.getAppropriateResponse(0);
		assertEquals("AAAAA", outputStreamCaptor.toString().trim());
    }
    
	 @Test
    void testChangeTextColorAndPrint() {   
        this.systemUnderTest.changeTextColorAndPrint(0);
		assertEquals(this.systemUnderTest, outputStreamCaptor.toString().trim());
    }
}