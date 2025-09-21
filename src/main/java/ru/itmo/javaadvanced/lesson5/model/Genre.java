package ru.itmo.javaadvanced.lesson5.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_ru", nullable = false)
    private String nameRu;

    @Column(name = "name_en", nullable = false)
    private String nameEn;

    @ToString.Exclude // иначе ловлю LazyInitializationException
    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Film> films = new HashSet<>();

}