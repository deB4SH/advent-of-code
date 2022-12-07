package de.b4sh.aoc.y2022.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6 {
    public int solveStar1(final File file) throws FileNotFoundException {
        int packageSize = 4;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split("");
            for(int i = 1; i < split.length-packageSize; i++){
                if(!checkStringForDuplicates(line.substring(i,i+packageSize))){
                    return i+packageSize;
                }
            }
        }
        return -1;
    }

    private boolean checkStringForDuplicates(final String value){
        for (int i = 0; i < value.length(); i++) {
            for (int j = i + 1; j < value.length(); j++) {
                if (value.charAt(i) == value.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int solveStar2(final File file) throws FileNotFoundException {
        int packageSize = 14;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split("");
            for(int i = 1; i < split.length-packageSize; i++){
                if(!checkStringForDuplicates(line.substring(i,i+packageSize))){
                    return i+packageSize;
                }
            }
        }
        return -1;
    }
}
