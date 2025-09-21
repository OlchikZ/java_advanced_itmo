package ru.itmo.javaadvanced.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.javaadvanced.lesson5.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {}