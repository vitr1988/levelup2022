package ru.levelup.lesson10.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.lesson10.dto.ResultDto;
import ru.levelup.lesson10.service.GenreService;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @DeleteMapping("/genres/{code}")
    public ResponseEntity<?> delete(@PathVariable("code") String genreCode) {
        genreService.deleteByCode(genreCode);
        return ResponseEntity.ok(new ResultDto());
    }
}

