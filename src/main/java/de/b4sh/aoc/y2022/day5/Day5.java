package de.b4sh.aoc.y2022.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Day5 {
    public void solveStar1(final File file) throws FileNotFoundException {
        List<LinkedList> stacks = new ArrayList<>();
        boolean isStackDone = false;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //read crates of line
            if(!line.isEmpty() && !isStackDone){
                readCrateLine(stacks,line);
            }
            if(line.isEmpty() && !isStackDone){
                isStackDone = true;
                continue;
            }
            if(!isStackDone){
                continue;
            }
            //done reading stacks, interpreting move orders
            String[] command = line.split(" ");
            int amount = Integer.parseInt(command[1]);
            int from = Integer.parseInt(command[3]) - 1;//-1 due to array starts with 0
            int to = Integer.parseInt(command[5]) - 1;//-1 due to array starts with 0
            for(int i = 0; i < amount; i++){
                stacks.get(to).push(stacks.get(from).poll());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (LinkedList q: stacks) {
            sb.append(q.get(0));
        }
        System.out.println(sb.toString());
    }

    public void solveStar2(final File file) throws FileNotFoundException {
        List<LinkedList> stacks = new ArrayList<>();
        boolean isStackDone = false;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //read crates of line
            if(!line.isEmpty() && !isStackDone){
                readCrateLine(stacks,line);
            }
            if(line.isEmpty() && !isStackDone){
                isStackDone = true;
                continue;
            }
            if(!isStackDone){
                continue;
            }
            //done reading stacks, interpreting move orders
            String[] command = line.split(" ");
            int amount = Integer.parseInt(command[1]);
            int from = Integer.parseInt(command[3]) - 1;//-1 due to array starts with 0
            int to = Integer.parseInt(command[5]) - 1;//-1 due to array starts with 0
            Stack tmpStack = new Stack();
            for(int i = 0; i < amount; i++){
                tmpStack.add(stacks.get(from).poll());


            }
            while(!tmpStack.empty()){
                stacks.get(to).push(tmpStack.pop());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (LinkedList q: stacks) {
            sb.append(q.get(0));
        }
        System.out.println(sb.toString());
    }

    public void readCrateLine(final List<LinkedList> stacks, final String line) {
        //check storage length
        int stacksAmount = line.length() / 4;
        //check if all stacks are availables
        if (stacks.size() < stacksAmount) {
            int diff = stacksAmount - stacks.size();
            for (int i = 0; i <= diff; i++) {
                stacks.add(new LinkedList());
            }
        }
        //build stacks
        int stackIndex = 0;
        for (int i = 0; i < line.length(); i = i + 4) {
            String curr = "";
            if (i + 4 > line.length())
                curr = line.substring(i);
            else
                curr = line.substring(i, i + 4);

            String element = curr.substring(1, 2);
            if (element.isBlank() || element.matches("\\d")) {
                stackIndex++;
                continue;
            }
            stacks.get(stackIndex).add(element);
            stackIndex++;
        }
    }
}
