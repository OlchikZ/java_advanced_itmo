package ru.itmo.javaadvanced.lesson6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.javaadvanced.lesson6.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
}