package com.pb.kalnaus.hw13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Manufacturer implements Runnable {  // производитель

    private final List<Integer> buffer;
    private File file;

    public Manufacturer(List<Integer> buffer) {
        this.buffer = buffer;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void run() {

        synchronized (buffer) {
            try {
                FileReader reader = new FileReader(file.getAbsoluteFile());
                Scanner scanner = new Scanner(reader);

                System.out.println("Manufacturer start");

                while (scanner.hasNextLine()) {
                    buffer.add(Integer.valueOf(scanner.nextInt()));
                    if (buffer.size() == Main.SIZE_BUFFER) {
                        System.out.println("Manufacturer buffer max size...wait. \nConsumer print");
                        buffer.wait();
                    }
                }
                //buffer.wait();
                //System.exit(0);
                /**
                 * //buffer.wait();
                 * //System.exit(0);
                 Если добавить эти строчки, программа распечатает последние элементы файла
                 и завершит работу. Сейчас, в данном случае, Consumer бесконечно ждет Manufacturer и не завершает программу
                 ----------------
                 или второй вариант:
                 в Consumer добавить сщетчик в while(true){...} и по истечению нескольких неудачных попыток считать данные -
                 остановить цикл.
                 */
            } catch (FileNotFoundException | InterruptedException t) {
                t.printStackTrace();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}