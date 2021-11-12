package data;

import entities.Worker;

import java.io.*;
import java.util.ArrayList;

public class WorkerReadWriter implements ReadWriter{
    public void saveToFile(String filePath, Object workers) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream(filePath);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(workers);
            objectOutputStream.flush();
        }
    }
    public ArrayList<Worker> readFromFile(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream
                = new FileInputStream(filePath);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        ArrayList<Worker> workers = (ArrayList<Worker>) objectInputStream.readObject();
        objectInputStream.close();
        return workers;
    }
}
