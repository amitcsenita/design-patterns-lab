package com.example.behavioral.iterator;

public class Demo {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Song1");
        playlist.addSong("Song2");
        PlaylistIterator iterator = playlist.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
