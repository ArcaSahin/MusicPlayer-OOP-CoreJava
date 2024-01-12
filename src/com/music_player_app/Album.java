package com.music_player_app;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album() {

    }

    public Song findSong(String title) {
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title))
                return checkedSong;
        }
            return null;
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if(index > 0 && index<= this.songs.size()){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have the song with track number " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        for(Song checkedSong: this.songs){
            if(checkedSong.getTitle().equals(title)){
                playList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title + " there is no such song in album");
        return false;
    }
}
