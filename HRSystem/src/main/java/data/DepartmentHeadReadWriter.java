package data;

import entities.DepartmentHead;

import java.io.*;
import java.util.ArrayList;

public class DepartmentHeadReadWriter implements ReadWriter{
    /**
     * Writes the list of department heads to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param heads    stores the list of department heads to be serialized
     */
    public void saveToFile(String filePath, Object heads) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream(filePath);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(heads);
            objectOutputStream.flush();
        }
    }

    /**
     * Store the list of department heads from file at filePath.
     *
     * @param filePath file where the department heads list is stored
     * @return list of department heads
     */
    @SuppressWarnings("unchecked")
    public ArrayList<DepartmentHead> readFromFile(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream
                = new FileInputStream(filePath);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        ArrayList<DepartmentHead> heads = (ArrayList<DepartmentHead>) objectInputStream.readObject();
        objectInputStream.close();
        return heads;
    }
}