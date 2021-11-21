package com.pb.kalnaus.hw9;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {

    public static void main(String[] args) throws IOException {
        File f = createNumbersFile();
        createOddNumbersFile(f);
    }

    private static File createNumbersFile() throws IOException {
        File file1 = new File("C:\\Users\\PC\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\kalnaus\\hw9\\files\\numbers.txt");
        FileWriter writer = new FileWriter(file1.getAbsoluteFile());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                writer.write(((new Random().nextInt(99)) + 1) + " ");
            }
            writer.append("\n");
            writer.flush();
        }
        writer.close();
        return file1;
    }

    private static void createOddNumbersFile(File f) {
        try {
            File file2 = new File("C:\\Users\\PC\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\kalnaus\\hw9\\files\\odd-numbers.txt");
            FileWriter writer2 = new FileWriter(file2.getAbsoluteFile());
            FileReader reader = new FileReader(f.getAbsoluteFile());
            Scanner scanner = new Scanner(reader);
            String[] temp;
            int[] temp2;
            while (scanner.hasNextLine()) {

                temp = scanner.nextLine().split(" ");
                temp2 = new int[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    temp2[i] = Integer.valueOf(temp[i]);
                    if (temp2[i] % 2 == 1) {
                        writer2.write(temp[i] + " ");
                    } else {
                        writer2.write(0 + " ");
                    }

                }
                writer2.flush();
                writer2.append("\n");
            }
            writer2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
