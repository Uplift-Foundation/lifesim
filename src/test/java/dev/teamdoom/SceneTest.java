package dev.teamdoom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SceneTest {

    private Scene systemUnderTest;
	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    void createDeleteDataTest() {
		System.setOut(new PrintStream(outputStreamCaptor));
        this.systemUnderTest = new Scene(null, null, null, 0, null, null, null, null);
;
    }
    
    @Test
    void testScenePrintQuestion() {   
        this.systemUnderTest.printQuestion();
		assertEquals("Do you go to school or ditch?", outputStreamCaptor.toString().trim());
    }
	@AfterEach 
	void tearDown() {
		System.setOut(standardOut);
	}
}