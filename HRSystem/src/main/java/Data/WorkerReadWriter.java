package Data;

import Entities.Worker;

import java.io.*;
import java.util.ArrayList;

public class WorkerReadWriter implements ReadWriter{
    /**
     * Writes the workers to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param workers    stores the list of workers to be serialized
     */
    public void saveToFile(String filePath, Object workers) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream(filePath);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(workers);
            objectOutputStream.flush();
        }
    }

    /**
     * Store the list of workers from file at filePath.
     *
     * @param filePath file where the workers list is stored
     * @return list of workers
     */
    @SuppressWarnings("unchecked")
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
