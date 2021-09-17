package dev.teamdoom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.teamdoom.Player.Gender;

public class SceneTest {
	private Scene systemUnderTest;
    private Scene systemUnderTest2;
	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private ArrayList<UUID> nextScenes = new ArrayList<UUID>();

    @BeforeEach
    void createDeleteDataTest() {
		System.setOut(new PrintStream(outputStreamCaptor));
		nextScenes.add(UUID.randomUUID());
		nextScenes.add(UUID.randomUUID());
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("AAAAA");
		choices.add("BBBBB");
		ArrayList<Integer> choicePoints = new ArrayList<Integer>();
		choicePoints.add(5);
		choicePoints.add(-5);
		ArrayList<Integer> choicePoints2 = new ArrayList<Integer>();
		choicePoints2.add(0);
		choicePoints2.add(-5);

		ArrayList<String> responses = new ArrayList<String>();
		responses.add("AAAAA");
		responses.add("BBBBB");
		this.systemUnderTest = new Scene(
            UUID.randomUUID(), 
            "Do you go to school or ditch?", 
            choices, 
            choicePoints, 
            0, 
            responses, 
            new Player(
                10, 
                Gender.MALE, 
                10,
                UUID.randomUUID()), 
            TerminalColor.ANSI_BLACK, 
            nextScenes
        );
		this.systemUnderTest2 = new Scene(
            UUID.randomUUID(), 
            "Do you go to school or ditch?", 
            choices, 
            choicePoints2, 
            1, 
            responses, 
            new Player(
                10, 
                Gender.MALE, 
                10,
                UUID.randomUUID()), 
            TerminalColor.ANSI_BLACK, 
            nextScenes
        );
    }
    
    @Test
    void testScenePrintQuestion() {   
        this.systemUnderTest.printQuestion();
		assertEquals("Do you go to school or ditch?", outputStreamCaptor.toString().trim());
    } 	

    @Test
    void testScenePrintChoices() {   
        this.systemUnderTest.printChoices();
		assertEquals("AAAAA\nBBBBB", outputStreamCaptor.toString().trim());
    }

    // @Test  
    // void testGetUserChoiceSelection() {
    //     Console cs =  mock(Console.class);
    //     when(cs.readLine()).thenReturn("0");
    //     this.systemUnderTest.getUserChoiceSelection(cs);
	// 	assertEquals(this.systemUnderTest, outputStreamCaptor.toString().trim());
    // } 

    @Test
    void testSceneAppropriateResponse() { 
		assertEquals(this.systemUnderTest.getAppropriateResponse(0), "AAAAA");
    }
    
	 @Test
    void testChangeTextColorAndPrint() {   
        this.systemUnderTest.changeTextColorAndPrint(0);
        this.systemUnderTest.changeTextColorAndPrint(1);
        this.systemUnderTest2.changeTextColorAndPrint(0);
		
		assertTrue(outputStreamCaptor.toString().indexOf("AAAAA") != -1);
		assertTrue(outputStreamCaptor.toString().indexOf("BBBBB") != -1);
    }
	@Test
	void testGetNextScene() {
		assertEquals(nextScenes.get(0), this.systemUnderTest.getNextScene(0));

	};
}