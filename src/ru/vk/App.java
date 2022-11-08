package ru.vk;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import ru.vk.file.FileAnalyzer;
import ru.vk.file.FileFinder;
import ru.vk.file.FileWriterMy;
import ru.vk.word.*;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }
        // поиск файлов для чтения
        List<File> files = FileFinder.getTextFiles(args[0]);
        List<String> list = new LinkedList<>();
        // выбор способа поиска
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
        // Поиск в файлах
        for (File file : files) {
            System.out.println(file.getPath());
            list.addAll(FileAnalyzer.findWords(file, bw));

        }
        // Запись в файл
        FileWriterMy.writeStringsToFile(list);
    }
}
