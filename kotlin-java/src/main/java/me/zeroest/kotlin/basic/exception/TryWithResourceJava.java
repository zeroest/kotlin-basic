package me.zeroest.kotlin.basic.exception;

import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourceJava {
    public static void main(String[] args) {
        // AutoCloseable 인터페이스를 구현
        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("Hello Java");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
