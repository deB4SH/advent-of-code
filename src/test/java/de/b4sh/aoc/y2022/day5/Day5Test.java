package de.b4sh.aoc.y2022.day5;

import de.b4sh.aoc.y2022.day4.Day4;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class Day5Test {
    Day5 day;
    @BeforeEach
    void setUp() {
        day = new Day5();
    }

    @AfterEach
    void tearDown() {
        day = null;
    }

    @Test
    void solveStar1() throws FileNotFoundException {
        day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day5/input.txt"));
    }

    @Test
    void solveStar2() throws FileNotFoundException {
        day.solveStar2(new File("src/test/resources/de/b4sh/aoc/y2022/day5/input.txt"));
    }
}