package ru.itmo.javaadvanced.lesson4.films.service;

import ru.itmo.javaadvanced.lesson4.films.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    void addFilm(Film film);
    List<Film> getAll();
    Optional<Film> getById(int id);
    void remove(int id);
}