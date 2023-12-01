package de.b4sh.aoc.y2023.day1;

import de.b4sh.aoc.helper.FileReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


class Day1Test {

    Day1 unit = new Day1();

    @Test
    void solveExampleStar1() {
        FileReader fr = new FileReader();
        List<String> lines = fr.readLinesOfFile(new File("src/test/resources/de/b4sh/aoc/y2023/day1/exampleInput.txt"));
        unit.solveStar1(lines);
    }

    @Test
    void solveStar1() {
        FileReader fr = new FileReader();
        List<String> lines = fr.readLinesOfFile(new File("src/test/resources/de/b4sh/aoc/y2023/day1/input.txt"));
        unit.solveStar1(lines);
    }

    @Test
    void solveExampleStar2() {
        FileReader fr = new FileReader();
        List<String> lines = fr.readLinesOfFile(new File("src/test/resources/de/b4sh/aoc/y2023/day1/exampleInputStar2.txt"));
        unit.solveStar2(lines);
    }

    @Test
    void solveExampleSamplesStar2() {
        FileReader fr = new FileReader();
        List<String> lines = fr.readLinesOfFile(new File("src/test/resources/de/b4sh/aoc/y2023/day1/samples.txt"));
        unit.solveStar2(lines);
    }

    @Test
    void solveStar2() {
        FileReader fr = new FileReader();
        List<String> lines = fr.readLinesOfFile(new File("src/test/resources/de/b4sh/aoc/y2023/day1/input.txt"));
        unit.solveStar2(lines);
    }
}