package ru.levelup.lesson5;

import ru.levelup.lesson5.dto.Movie;

import java.util.List;

public interface MovieFinder {

    void populate();

    List<Movie> getFilms();
}
