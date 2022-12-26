package ru.levelup.lesson10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelup.lesson10.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, String> {
}
