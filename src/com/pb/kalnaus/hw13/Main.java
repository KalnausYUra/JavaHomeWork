package com.pb.kalnaus.hw13;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int SIZE_BUFFER = 7;

    public static void main(String[] args) throws IOException {
        File createFile = createNumbersFile();
        List<Integer> buffer = new ArrayList<>();
        Consumer consumer = new Consumer(buffer);
        Manufacturer manufacturer = new Manufacturer(buffer);
        manufacturer.setFile(createFile);

        new Thread(consumer, "Consumer").start();
        new Thread(manufacturer, "Manufacturer").start();
    }

    private static File createNumbersFile() throws IOException {
        File file1 = new File("C:\\Users\\PC\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\kalnaus\\hw13\\files\\text.txt");
        FileWriter writer = new FileWriter(file1.getAbsoluteFile());
        for (int i = 0; i < 100; i++) {
            writer.write(" " + (new Random().nextInt(99) + 1));
            writer.flush();
        }
        writer.close();
        return file1;
    }
}
