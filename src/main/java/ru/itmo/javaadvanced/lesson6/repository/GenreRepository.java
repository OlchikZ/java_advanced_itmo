package ru.itmo.javaadvanced.lesson6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.javaadvanced.lesson6.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}