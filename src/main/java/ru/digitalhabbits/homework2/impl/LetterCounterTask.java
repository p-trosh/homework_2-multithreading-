package ru.digitalhabbits.homework2.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

import static ru.digitalhabbits.homework2.impl.AsyncFileLetterCounter.THREADS_NUMBER;

public class LetterCounterTask extends RecursiveTask<Map<Character, Long>> {

    private final int left;
    private final int right;
    private final List<String> lines;
    private final LetterCounterImpl counter;
    private final LetterCountMergerImpl merger;

    public LetterCounterTask(List<String> lines, int left, int right) {
        this.left = left;
        this.right = right;
        this.lines = lines;
        counter = new LetterCounterImpl();
        merger = new LetterCountMergerImpl();
    }

    @Override
    protected Map<Character, Long> compute() {
        if (right - left <= lines.size() / THREADS_NUMBER) {
            return computeDirectly();
        } else {
            return computeRecursive();
        }
    }

    protected Map<Character, Long> computeDirectly() {
        String concatString = lines.stream()
                .skip(left)
                .limit(right - left + 1)
                .collect(Collectors.joining());
        return counter.count(concatString);
    }

    protected Map<Character, Long> computeRecursive() {
        int middle = (right + left) / 2;

        LetterCounterTask firstHalf = new LetterCounterTask(lines, left, middle);
        LetterCounterTask secondHalf = new LetterCounterTask(lines, middle + 1, right);

        firstHalf.fork();
        secondHalf.fork();

        return merger.merge(firstHalf.join(), secondHalf.join());
    }
}
