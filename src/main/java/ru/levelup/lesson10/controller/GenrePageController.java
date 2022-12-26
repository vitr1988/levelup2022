package ru.levelup.lesson10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.levelup.lesson10.dto.GenreDto;
import ru.levelup.lesson10.dto.GenrePageDto;
import ru.levelup.lesson10.service.GenreService;
import ru.levelup.lesson10.validator.PositiveOrZero;

import javax.validation.constraints.Positive;

@Controller
@Validated
@RequiredArgsConstructor
public class GenrePageController {

    private final GenreService genreService;

    @GetMapping("/genres")
    public String index(Model model,
                        @PositiveOrZero(originValue = 15) @RequestParam(required = false, defaultValue = "0") Integer page,
                        @Positive @RequestParam(required = false, defaultValue = "5") Integer size) {
//        if (page < 0 || size <= 0) {
//            throw new IllegalArgumentException("Check input parameters");
//        }
        GenrePageDto allGenres = genreService.getPage(PageRequest.of(page, size));
        model.addAttribute("genres", allGenres);
        return "genre/genres";
    }

    @GetMapping("/genre/add")
    public String newGenre(Model model) {
        return "genre/genre";
    }

    @GetMapping("/genre/edit")
    public String currentGenre(@RequestParam("code") String genreCode, Model model) {
        GenreDto currentGenre = genreService.getByCode(genreCode)
                .orElseThrow(() -> new IllegalArgumentException("Non existed genre"));
        model.addAttribute("genre", currentGenre);
        return "genre/genre";
    }

    @PostMapping("/genre/save")
    public String saveGenre(GenreDto genre) {
        genreService.save(genre);
        return "redirect:/genres";
    }
}
