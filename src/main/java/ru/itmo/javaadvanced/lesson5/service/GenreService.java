package ru.itmo.javaadvanced.lesson5.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.javaadvanced.lesson5.model.Genre;
import ru.itmo.javaadvanced.lesson5.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepo;

    @Transactional
    public Genre addGenre(Genre genre) {
        return genreRepo.save(genre);
    }

    public List<Genre> getAll() {
        return genreRepo.findAll();
    }

    public Genre getById(Integer id) {
        return genreRepo.findById(id).orElse(null);
    }

    @Transactional
    public void remove(Integer id) {
        genreRepo.deleteById(id);
    }
}