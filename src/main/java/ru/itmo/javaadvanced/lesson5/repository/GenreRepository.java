package ru.itmo.javaadvanced.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.itmo.javaadvanced.lesson5.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>,
        PagingAndSortingRepository<Genre, Integer> {
}