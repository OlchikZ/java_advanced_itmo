package ru.itmo.javaadvanced.lesson4.films.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    private long id;
    private String titleRu;
    private String titleEn;
    private Integer year;
    private Integer duration;
}