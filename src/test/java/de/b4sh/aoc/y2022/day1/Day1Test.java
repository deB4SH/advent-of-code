package de.b4sh.aoc.y2022.day1;

import de.b4sh.aoc.helper.FileReader;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {
    private Day1 day1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws FileNotFoundException {
        day1 = new Day1();
        day1.parseElfs(new File("src/test/resources/de/b4sh/aoc/y2022/day1/input.txt"));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        day1 = null;
    }

    @org.junit.jupiter.api.Test
    void solveStar1(){
        day1.solveStar1();
    }

    @Test
    void solveStar2() {
        day1.solveStar2();
    }
}