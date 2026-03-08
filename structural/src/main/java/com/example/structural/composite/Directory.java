package com.example.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private String name;
    private List<FileSystem> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystem component) {
        children.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystem child : children) {
            child.showDetails();
        }
    }
}
