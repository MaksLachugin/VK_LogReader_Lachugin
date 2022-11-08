package ru.vk;

import java.io.File;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(args[0]);
        List<File> files = FileFinder.getTextFiles(args[0]);
        for (File file : files) {
            System.out.print(file.getPath());
        }
    }
}
