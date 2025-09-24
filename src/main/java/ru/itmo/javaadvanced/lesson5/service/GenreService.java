package ru.itmo.javaadvanced.lesson5.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public List<Genre> getAll() {
        return genreRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Genre> getAllPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return genreRepo.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Genre getById(Integer id) {
        return genreRepo.findById(id).orElse(null);
    }

    @Transactional
    public void remove(Integer id) {
        genreRepo.deleteById(id);
    }
}