package de.b4sh.aoc.y2022.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Node<T extends DataDescriptor> {
    private List<Node<T>> children;
    private Node<T> parent;
    private T data;
    private String name;

    public Node() { //root constructor
        this.children = new ArrayList<>();
        this.parent = null;
        this.data = null;
        this.name = null;
    }

    public Node(Node<T> parent, String name, T data) { //leaf constructor
        this.children = new ArrayList<>();
        this.parent = parent;
        this.data = data;
        this.name = name;
    }

    public void addChilden(Node<T> child){
        this.children.add(child);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public List<Node<T>> getAllDirectoryChilden(){
        List<Node<T>> tmpList = new ArrayList<>();
        //add direct ones first
        tmpList.addAll(children.stream().filter(Node::isDirectory).toList());
        //check children
        children.stream().filter(Node::isDirectory).forEach(d -> tmpList.addAll(d.getAllDirectoryChilden()));
        return tmpList;

    }

    public Node<T> getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public T getData() {
        return data;
    }

    public boolean isRootNode(){
        return (this.parent == null);
    }

    public boolean isDirectory(){
        return (this.data == null);
    }
    public boolean isFile(){
        return (this.children.size() == 0 && this.data != null);
    }

    public int getFileSizeOfFiles(){
        AtomicInteger weight = new AtomicInteger(0);
        //add all direct files
        children.stream().filter(Node::isFile).forEach(e -> weight.addAndGet(e.getData().getFileSize()));
        //check for children folder
        children.stream().filter(Node::isDirectory).forEach(d -> weight.addAndGet(d.getFileSizeOfFiles()));
        return weight.get();
    }

}
