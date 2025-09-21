package ru.itmo.javaadvanced.lesson4.films.service;

import ru.itmo.javaadvanced.lesson4.films.model.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreService {
    void addGenre(Genre genre);
    List<Genre> getAll();
    Optional<Genre> getById(int id);
    void remove(int id);
}
