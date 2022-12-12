package de.b4sh.aoc.y2022.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Day8 {

    public int solveStar1(final File file) throws FileNotFoundException {
        AtomicInteger visibleTreeCount = new AtomicInteger(0);
        int[][] treeArray = buildTreeArray(file);
        int height = treeArray.length;
        int width = treeArray[0].length;
        //add outer edges to visible tree count
        visibleTreeCount.addAndGet(2 * height); //add height two times
        visibleTreeCount.addAndGet(2 * (width - 2)); //add two times width , remove already containing trees from height
        //check for middle trees
        for(int i = 1; i < height-1; i++){
            for (int j = 1; j < width-1; j++){

            }
        }

        return 0;
    }

    public int solveStar2(final File file){

        return 0;
    }

    private int[][] buildTreeArray(final File file) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            lines.add(scanner.next());
        }
        int height = lines.size();
        int width = lines.get(0).length();
        //fill array
        int[][] arr = new int[height][width];
        for(int i = 0; i < lines.size(); i++){
            String[] vals = lines.get(i).split("");
            for(int j = 0; j < vals.length; j++){
                arr[i][j] = Integer.parseInt(vals[j]);
            }
        }
        return arr;
    }
}
