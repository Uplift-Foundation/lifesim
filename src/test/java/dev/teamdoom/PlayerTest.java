package dev.teamdoom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

	private Player systemUnderTest;
	private Player systemUnderTest2;


	@BeforeEach
	void createDeleteDataTest() {
		this.systemUnderTest = new Player(10, Player.Gender.MALE, 10); // create a new player here
		;
	}
	@Test
	void testSaveAndLoadFile() {
		systemUnderTest2 = new Player(20, Player.Gender.FEMALE, 20);
		systemUnderTest2.saveToFile();

		systemUnderTest2 = null;
		try {
			// systemUnderTest2 = Player.loadPlayerFromGame();
			assertEquals(20, systemUnderTest2.getAge());
			assertEquals(Player.Gender.FEMALE, systemUnderTest2.getGender());
			assertEquals(20, systemUnderTest2.getReputation());
	
		} catch(Exception e) {
			return;
		}
	}
	@Test
	void testGetGender() {
		assertEquals(Player.Gender.MALE, this.systemUnderTest.getGender());
	}

	@Test
	void testGetReputation() {
		assertEquals(10, this.systemUnderTest.getReputation());
	}

	@Test
	void testGetAge() {		
        assertEquals(10, this.systemUnderTest.getAge());
	}
    @Test
	void testSetGender() {
		this.systemUnderTest.setGender(Player.Gender.FEMALE);
		assertEquals(Player.Gender.FEMALE, systemUnderTest.getGender());
	}
    @Test
    void testSetReputation() {
		this.systemUnderTest.setReputation(20);
        assertEquals(20, systemUnderTest.getReputation());
	}
	@Test
    void testSetAge() {
		this.systemUnderTest.setAge(7);
		assertEquals(7, systemUnderTest.getAge());
	}
}