package data;

import entities.DepartmentHead;
import entities.Worker;

import java.io.*;
import java.util.ArrayList;

public class DepartmentHeadReadWriter implements ReadWriter{
    public void saveToFile(String filePath, Object workers) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream(filePath);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(workers);
            objectOutputStream.flush();
        }
    }
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