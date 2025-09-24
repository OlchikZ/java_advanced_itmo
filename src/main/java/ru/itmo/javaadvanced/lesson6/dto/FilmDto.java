package ru.itmo.javaadvanced.lesson6.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FilmDto {

    @NotBlank(message = "Не указано название на русском")
    @Size(max = 255)
    private String titleRu;

    @NotBlank(message = "Не указано название на английском")
    @Size(max = 255)
    private String titleEn;

    @Min(value = 1888, message = "Год фильма должен быть после 1888")
    private Integer year;

    @Min(value = 1, message = "Продолжительность фильма должна быть больше 0")
    private Integer duration;
}