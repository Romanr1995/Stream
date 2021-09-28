package com.company;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MusicalBand {

    String name;
    String country;
    Set<String> musicians;
    List<AlbumMusicial> albums;

    public MusicalBand(String name, String country, Set<String> musicians, List<AlbumMusicial> albums) {
        this.name = name;
        this.country = country;
        this.musicians = musicians;
        this.albums = albums;
    }


    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Set<String> getMusicians() {
        return musicians;
    }

    public List<AlbumMusicial> getAlbums() {
        return albums;
    }

    @Override
    public String toString() {
        return "MusicalBand{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", musicians=" + musicians +
                ", albums=" + albums +
                '}';
    }


    public static boolean isRichardBlackmore(MusicalBand musicalBand) {
        Set<String> musicians = musicalBand.getMusicians();
        for (String musician : musicians) {
            if (musician.equals("Richard Blackmore")) {
                return true;
            }
        }
        return false;
    }

    public static List<String> albumName(MusicalBand musicalBand) {
        List<AlbumMusicial> albums = musicalBand.getAlbums();

        List<String> album = new ArrayList<>();

        for (AlbumMusicial albumMusicial : albums) {
            album.add(albumMusicial.getName());
        }
        return album;
    }

    public static void main(String[] args) {

        AlbumMusicial shadesOfDeepPurple = new AlbumMusicial("Shades of Deep Purple ",
                LocalDate.of(1968, 7, 1),
                Arrays.asList("And the Address", "Hush", "Prelude: Happiness/I’m So Glad", "Mandrake Root"));

        AlbumMusicial theBookOfTaliesyn = new AlbumMusicial("The Book of Taliesyn",
                LocalDate.of(1969, 6, 15),
                Arrays.asList("Wring That Neck", "Kentucky Woman", "Anthem", "River Deep, Mountain High"));

        MusicalBand deepPurple = new MusicalBand("Deep Purple", "Great Britain",
                Set.of(" Ian Anderson Paice", "Roderic Evans", "Nicholas John Simper", "Richard Blackmore"),
                Arrays.asList(shadesOfDeepPurple, theBookOfTaliesyn));

        AlbumMusicial rising = new AlbumMusicial("Rising",
                LocalDate.of(1976, 5, 17),
                Arrays.asList("Tarot Woman", "Starstruck", "Run with the Wolf", "Stargazer"));
        AlbumMusicial longLiveRockRoll = new AlbumMusicial("Long Live Rock’n’Roll",
                LocalDate.of(1978, 4, 15),
                Arrays.asList("Long Live Rock 'n' Roll", "Lady of the Lake", "Gates of Babylon"));

        MusicalBand rainbow = new MusicalBand("Rainbow ", "Great Britain",
                Set.of("Richard Blackmore", "Ronald James Padavona", "Craig Gruber", "Gary Driscoll"),
                Arrays.asList(rising, longLiveRockRoll));

        AlbumMusicial forYourLove = new AlbumMusicial("For Your Love",
                LocalDate.of(1965, 8, 11),
                Arrays.asList("For Your Love", "I’m Not Talking", "Got to Hurry"));

        AlbumMusicial havingRaveUpWithTheYardbirds = new AlbumMusicial("Having a Rave Up with The Yardbirds",
                LocalDate.of(1965, 11, 20),
                Arrays.asList("Still I'm Sad", "Respectable", "Smokestack Lightning"));

        MusicalBand theYardbirds = new MusicalBand("The Yardbirds", "Great Britain",
                Set.of("Keith Relf", "Chris Dreja", "Anthony Topham"),
                Arrays.asList(forYourLove, havingRaveUpWithTheYardbirds));

        List<MusicalBand> bands = Arrays.asList(deepPurple, rainbow, theYardbirds);

        List<String> richard_blackmore = bands.stream()
                .filter(MusicalBand::isRichardBlackmore)
                .map(MusicalBand::albumName)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(richard_blackmore);
    }
}

