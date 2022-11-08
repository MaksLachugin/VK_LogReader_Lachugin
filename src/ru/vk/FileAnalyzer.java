package ru.vk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
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
        ProgressBar pb = new ProgressBar(getLineCountByReader(file.getPath()));
        List<String> result = new ArrayList<>();
        Path path = file.toPath();
        try (InputStream in = Files.newInputStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            LineNumberReader lnr = new LineNumberReader(reader);
            while ((line = lnr.readLine()) != null) {
                pb.now(lnr.getLineNumber());
                if (word.isExists(line)) {
                    result.add(line);
                }
            }
            pb.end();
        } catch (IOException x) {
            System.err.println(x);
        }
        return result;
    }

    private static long getLineCountByReader(String fileName) {
        try (LineNumberReader lnr = new LineNumberReader(new BufferedReader(new FileReader(fileName)))) {
            while (lnr.readLine() != null)
                ;
            return lnr.getLineNumber();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
