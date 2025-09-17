package ru.itmo.javaadvanced.lesson4.films.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.javaadvanced.lesson4.films.dao.FilmGenreDao;

@Service
@RequiredArgsConstructor
public class FilmGenreServiceImpl implements FilmGenreService {
    private final FilmGenreDao dao;

    @Override
    public void linkFilmToGenre(int filmId, int genreId) {
        dao.addGenreToFilm(filmId, genreId);
    }

    @Override
    public void unlinkFilmFromGenre(int filmId, int genreId) {
        dao.removeGenreFromFilm(filmId, genreId);
    }
}
