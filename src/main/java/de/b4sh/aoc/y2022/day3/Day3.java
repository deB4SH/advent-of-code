package de.b4sh.aoc.y2022.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Day3 {

    private final String pos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public void solveStar1(final File file) throws FileNotFoundException {
        AtomicInteger totalWeight = new AtomicInteger();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String currentRucksack = scanner.nextLine();
            String[] compartments = {currentRucksack.substring(0,currentRucksack.length()/2),currentRucksack.substring(currentRucksack.length()/2)};
            List<String> doubles = Arrays.stream(compartments[0].split("")).filter(elem -> compartments[1].contains(elem)).distinct().toList();
            doubles.forEach(e -> totalWeight.addAndGet(pos.indexOf(e)+1));
        }
        System.out.println(totalWeight.get());
    }
}
