package de.b4sh.aoc.y2022.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void solveStar2(final File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> rucksacks = new ArrayList<>();
        int count = 0;
        AtomicInteger weight = new AtomicInteger(0);
        while (scanner.hasNextLine()){
            rucksacks.add(scanner.nextLine());
            count++;
            if(count != 3){
                continue;
            }
            //check for doubles
            Arrays.stream(rucksacks.get(0).split("")).filter(elem -> rucksacks.get(1).contains(elem) && rucksacks.get(2).contains(elem)).distinct().toList().forEach(e -> weight.addAndGet(pos.indexOf(e)+1));
            //clear
            rucksacks.clear();
            count = 0;
        }
        System.out.println(weight.get());
    }
}
