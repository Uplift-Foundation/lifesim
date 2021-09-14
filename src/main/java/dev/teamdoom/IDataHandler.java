package dev.teamdoom;

public interface IDataHandler { 
    public void createPlayer(String fileName, Player player);
    public Player readPlayer(String fileName) throws Exception;
    public void updatePlayer(String fileName, Player player);
    public void deletePlayer(String fileName) throws Exception;
}