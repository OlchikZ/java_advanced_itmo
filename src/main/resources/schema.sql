CREATE TABLE IF NOT EXISTS films (
    id SERIAL PRIMARY KEY,
    title_ru   VARCHAR(255) NOT NULL,
    title_en   VARCHAR(255) NOT NULL,
    year       INT NOT NULL,
    duration   INT
);

CREATE TABLE IF NOT EXISTS genres (
    id SERIAL PRIMARY KEY,
    name_ru VARCHAR(100) NOT NULL,
    name_en VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS film_genres (
    film_id INT REFERENCES films(id) ON DELETE CASCADE,
    genre_id INT REFERENCES genres(id) ON DELETE CASCADE,
    PRIMARY KEY (film_id, genre_id)
);