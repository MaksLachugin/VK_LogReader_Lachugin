package ru.vk;

import java.io.File;
import java.util.List;

import ru.vk.word.AnyWord;
import ru.vk.word.RegexWord;

public class App {
    public static void main(String[] args) throws Exception {
        List<File> files = FileFinder.getTextFiles(args[0]);
        for (File file : files) {
            System.out.println(file.getPath());
            FileAnalyzer.findWords(file, new RegexWord("Error.*"));

        }
    }
}
