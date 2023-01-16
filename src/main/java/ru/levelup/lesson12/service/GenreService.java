package ru.levelup.lesson12.service;

import org.springframework.data.domain.Pageable;
import ru.levelup.lesson12.dto.GenreDto;
import ru.levelup.lesson12.dto.GenrePageDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<GenreDto> findAll();
    GenrePageDto getPage(Pageable pageable);
    Optional<GenreDto> getByCode(@NotEmpty String genreCode);
    GenreDto save(@Valid GenreDto genre);
    void deleteByCode(@NotEmpty String genreCode);
}
