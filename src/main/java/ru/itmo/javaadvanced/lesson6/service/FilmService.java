package ru.itmo.javaadvanced.lesson6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.javaadvanced.lesson6.dto.FilmDto;
import ru.itmo.javaadvanced.lesson6.model.Film;
import ru.itmo.javaadvanced.lesson6.repository.FilmRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    @Transactional(readOnly = true)
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Film getById(Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Фильм не найден"));
    }

    @Transactional
    public Film create(FilmDto dto) {
        Film film = Film.builder()
                .titleRu(dto.getTitleRu())
                .titleEn(dto.getTitleEn())
                .year(dto.getYear())
                .duration(dto.getDuration())
                .build();
        return filmRepository.save(film);
    }

    @Transactional
    public Film update(Long id, FilmDto dto) {
        Film film = getById(id);
        film.setTitleRu(dto.getTitleRu());
        film.setTitleEn(dto.getTitleEn());
        film.setYear(dto.getYear());
        film.setDuration(dto.getDuration());
        return filmRepository.save(film);
    }

    @Transactional
    public void delete(Long id) {
        filmRepository.deleteById(id);
    }
}