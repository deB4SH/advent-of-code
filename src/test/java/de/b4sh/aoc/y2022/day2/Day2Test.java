package de.b4sh.aoc.y2022.day2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    Day2 day2;

    @BeforeEach
    void setUp() {
        day2 = new Day2();
    }

    @AfterEach
    void tearDown() {
        day2 = null;
    }

    @Test
    void solveStar1() throws FileNotFoundException {
        day2.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day2/input.txt"));
    }

    @Test
    void solveStar2() throws FileNotFoundException {
        day2.solveStar2(new File("src/test/resources/de/b4sh/aoc/y2022/day2/input.txt"));
    }
}