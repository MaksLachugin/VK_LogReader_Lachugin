package ru.vk;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileFinder {

    private FileFinder() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isText(File file) {
        return file.getName().endsWith(".txt") || file.getName().endsWith(".log");

    }

    public static List<File> getFiles(String path) {
        return getFiles(new File(path));
    }

    public static List<File> getFiles(File file) {

        if (file == null || !file.exists()) {
            return new LinkedList<>();
        }
        if (file.isFile()) {
            return Arrays.asList(file);
        } else {
            List<File> lst = new LinkedList<>();
            for (File element : file.listFiles()) {
                if (file.isFile())
                    lst.add(element);
                else {
                    lst.addAll(getFiles(element));
                }
            }
            return lst;
        }

    }

    public static List<File> getTextFiles(String path) {
        List<File> files = getFiles(path);
        List<File> result = new LinkedList<>();
        for (File file : files) {
            if (isText(file)) {
                result.add(file);
            }
        }
        return result;

    }
}