package ru.levelup.lesson5;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.levelup.lesson5.dto.Movie;

import java.util.List;

@Component
public class MovieSearcher {

//    @Autowired
    @Setter(onMethod_ = @Autowired)
    private MovieFinder databaseFinder;

//    @Autowired
//    public void setDatabaseFinder(MovieFinder databaseFinder) {
//        this.databaseFinder = databaseFinder;
//    }

    public List<Movie> getFilms() {
        return databaseFinder.getFilms();
    }
}
