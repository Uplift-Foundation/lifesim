package dev.teamdoom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileDataHandlerTest {
    
    private FileDataHandler systemUnderTest;
    private Player testPlayer;

    @BeforeEach
    void assignObs(){
        this.systemUnderTest = new FileDataHandler("./Objects.csv");
        this.testPlayer = new Player(16, Player.Gender.MALE, 0, UUID.randomUUID());
    }

    @Test 
    void testCreatePlayer(){
        this.systemUnderTest.createPlayer(testPlayer);
    };

     @Test 
     void testUpdate(){
         this.systemUnderTest.createPlayer(testPlayer);
         this.testPlayer.setAge(27);
         Player updatePlayer = (Player) this.systemUnderTest.updatePlayer(testPlayer);
         assertEquals(updatePlayer.getAge(), 27);
     }

    @Test
    void testRead() throws Exception {
        try {
            this.systemUnderTest.createPlayer(this.testPlayer);
        }
        catch (Exception e) {

        }
        assertEquals(testPlayer.getGender(), Player.Gender.MALE);
    }

      @Test 
      void testDelete() throws Exception{
        this.systemUnderTest.createPlayer(this.testPlayer);
        Player playerFromFile = this.systemUnderTest.readPlayer();
        assertEquals(playerFromFile.getGender(), Player.Gender.MALE);
        this.systemUnderTest.deletePlayer(playerFromFile);
        // Exception exception = assertThrows(Exception.class, 
        //     this.systemUnderTest.readPlayer()); 
      }
}