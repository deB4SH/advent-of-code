package de.b4sh.aoc.y2022.day6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {

    Day6 day;
    @BeforeEach
    void setUp() {
        day = new Day6();
    }

    @AfterEach
    void tearDown() {
        day = null;
    }

    @Test
    void solveStar1ExampleInput() throws FileNotFoundException {
        Assertions.assertEquals(7,day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day6/example-input.txt")));
    }

    @Test
    void solveStar1ExampleTwoInput() throws FileNotFoundException {
        Assertions.assertEquals(5,day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day6/example-two.txt")));
    }

    @Test
    void solveStar1ExampleThreeInput() throws FileNotFoundException {
        Assertions.assertEquals(6,day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day6/example-three.txt")));
    }

    @Test
    void solveStar1() throws FileNotFoundException {
        Assertions.assertEquals(1876,day.solveStar1(new File("src/test/resources/de/b4sh/aoc/y2022/day6/input.txt")));
    }

    @Test
    void solveStar2ExampleInput() throws FileNotFoundException {
        Assertions.assertEquals(19,day.solveStar2(new File("src/test/resources/de/b4sh/aoc/y2022/day6/example-input.txt")));
    }

    @Test
    void solveStar2() throws FileNotFoundException {
        Assertions.assertEquals(2202,day.solveStar2(new File("src/test/resources/de/b4sh/aoc/y2022/day6/input.txt")));
    }
}