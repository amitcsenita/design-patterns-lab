package com.example.structural.composite;

public class Demo {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        File file1 = new File("file1.txt");
        Directory subDir = new Directory("subdir");
        subDir.add(new File("file2.txt"));
        root.add(file1);
        root.add(subDir);
        root.showDetails();
    }
}
