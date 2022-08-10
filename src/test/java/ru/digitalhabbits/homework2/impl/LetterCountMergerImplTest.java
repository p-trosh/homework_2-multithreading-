package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.*;

class LetterCountMergerImplTest {

    LetterCountMergerImpl merger = new LetterCountMergerImpl();

    Map<Character, Long> map1 = Map.of(
            'a', 1L,
            'b', 2L,
            'c', 3L,
            'd', 4L
    );

    Map<Character, Long> map2 = Map.of(
            'a', 3L,
            'b', 4L,
            'c', 3L,
            'e', 4L
    );

    Map<Character, Long> emptyMap = new HashMap<>();

    @Test
    void test_merge_two_nonempty_maps() {
        Map<Character, Long> actual = merger.merge(map1, map2);

        assertThat(actual).containsOnly(
                entry('a', 4L),
                entry('b', 6L),
                entry('c', 6L),
                entry('d', 4L),
                entry('e', 4L)
        );
    }

    @Test
    void test_merge_one_empty_map() {
        Map<Character, Long> actual = merger.merge(emptyMap, map2);

        assertThat(actual).containsOnly(
                entry('a', 3L),
                entry('b', 4L),
                entry('c', 3L),
                entry('e', 4L)
        );
    }

    @Test
    void test_merge_one_null_map() {
        Map<Character, Long> actual = merger.merge(null, map2);

        assertThat(actual).containsOnly(
                entry('a', 3L),
                entry('b', 4L),
                entry('c', 3L),
                entry('e', 4L)
        );
    }

    @Test
    void test_merge_two_null_maps() {
        Map<Character, Long> actual = merger.merge(null, null);

        assertThat(actual).isEmpty();
    }


}