package ru.vk;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriterMy {
    public static void writeStringsToFile(List<String> lst) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("res.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (String string : lst) {
                printWriter.println(string);
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
