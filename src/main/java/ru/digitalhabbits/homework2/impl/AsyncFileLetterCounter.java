package ru.digitalhabbits.homework2.impl;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

import ru.digitalhabbits.homework2.FileLetterCounter;


public class AsyncFileLetterCounter implements FileLetterCounter {

    public static final int THREADS_NUMBER = Runtime.getRuntime().availableProcessors();

    FileReaderImpl reader;

    ForkJoinPool pool;

    @Override
    public Map<Character, Long> count(File input) {
        reader = new FileReaderImpl();
        pool = new ForkJoinPool(THREADS_NUMBER);

        List<String> lines = reader.readLines(input);

        return pool.invoke(new LetterCounterTask(lines, 0, lines.size() - 1));
    }


}
