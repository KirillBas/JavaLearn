package ru.basharin.view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by drbah on 14.04.2017.
 */
public class SelectFileView {
    private final Scanner scanner;

    public SelectFileView(Scanner scanner) {
        this.scanner = scanner;
    }

    public File readFileName() {
        String input;
        while (true) {
            printFileMenu();
            input = scanner.nextLine();
            if (input.equals("#")) {
                return null;
            }
            try {
                return createOrRead(input);
            } catch (IOException e) {
                System.out.println("Невозможно создать файл с таким именем " + input);
            }
        }
    }

    private File createOrRead(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private void printFileMenu() {
        System.out.println("Вводите имя файла с которым вы хотите работать (# выход)");
    }
}
