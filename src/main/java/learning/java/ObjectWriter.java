package learning.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriter {
    public void saveObjectToFile(String filePath, Object object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(object);
            System.out.println("Об'єкт успішно збережено у файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Помилка під час запису об'єкта у файл: " + e.getMessage());
        }
    }
}
