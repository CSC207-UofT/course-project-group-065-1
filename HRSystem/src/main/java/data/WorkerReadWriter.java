package data;

import java.io.*;

public class WorkerReadWriter {
    public void saveToFile(String filePath, Object workers) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream(filePath);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(workers);
            objectOutputStream.flush();
        }
    }
    public Object readFromFile(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream
                = new FileInputStream(filePath);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Object workers = objectInputStream.readObject();
        objectInputStream.close();
        return workers;
    }
}
