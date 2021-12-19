package com.pb.kalnaus.hw13;

import java.util.List;

public class Consumer implements Runnable {   // потребитель

    private final List<Integer> buffer;

    public Consumer(List<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("Consumer start");
        synchronized (buffer) {

            while (true) {
                buffer.notifyAll();
                if (buffer.isEmpty()) {
                    System.out.println("Consumer buffer isEmpty...wait");
                    try {
                        buffer.wait(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(buffer.get(0));
                    buffer.remove(0);
                }

            }
        }
    }
}