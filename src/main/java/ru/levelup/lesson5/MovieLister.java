package ru.levelup.lesson5;

import org.springframework.stereotype.Component;
import ru.levelup.lesson5.dto.Movie;

import java.util.List;

@Component
public class MovieLister {

    private final MovieFinder finder;// = new DatabaseFinder();

    public MovieLister(MovieFinder databaseFinder) {
        this.finder = databaseFinder;
        databaseFinder.populate();
    }

    public List<Movie> getFilms() {
        return finder.getFilms();
    }
}
