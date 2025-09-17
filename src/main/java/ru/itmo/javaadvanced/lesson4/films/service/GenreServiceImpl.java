package ru.itmo.javaadvanced.lesson4.films.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.javaadvanced.lesson4.films.dao.GenreDao;
import ru.itmo.javaadvanced.lesson4.films.model.Genre;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreDao dao;

    @Override
    public void addGenre(Genre genre) {
        dao.save(genre);
    }

    @Override
    public List<Genre> getAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Genre> getById(int id) {
        return dao.findById(id);
    }

    @Override
    public void remove(int id) {
        dao.deleteById(id);
    }
}