package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCountMerger;

import java.util.HashMap;
import java.util.Map;

public class LetterCountMergerImpl implements LetterCountMerger {
    @Override
    public Map<Character, Long> merge(Map<Character, Long> first, Map<Character, Long> second) {
        if (first == null) {
            return second == null ? new HashMap<>() : second;
        }
        if (second == null) {
            return first;
        }

        Map<Character, Long> result = new HashMap<>(second);
        first.forEach((ch, count) -> result.merge(ch, count, Long::sum));
        return result;
    }
}
