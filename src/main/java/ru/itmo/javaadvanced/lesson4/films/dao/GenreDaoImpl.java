package ru.itmo.javaadvanced.lesson4.films.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itmo.javaadvanced.lesson4.films.model.Genre;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {
    private final JdbcTemplate jdbc;

    private final RowMapper<Genre> mapper = (rs, n) -> Genre.builder()
            .id(rs.getInt("id"))
            .nameRu(rs.getString("name_ru"))
            .nameEn(rs.getString("name_en"))
            .build();

    @Override
    public void save(Genre genre) {
        jdbc.update("INSERT INTO genres (name_ru, name_en) VALUES (?, ?)",
                genre.getNameRu(), genre.getNameEn());
    }

    @Override
    public List<Genre> findAll() {
        return jdbc.query("SELECT * FROM genres ORDER BY id", mapper);
    }

    @Override
    public Optional<Genre> findById(int id) {
        return jdbc.query("SELECT * FROM genres WHERE id = ?", mapper, id)
                .stream().findFirst();
    }

    @Override
    public void deleteById(int id) {
        jdbc.update("DELETE FROM genres WHERE id = ?", id);
    }
}
