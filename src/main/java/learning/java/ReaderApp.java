package learning.java;

import java.util.Scanner;

public class ReaderApp {
    public static void main(String[] args) {
        ObjectWriter writer = new ObjectWriter();
        ObjectFileReader reader = new ObjectFileReader();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до файлу для збереження об'єкта: ");
        String saveFilePath = scanner.nextLine();

        System.out.print("Введіть ім'я користувача: ");
        String name = scanner.nextLine();

        System.out.print("Введіть вік користувача: ");
        int age = scanner.nextInt();

        // Створення об'єкта та його збереження
        User user = new User(name, age);
        writer.saveObjectToFile(saveFilePath, user);

        // Читання об'єкта з файлу
        User loadedUser = reader.readObjectFromFile(saveFilePath);
        if (loadedUser != null) {
            System.out.println("Зчитаний об'єкт: " + loadedUser);
        }
    }
}
