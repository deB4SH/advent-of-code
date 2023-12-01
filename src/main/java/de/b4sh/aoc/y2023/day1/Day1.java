package de.b4sh.aoc.y2023.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Challenge: https://adventofcode.com/2023/day/1
 */
public class Day1 {

    private final Logger log = Logger.getLogger(Day1.class.getName());
    private Pattern numberPattern = Pattern.compile("\\d+");
    private Pattern star2Pattern = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|\\d)");

    public Day1() {

    }

    public void solveStar1(List<String> lines){
        AtomicInteger sum = new AtomicInteger(0);
        lines.forEach(line -> {
            List<String> numbers = Arrays.stream(line.split("\\D")).filter(s -> !s.isEmpty()).toList();
            char num1 = numbers.get(0).charAt(0);
            char num2 = numbers.get(numbers.size()-1).charAt(numbers.get(numbers.size()-1).length()-1);
            sum.addAndGet(Integer.parseInt(""+num1+num2));
        });
        log.log(Level.INFO, String.format("Result for Star 1: %s",sum.get()));
    }

    public void solveStar2(List<String> lines){
        //Regex: (one|two|three|four|five|six|seven|eight|nine|\d)
        AtomicInteger sum = new AtomicInteger(0);
        lines.forEach(line -> {
            List<String> numbers = new ArrayList<>();
            MatcherStream.find(star2Pattern,line).forEach(numbers::add);
            int num1 = numberParser(numbers.get(0));
            int num2 = numberParser(numbers.get(numbers.size()-1));
            int added = Integer.parseInt(""+num1+num2);
            sum.addAndGet(added);
        });
        log.log(Level.INFO, String.format("Result for Star 2: %s",sum.get()));
    }

    private int numberParser(String s){
        if(s.matches("\\d")){ //seems to be a number
            return Integer.parseInt(s);
        }
        switch (s){
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
        }
        return 0;
    }

    public class MatcherStream {
        private MatcherStream() {}

        public static Stream<String> find(Pattern pattern, CharSequence input) {
            return findMatches(pattern, input).map(MatchResult::group);
        }

        public static Stream<MatchResult> findMatches(
                Pattern pattern, CharSequence input) {
            Matcher matcher = pattern.matcher(input);

            Spliterator<MatchResult> spliterator = new Spliterators.AbstractSpliterator<MatchResult>(
                    Long.MAX_VALUE, Spliterator.ORDERED|Spliterator.NONNULL) {
                @Override
                public boolean tryAdvance(Consumer<? super MatchResult> action) {
                    if(!matcher.find()) return false;
                    action.accept(matcher.toMatchResult());
                    return true;
                }};

            return StreamSupport.stream(spliterator, false);
        }
    }

}
