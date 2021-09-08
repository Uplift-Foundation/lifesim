package dev.teamdoom.CRUD;

public interface IDataHandler {

    public void serializeObject();
    public void doesFileExist(); // This one can be removed - doesFileExist wouldn't apply to databases, etc.
	public void deleteFile(); // Delete file, or delete object?  Remember the generic applies to many storage mechanisms
    public void deserializeObject();

}
