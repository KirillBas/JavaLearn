package ru.basharin;

import ru.basharin.view.SelectFileView;
import ru.basharin.view.View;

import java.io.File;
import java.util.Scanner;

/**
 * Created by drbah on 07.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SelectFileView selectFileView = new SelectFileView(scanner);
        File file = selectFileView.readFileName();
        ClientStorage clientStorage = new ClientStorage(file);
        ClientRegistrant clientRegistrant = new ClientRegistrant(scanner, clientStorage);
        View view = new View(scanner, clientStorage,clientRegistrant);
        view.run();
    }
}

