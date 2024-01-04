package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws IOException {
        File dir = Paths.get("texts/").toFile();
        Collection<File> files = FileUtils.listFiles(dir, null, true);
        int count = 0;
        for (File file : files) {
            int countOfFile = 0;
            String s = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            for (char c : s.toCharArray()) {
                if (c >= '\u4e00' && c <= '\u9fa5') {
                    countOfFile ++;
                }
            }
            System.out.println("文件" + file.getPath() + "的汉字数是" + countOfFile);
            count += countOfFile;
        }
        System.out.println("总汉字数是" + count);
    }
}