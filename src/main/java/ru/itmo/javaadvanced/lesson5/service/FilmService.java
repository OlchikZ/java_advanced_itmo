package ru.itmo.javaadvanced.lesson5.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.itmo.javaadvanced.lesson5.model.Film;
import ru.itmo.javaadvanced.lesson5.model.Genre;
import ru.itmo.javaadvanced.lesson5.repository.FilmRepository;
import ru.itmo.javaadvanced.lesson5.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository filmRepo;
    private final GenreRepository genreRepo;

    @Transactional
    public Film addFilm(Film film) {
        return filmRepo.save(film);
    }

    @Transactional(readOnly = true)
    public List<Film> getAll() {
        return filmRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Film> getAllPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return filmRepo.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Film getById(Integer id) {
        return filmRepo.findById(id).orElse(null);
    }

    @Transactional
    public void remove(Integer id) {
        filmRepo.deleteById(id);
    }

    @Transactional
    public boolean addGenreToFilm(Integer filmId, Integer genreId) {
        var filmOpt = filmRepo.findById(filmId);
        var genreOpt = genreRepo.findById(genreId);

        if (filmOpt.isEmpty() || genreOpt.isEmpty()) {
            return false;
        }

        Film film = filmOpt.get();
        Genre genre = genreOpt.get();

        film.getGenres().add(genre);
        filmRepo.save(film);
        return true;
    }
}