package ru.itmo.javaadvanced.lesson4.films.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itmo.javaadvanced.lesson4.films.dao.FilmGenreDao;

@Repository
@RequiredArgsConstructor
public class FilmGenreDaoImpl implements FilmGenreDao {
    private final JdbcTemplate jdbc;

    @Override
    public void addGenreToFilm(int filmId, int genreId) {
        jdbc.update("INSERT INTO film_genres (film_id, genre_id) VALUES (?, ?)", filmId, genreId);
    }

    @Override
    public void removeGenreFromFilm(int filmId, int genreId) {
        jdbc.update("DELETE FROM film_genres WHERE film_id = ? AND genre_id = ?", filmId, genreId);
    }
}