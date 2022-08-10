package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.*;

class LetterCounterImplTest {

    LetterCounterImpl counter = new LetterCounterImpl();

    @Test
    void letter_counter_for_sample_string() {
        assertThat(counter.count("abceeebbacabce")).containsOnly(
                entry('a', 3L),
                entry('b', 4L),
                entry('c', 3L),
                entry('e', 4L)
        );
    }

    @Test
    void letter_counter_for_empty_string() {
        assertThat(counter.count("")).isEmpty();
    }

    @Test
    void letter_counter_for_null() {
        assertThat(counter.count(null)).isEmpty();
    }


}