package com.example.behavioral.iterator;

import java.util.List;

public class PlaylistIterator {
    private List<String> songs;
    private int index = 0;

    public PlaylistIterator(List<String> songs) {
        this.songs = songs;
    }

    public boolean hasNext() {
        return index < songs.size();
    }

    public String next() {
        return songs.get(index++);
    }
}
