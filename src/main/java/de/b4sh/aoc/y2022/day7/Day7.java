package de.b4sh.aoc.y2022.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Day7 {

    public int solveStar1(final File file) throws FileNotFoundException {
        final Node<DataDescriptor> parentNode = new Node<>(); //also root node
        readFile(new Scanner(file),parentNode);
        List<Node<DataDescriptor>> directoryChilden = parentNode.getAllDirectoryChilden();
        return directoryChilden.stream().filter(d -> d.getFileSizeOfFiles() < 100000).mapToInt(Node::getFileSizeOfFiles).sum();
    }

    public int solveStar2(final File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

        }

        return -1;
    }

    private void readFile(Scanner scanner, Node<DataDescriptor> parentNode){
        Node<DataDescriptor> currentNode = parentNode;
        Operation op = Operation.NONE;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] commandParts = line.split(" ");
            if(line.startsWith("$")){ //check command type
                op = interpretCommand(commandParts);
            }
            if(op == Operation.CD){
                currentNode = interpretChangeDir(currentNode,commandParts);
            } else if (op == Operation.LS && !line.startsWith("$")) {
                currentNode = interpretListDir(currentNode, commandParts);
            }
        }
    }

    private Operation interpretCommand(final String[] commandParts){
        return switch (commandParts[1]) {
            case "cd" -> Operation.CD;
            case "ls" -> Operation.LS;
            default -> Operation.NONE;
        };
    }

    private Node<DataDescriptor> interpretListDir(final Node<DataDescriptor> currentNode, final String[] commandParts){
        if(commandParts[0].equals("dir")){ //interpret dir and open new dir leaf
            Node<DataDescriptor> newDir = new Node<>(currentNode,commandParts[1],null);
            currentNode.addChilden(newDir);
            return currentNode;
        }
        //must be a file
        Node<DataDescriptor> newFile = new Node<>(currentNode,commandParts[1],new DataDescriptor(Integer.parseInt(commandParts[0])));
        currentNode.addChilden(newFile);
        return currentNode;
    }

    private Node<DataDescriptor> interpretChangeDir(final Node<DataDescriptor> currentNode, final String[] commandParts){
        if(commandParts[2].equals("/")) {//navigate to root node
            if (currentNode.isRootNode()) {
                return currentNode;
            }
            Node<DataDescriptor> tmp = currentNode;
            while (!tmp.isRootNode()) {
                tmp = tmp.getParent();
            }
            return tmp;
        } else if(commandParts[2].equals("..")){ //navigate one dir up
            if(currentNode.isRootNode()){
                return currentNode;
            }
            return currentNode.getParent();
        }else{
            //check if dir is available and return as currentNode
            return currentNode.getChildren().stream().filter(e -> e.getName().equals(commandParts[2]) && e.isDirectory()).findFirst().orElse(null);
        }
    }
}
