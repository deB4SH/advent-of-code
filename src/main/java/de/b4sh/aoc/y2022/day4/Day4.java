package de.b4sh.aoc.y2022.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4 {

    public void solveStar1(final File file) throws FileNotFoundException {
        int overlapCounter = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
             List<String[]> ranges = Arrays.stream(scanner.nextLine().split(",")).map(e -> e.split("-")).toList();
             String[] vec1 = ranges.get(0);
             String[] vec2 = ranges.get(1);
             if(Integer.parseInt(vec2[0]) >= Integer.parseInt(vec1[0]) && Integer.parseInt(vec2[1]) <= Integer.parseInt(vec1[1]) ||
                Integer.parseInt(vec1[0]) >= Integer.parseInt(vec2[0]) && Integer.parseInt(vec1[1]) <= Integer.parseInt(vec2[1]) ){
                 overlapCounter++;
             }
        }
        System.out.println(overlapCounter);
    }



    public void solveStar2(final File file) throws FileNotFoundException {
        int overlapCounter = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            List<String[]> ranges = Arrays.stream(scanner.nextLine().split(",")).map(e -> e.split("-")).toList();
            String[] vec1 = ranges.get(0);
            String[] vec2 = ranges.get(1);
            if(Integer.parseInt(vec2[0]) <= Integer.parseInt(vec1[1]) && Integer.parseInt(vec1[0]) <= Integer.parseInt(vec2[1])){
                overlapCounter++;
            }
        }
        System.out.println(overlapCounter);
    }
}
