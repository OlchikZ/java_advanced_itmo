package ru.itmo.javaadvanced.lesson6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.itmo.javaadvanced.lesson5.model.Genre;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "films")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Русское название не может быть пустым")
    @Size(max = 255)
    private String titleRu;

    @NotBlank(message = "Английское название не может быть пустым")
    @Size(max = 255)
    private String titleEn;

    @Min(value = 1888, message = "Год фильма должен быть не меньше 1888")
    private Integer year;

    @Min(value = 1, message = "Длительность должна быть положительной")
    private Integer duration;

    @ToString.Exclude // иначе ловлю LazyInitializationException
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "film_genres",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @Builder.Default
    private Set<Genre> genres = new HashSet<>();
}