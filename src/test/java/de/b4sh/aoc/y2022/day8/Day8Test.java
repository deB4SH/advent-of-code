package de.b4sh.aoc.y2022.day8;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Day8Test {

    Day8 day;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        day = new Day8();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        day = null;
    }

    @org.junit.jupiter.api.Test
    void solveStar1ExampleInput() {
        day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day8/example-input.txt"));
    }

    @org.junit.jupiter.api.Test
    void solveStar1() {
        day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day8/input.txt"));
    }

    @org.junit.jupiter.api.Test
    void solveStar2() {
        day.solveStar2(new File("src/test/resources/de/b4sh/aoc/y2022/day8/input.txt"));
    }
}