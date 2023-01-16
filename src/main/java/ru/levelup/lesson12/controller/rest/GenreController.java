package ru.levelup.lesson12.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.lesson12.dto.GenrePageDto;
import ru.levelup.lesson12.security.Authorities;
import ru.levelup.lesson12.service.GenreService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;
    private final Authorities authorities;

    @GetMapping
    public GenrePageDto find(@PageableDefault(value = 5) Pageable pageable) {
        final GenrePageDto page = genreService.getPage(pageable);
        page.setAdmin(authorities.isAdmin());
        return page;
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable("code") String genreCode) {
        genreService.deleteByCode(genreCode);
        return ResponseEntity.noContent().build();
    }
}
