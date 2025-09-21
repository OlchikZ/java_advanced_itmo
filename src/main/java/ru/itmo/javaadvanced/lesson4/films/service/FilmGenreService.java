package ru.itmo.javaadvanced.lesson4.films.service;

public interface FilmGenreService {
    void linkFilmToGenre(int filmId, int genreId);
    void unlinkFilmFromGenre(int filmId, int genreId);
}