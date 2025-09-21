package ru.itmo.javaadvanced.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.javaadvanced.lesson5.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {}