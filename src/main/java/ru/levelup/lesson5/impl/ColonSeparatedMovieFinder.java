package ru.levelup.lesson5.impl;

import org.springframework.stereotype.Component;
import ru.levelup.lesson5.MovieFinder;
import ru.levelup.lesson5.dto.Movie;

import java.util.List;

@Component
public class ColonSeparatedMovieFinder implements MovieFinder {

    @Override
    public void populate() {

    }

    @Override
    public List<Movie> getFilms() {
        return List.of(new Movie("Film", 2020, "Author"));
    }
}
