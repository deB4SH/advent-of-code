package de.b4sh.aoc.y2022.day4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    Day4 day;
    @BeforeEach
    void setUp() {
        day = new Day4();
    }

    @AfterEach
    void tearDown() {
        day = null;
    }

    @Test
    void solveStar1() throws FileNotFoundException {
        day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day4/input.txt"));
    }

    @Test
    void solveStar2() throws FileNotFoundException {
        day.solveStar2(new File("src/test/resources/de/b4sh/aoc/y2022/day4/input.txt"));
    }
}