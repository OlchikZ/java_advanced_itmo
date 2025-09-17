package ru.itmo.javaadvanced.lesson4.films.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {
    private long id;
    private String nameRu;
    private String nameEn;
}