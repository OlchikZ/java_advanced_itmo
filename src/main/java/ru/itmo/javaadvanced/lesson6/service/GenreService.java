package ru.itmo.javaadvanced.lesson6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.javaadvanced.lesson6.model.Genre;
import ru.itmo.javaadvanced.lesson6.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Transactional
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }
}