package ru.digitalhabbits.homework2.impl;

import com.google.common.io.Files;
import ru.digitalhabbits.homework2.FileReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readLines(File file) {
        try {
            return Files.readLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
