package dev.teamdoom;

public interface IDataHandler<T> {
    public void createObject(String fileName);

public void cupdateObject ()sSruing fileName,T newObject;

    public static void deleteObject(String fileName);

    public T readObject(String fileName, Type type);

}
