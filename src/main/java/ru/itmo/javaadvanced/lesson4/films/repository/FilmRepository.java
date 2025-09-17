package ru.itmo.javaadvanced.lesson4.films.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itmo.javaadvanced.lesson4.films.model.Film;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FilmRepository {

    private final JdbcTemplate jdbc;

    private final RowMapper<Film> mapper = (rs, n) -> Film.builder()
            .id(rs.getInt("id"))
            .titleRu(rs.getString("title_ru"))
            .titleEn(rs.getString("title_en"))
            .year(rs.getInt("year"))
            .duration(rs.getInt("duration"))
            .build();

    public int save(Film film) {
        return jdbc.update(
                "INSERT INTO films (title_ru, title_en, year, duration) VALUES (?,?,?,?)",
                film.getTitleRu(), film.getTitleEn(), film.getYear(), film.getDuration()
        );
    }

    public List<Film> findAll() {
        return jdbc.query("SELECT * FROM films ORDER BY id", mapper);
    }

    public Optional<Film> findById(int id) {
        return jdbc.query("SELECT * FROM films WHERE id = ?", mapper, id)
                .stream().findFirst();
    }

    public int deleteById(int id) {
        return jdbc.update("DELETE FROM films WHERE id = ?", id);
    }
}