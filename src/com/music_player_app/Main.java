package com.music_player_app;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("WorldTour", "AC/DC");

        album.addSong("TNT", 4.5);
        album.addSong("Highway to hell", 3.5);
        album.addSong("ThunderStruck", 5.0);
        albums.add(album);

        album = new Album("EuropeTour", "Eminem");
        album.addSong("Rap God", 5.5);
        album.addSong("Not Afraid", 4.5);
        album.addSong("Lose Yourself", 4.0);
        albums.add(album);

        LinkedList<Song> playList1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT", playList1);
        albums.get(0).addToPlayList("Highway to Hell", playList1);
        albums.get(1).addToPlayList("Rap God", playList1);
        albums.get(1).addToPlayList("Lose Yourself", playList1);

        play(playList1);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This playlist has no song !");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("PlayList has been closed !");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("no song available, reached to the end of the list !");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("you are at the first song !");
                        forward = false;
                    }
                    break;

                case 3:
                    printList(playList);
                    break;

                case 4:
                    printMenu();
                    break;

                case 5:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing :" + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious())
                                System.out.println("Now playing: " + listIterator.previous().toString());
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to list of all songs\n" +
                "4 - print all available options\n" +
                "5 - delete current song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-------------");
    }
}