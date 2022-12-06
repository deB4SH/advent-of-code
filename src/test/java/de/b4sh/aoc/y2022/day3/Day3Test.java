package de.b4sh.aoc.y2022.day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class Day3Test {

    Day3 day;

    @BeforeEach
    void setUp() {
        day = new Day3();
    }

    @AfterEach
    void tearDown() {
        day = null;
    }

    @Test
    void solveStar1() throws FileNotFoundException {
        day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day3/input.txt"));
    }

    @Test
    void solveStar2() throws FileNotFoundException {
        day.solveStar2(new File("src/test/resources/de/b4sh/aoc/y2022/day3/input.txt"));
    }
}