package de.b4sh.aoc.y2022.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Elf {

    private List<Integer> calories;

    public Elf() {
        this.calories = new ArrayList<>();
    }

    public void addCalories(int calories){
        this.calories.add(calories);
    }

    public int getCaloriesAmount(){
        return calories.stream().mapToInt(e -> e).sum();
    }
}
