package pl.bastus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;

public class MyMusic {
    private ArrayList<Song> songList = new ArrayList<>();

    public static void main(String... args) {
        MyMusic music = new MyMusic();
        music.getWork();
    }

    private void getWork() {
        getSongs();
        System.out.print(songList);

        Collections.sort(songList, (Song p1, Song p2) -> p1.getTitle().compareTo(p2.getTitle()));
        Collections.sort(songList, (Song p1, Song p2) -> p1.getArtist().compareTo(p2.getArtist()));
        Collections.sort(songList, (Song p1, Song p2) -> p1.getRate().compareTo(p2.getRate()));
        Collections.sort(songList, (Song p1, Song p2) -> p1.getBpm().compareTo(p2.getBpm()));
        songList.forEach(Song::printSong);

        HashSet<Song> songHashList = new HashSet<>();
        songHashList.addAll(songList);
        songHashList.forEach(System.out::println);
    }

    private void getSongs() {
        try {
            File file;
            BufferedReader reader;
            String line;

            file = new File("y:\\Programowanie\\Tutorials\\ListaPiosenek.txt");
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addSong(String l) {
        String[] elements = l.split("/");
        Song nextSong = new Song(elements[0], elements[1], elements[2], elements[3]);
        songList.add(nextSong);
    }
}