package ru.itmo.javaadvanced.lesson4.films.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itmo.javaadvanced.lesson4.films.dao.FilmDao;
import ru.itmo.javaadvanced.lesson4.films.model.Film;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FilmDaoImpl implements FilmDao {
    private final JdbcTemplate jdbc;

    private final RowMapper<Film> mapper = (rs, n) -> Film.builder()
            .id(rs.getInt("id"))
            .titleRu(rs.getString("title_ru"))
            .titleEn(rs.getString("title_en"))
            .year(rs.getInt("year"))
            .duration(rs.getInt("duration"))
            .build();

    @Override
    public void save(Film film) {
        jdbc.update(
                "INSERT INTO films (title_ru, title_en, year, duration) VALUES (?,?,?,?)",
                film.getTitleRu(), film.getTitleEn(), film.getYear(), film.getDuration()
        );
    }

    @Override
    public List<Film> findAll() {
        return jdbc.query("SELECT * FROM films ORDER BY id", mapper);
    }

    @Override
    public Optional<Film> findById(int id) {
        return jdbc.query("SELECT * FROM films WHERE id = ?", mapper, id)
                .stream().findFirst();
    }

    @Override
    public void deleteById(int id) {
        jdbc.update("DELETE FROM films WHERE id = ?", id);
    }
}