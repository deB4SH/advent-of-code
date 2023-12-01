package de.b4sh.aoc.y2022.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

    public Day2() {
    }

    public void solveStar1(final File file) throws FileNotFoundException {
        int count = 0;
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String roundLine = scanner.nextLine();
            if(roundLine.isEmpty())
                continue;

            String[] plays = roundLine.split(" ");
            count += RockPaperScissorsRuleset.calculateRound(plays[0],plays[1]);
        }
        System.out.println(count);
        
    }

    public void solveStar2(final File file) throws FileNotFoundException {
        int count = 0;
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String roundLine = scanner.nextLine();
            if(roundLine.isEmpty())
                continue;

            String[] plays = roundLine.split(" ");
            String playerChoice = switch (plays[1]) {
                case "X" -> RockPaperScissorsRuleset.getType(plays[0]).getBeats().get(0);
                case "Z" -> RockPaperScissorsRuleset.getType(plays[0]).getLoses().get(0);
                default -> plays[0];
            };
            count += RockPaperScissorsRuleset.calculateRound(plays[0],playerChoice);
        }
        System.out.println(count);
    }
}
