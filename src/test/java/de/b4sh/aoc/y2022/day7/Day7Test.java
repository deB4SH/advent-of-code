package de.b4sh.aoc.y2022.day7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

    Day7 day;

    @BeforeEach
    void setUp() {
        day = new Day7();
    }

    @AfterEach
    void tearDown() {
        day = null;
    }

    @Test
    void solveStar1WithExampleInput() throws FileNotFoundException {
        Assertions.assertEquals(95437,day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day7/example-input.txt")));
    }

    @Test
    void solveStar1() throws FileNotFoundException {
        Assertions.assertEquals(1449447,day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day7/input.txt")));
    }

    @Test
    void solveStar2() throws FileNotFoundException {
        Assertions.assertEquals(8679207,day.solveStar2(new File("src/test/resources/de/b4sh/aoc/y2022/day7/input.txt")));
    }
}