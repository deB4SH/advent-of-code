package de.b4sh.aoc.y2022.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day1 {

    final List<Elf> elfList;

    public Day1() {
        elfList = new ArrayList<>();
    }

    public void parseElfs(final File file) throws FileNotFoundException {
        Elf elf = new Elf();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.isEmpty()){
                elfList.add(elf);
                elf = new Elf();
                continue;
            }
            elf.addCalories(Integer.parseInt(line));
        }
    }

    public void solveStar1(){
        Elf highestCalElf = elfList.stream().sorted(Comparator.comparingInt(Elf::getCaloriesAmount).reversed()).toList().get(0);
        System.out.println(highestCalElf.getCaloriesAmount());
    }

    public void solveStar2(){
        List<Elf> elfs = elfList.stream().sorted(Comparator.comparingInt(Elf::getCaloriesAmount).reversed()).toList().subList(0,3);
        System.out.println(elfs.stream().mapToInt(Elf::getCaloriesAmount).sum());
    }

}
