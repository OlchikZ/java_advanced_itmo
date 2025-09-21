package ru.itmo.javaadvanced.lesson4.films.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {
    private long id;
    private String nameRu;
    private String nameEn;
}