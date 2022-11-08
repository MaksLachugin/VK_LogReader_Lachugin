package ru.vk;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import ru.vk.word.*;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }
        List<File> files = FileFinder.getTextFiles(args[0]);
        List<String> list = new LinkedList<>();
        BaseWord bw;
        switch (Integer.parseInt(args[1])) {
            case 1:
                bw = new AnyWord(args[2]);
                break;
            case 2:
                bw = new RegexWord(args[2]);
                break;
            default:
                bw = new ErrorWord();
                break;
        }
        for (File file : files) {
            System.out.println(file.getPath());
            list.addAll(FileAnalyzer.findWords(file, bw));

        }

        FileWriterMy.writeStringsToFile(list);
    }
}
