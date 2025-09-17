package ru.itmo.javaadvanced.lesson4.films.dao;

public interface FilmGenreDao {
    void addGenreToFilm(int filmId, int genreId);
    void removeGenreFromFilm(int filmId, int genreId);
}