package com.company;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MusicalAlbum {
    private String name;
    private String musician;
    private LocalDate date;

    public MusicalAlbum(String name, String musician, LocalDate year) {
        this.name = name;
        this.musician = musician;
        this.date = year;
    }

    public String getName() {
        return name;
    }

    public String getMusician() {
        return musician;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ",musician: " + musician +
                ",year: " + date;
    }

    public static void main(String[] args) {
        MusicalAlbum musicalAlbum1 = new MusicalAlbum("HTTH", "FGEe",
                LocalDate.of(1995, 12, 20));
        MusicalAlbum musicalAlbum2 = new MusicalAlbum("HgrgrTTH", "Queen",
                LocalDate.of(1993, 9, 15));
        MusicalAlbum musicalAlbum3 = new MusicalAlbum("fef", "FGfeEe",
                LocalDate.of(1960, 11, 10));
        MusicalAlbum musicalAlbum4 = new MusicalAlbum("Ffd", "Queen",
                LocalDate.of(1976, 2, 29));
        MusicalAlbum musicalAlbum5 = new MusicalAlbum("Abcd", "Queen",
                LocalDate.of(1984, 11, 1));
        MusicalAlbum musicalAlbum6 = new MusicalAlbum("Argh", "Beatles",
                LocalDate.of(1976, 11, 3));

        List<MusicalAlbum> list = Arrays.asList(musicalAlbum1, musicalAlbum2, musicalAlbum3, musicalAlbum4,
                musicalAlbum5, musicalAlbum6);

        List<MusicalAlbum> result1 = list.stream()
                .filter(musicalAlbum -> musicalAlbum.musician.equals("Queen")
                        && musicalAlbum.date.isAfter(LocalDate.of(1980, 1, 1)))
                .collect(Collectors.toList());

        List<String> result2 = list.stream()
                .filter(MusicalAlbum::isMusicalQueen)
                .map(MusicalAlbum::getName)
                .collect(Collectors.toList());

        Map<Integer, List<MusicalAlbum>> mapResult1 = list.stream()
                .collect(
                        Collectors.groupingBy(
                                musicalAlbum -> musicalAlbum.getDate().getYear()
                        )
                );
//Map<Integer,List<String>>-год -> список названия альбомов
        Map<Integer, List<String>> mapResult2 = list.stream()
                .collect(
                        Collectors.groupingBy(
                                musicalAlbum -> musicalAlbum.getDate().getYear(),
                                Collectors.mapping(musicalAlbum -> musicalAlbum.getName(), Collectors.toList()))
                );
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(mapResult1);
        System.out.println(mapResult2);
    }

    public static boolean isMusicalQueen(MusicalAlbum musicalAlbum) {
        return musicalAlbum.musician.equals("Queen")
                && musicalAlbum.date.isAfter(LocalDate.of(1980, 1, 1));
    }
}

