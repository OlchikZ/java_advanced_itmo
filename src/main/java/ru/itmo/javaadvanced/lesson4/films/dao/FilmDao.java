package ru.itmo.javaadvanced.lesson4.films.dao;

import ru.itmo.javaadvanced.lesson4.films.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmDao {
    void save(Film film);
    List<Film> findAll();
    Optional<Film> findById(int id);
    void deleteById(int id);
}