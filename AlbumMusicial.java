package com.company;

import java.time.LocalDate;
import java.util.List;

public class AlbumMusicial {
    private String name;
    private LocalDate releaseDate;
    private List<String> tracks;

    public AlbumMusicial(String name, LocalDate releaseDate, List<String> tracks) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.tracks = tracks;
    }

    public String getName() {
        return name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public List<String> getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return "Musicalalbum{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", tracks=" + tracks +
                '}';
    }

}
