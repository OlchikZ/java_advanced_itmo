package ru.itmo.javaadvanced.lesson4.films.dao;

import ru.itmo.javaadvanced.lesson4.films.model.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreDao {
    void save(Genre genre);
    List<Genre> findAll();
    Optional<Genre> findById(int id);
    void deleteById(int id);
}