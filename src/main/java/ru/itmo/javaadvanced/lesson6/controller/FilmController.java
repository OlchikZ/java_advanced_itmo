package ru.itmo.javaadvanced.lesson6.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.javaadvanced.lesson6.dto.FilmDto;
import ru.itmo.javaadvanced.lesson6.model.Film;
import ru.itmo.javaadvanced.lesson6.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public List<Film> getAll() {
        return filmService.getAll();
    }

    @GetMapping("/{id}")
    public Film getById(@PathVariable Long id) {
        return filmService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Film> create(@Valid @RequestBody FilmDto dto) {
        return ResponseEntity.ok(filmService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> update(@PathVariable Long id,
                                       @Valid @RequestBody FilmDto dto) {
        return ResponseEntity.ok(filmService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }
}