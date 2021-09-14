package dev.teamdoom;

public interface IDataHandler<T> {
    public void createObject(String fileName);

    public void updateObject(String fileName, T newObject);

    public void deleteObject(String fileName);

    public T readObject(String fileName, T type);
}
