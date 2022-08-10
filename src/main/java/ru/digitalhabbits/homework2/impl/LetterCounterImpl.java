package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCounter;

import java.util.HashMap;
import java.util.Map;

public class LetterCounterImpl implements LetterCounter {
    @Override
    public Map<Character, Long> count(String input) {
        Map<Character, Long> resultMap = new HashMap<>();

        if (input == null) {
            return resultMap;
        }
        input.chars()
                .forEach(ch -> resultMap.merge((char) ch, 1L, (prev, newValue) -> prev + 1));
        return resultMap;
    }
}
