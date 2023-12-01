package de.b4sh.aoc.y2023.day1;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Challenge: https://adventofcode.com/2023/day/1
 */
public class Day1 {

    private final Logger log = Logger.getLogger(Day1.class.getName());
    final Map<String, String> replacerMap = Map.of( //keep distances to possible following numbers
            "one", "o1e",
            "two", "t2o",
            "three", "t3e",
            "four", "f4r",
            "five", "f5e",
            "six", "s6x",
            "seven", "s7n",
            "eight", "e8t",
            "nine", "n9e"
    );

    public void solveStar1(List<String> lines){
        Integer result = lines.stream().map(this::stripChars).filter(s -> !s.isEmpty()).map(this::getFirstAndLastValue).mapToInt(Integer::parseInt).sum();
        log.log(Level.INFO, String.format("Result for Star 1: %s",result));
    }

    public void solveStar2(List<String> lines){
        Integer result = lines.stream().map(this::replaceNumberStrings).map(this::stripChars).filter(s -> !s.isEmpty()).map(this::getFirstAndLastValue).mapToInt(Integer::parseInt).sum();
        log.log(Level.INFO, String.format("Result for Star 2: %s",result));
    }

    private String replaceNumberStrings(String input){
        for(Map.Entry<String,String> entry: replacerMap.entrySet()){
            input = input.replaceAll(entry.getKey(), entry.getValue());
        }
        return input;
    }

    private String stripChars(String input){
        return input.replaceAll("[a-z]","");
    }

    private String getFirstAndLastValue(String input){
        return "" + input.charAt(0) + input.charAt(input.length()-1);
    }
}
