package ru.vk;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ru.vk.word.BaseWord;
import ru.vk.word.ErrorWord;

public class FileAnalyzer {
    private FileAnalyzer() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> findError(File file) {
        return findWords(file, new ErrorWord());
    }

    public static List<String> findWords(File file, BaseWord word) {
        List<String> result = new ArrayList<>();
        Path path = file.toPath();
        try (InputStream in = Files.newInputStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (word.isExists(line)) {
                    System.out.println(line);
                    result.add(line);
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return result;
    }

}
