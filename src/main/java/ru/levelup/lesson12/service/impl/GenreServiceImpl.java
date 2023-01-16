package ru.levelup.lesson12.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.lesson12.dto.GenreDto;
import ru.levelup.lesson12.dto.GenrePageDto;
import ru.levelup.lesson12.mapper.GenreMapper;
import ru.levelup.lesson12.model.Genre;
import ru.levelup.lesson12.repository.GenreRepository;
import ru.levelup.lesson12.security.Authorities;
import ru.levelup.lesson12.service.GenreService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private static final Locale RUSSIAN_LOCALE = new Locale("ru", "RU");

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    private final MessageSource messageSource;

    private final HttpServletRequest request;

    private final Authorities authorities;

    @Override
    @Transactional(readOnly = true)
    public List<GenreDto> findAll() {
        return genreMapper.toDtos(genreRepository.findAll());
    }

    @Override
    public GenrePageDto getPage(Pageable pageable) {
        String welcomeText = messageSource.getMessage("welcome.intro", null, request.getLocale());
        Page<Genre> currentPage = genreRepository.findAll(pageable);
        return new GenrePageDto(genreMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious(),
                authorities.isAdmin());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GenreDto> getByCode(@NotEmpty String genreCode) {
        return genreMapper.toOptionalDto(genreRepository.findById(genreCode));
    }

    @Override
    @Transactional
    public GenreDto save(@Valid GenreDto genre) {
        return genreMapper.toDto(genreRepository.save(genreMapper.toEntity(genre)));
    }

    @Override
    @Transactional
    public void deleteByCode(@NotEmpty String genreCode) {
        genreRepository.deleteById(genreCode);
    }
}

