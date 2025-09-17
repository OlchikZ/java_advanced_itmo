package ru.itmo.javaadvanced.lesson4.films.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.javaadvanced.lesson4.films.dao.FilmDao;
import ru.itmo.javaadvanced.lesson4.films.model.Film;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmDao dao;

    @Override
    public void addFilm(Film film) {
        if (film.getYear() < 1888) { // первый фильм снят в 1888
            throw new IllegalArgumentException("Год фильма слишком маленький!");
        }
        dao.save(film);
    }

    @Override
    public List<Film> getAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Film> getById(int id) {
        return dao.findById(id);
    }

    @Override
    public void remove(int id) {
        dao.deleteById(id);
    }
}