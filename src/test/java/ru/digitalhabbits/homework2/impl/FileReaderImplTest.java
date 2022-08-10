package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static com.google.common.io.Resources.getResource;

class FileReaderImplTest {

    File file = new File(getResource("test.txt").getPath());

    FileReaderImpl reader = new FileReaderImpl();

    @Test
    void file_reader_should_return_predicted_size_and_content() {
        List<String> lines = reader.readLines(file);
        Assertions.assertEquals(lines.size(), 1000);
        Assertions.assertEquals(lines.get(999), "fbaeddfbcaeafceb");
        Assertions.assertEquals(lines.get(0), "cdccfdbfeadebaee");
    }
}