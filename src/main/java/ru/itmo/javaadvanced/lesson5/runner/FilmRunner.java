package ru.itmo.javaadvanced.lesson5.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.itmo.javaadvanced.lesson5.model.Film;
import ru.itmo.javaadvanced.lesson5.model.Genre;
import ru.itmo.javaadvanced.lesson5.service.FilmService;
import ru.itmo.javaadvanced.lesson5.service.GenreService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class FilmRunner implements CommandLineRunner {
    private final FilmService filmService;
    private final GenreService genreService;

    @Override
    public void run(String... args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("""
                        Меню:
                        1. Добавить фильм
                        2. Показать фильмы (пейджинг)
                        3. Добавить жанр
                        4. Показать жанры (пейджинг)
                        5. Привязать жанр к фильму
                        6. Выход
                        """);

                String choice = sc.nextLine();
                switch (choice) {
                    case "1" -> {
                        System.out.print("Название (рус): ");
                        String ru = sc.nextLine();
                        System.out.print("Название (англ): ");
                        String en = sc.nextLine();
                        System.out.print("Год: ");
                        int year = Integer.parseInt(sc.nextLine());
                        System.out.print("Длительность: ");
                        int duration = Integer.parseInt(sc.nextLine());
                        filmService.addFilm(Film.builder()
                                .titleRu(ru).titleEn(en)
                                .year(year).duration(duration)
                                .build());
                    }
                    case "2" -> {
                        System.out.print("Номер страницы (0..N): ");
                        int page = Integer.parseInt(sc.nextLine());
                        System.out.print("Размер страницы: ");
                        int size = Integer.parseInt(sc.nextLine());

                        Page<Film> films = filmService.getAllPaged(page, size);
                        films.forEach(film -> {
                            System.out.println(film.getId() + ". " + film.getTitleRu()
                                    + " (" + film.getYear() + "), " + film.getDuration() + " мин.");
                            if (!film.getGenres().isEmpty()) {
                                System.out.println("   Жанры:");
                                film.getGenres().forEach(g -> System.out.println("    - " + g.getNameRu()));
                            }
                        });
                        System.out.println("Страница " + (films.getNumber() + 1) + " из " + films.getTotalPages());
                    }
                    case "3" -> {
                        System.out.print("Жанр (рус): ");
                        String ru = sc.nextLine();
                        System.out.print("Жанр (англ): ");
                        String en = sc.nextLine();
                        genreService.addGenre(Genre.builder().nameRu(ru).nameEn(en).build());
                    }
                    case "4" -> {
                        System.out.print("Номер страницы (0..N): ");
                        int page = Integer.parseInt(sc.nextLine());
                        System.out.print("Размер страницы: ");
                        int size = Integer.parseInt(sc.nextLine());

                        Page<Genre> genres = genreService.getAllPaged(page, size);
                        genres.forEach(g -> System.out.println(g.getId() + ". " + g.getNameRu()));
                        System.out.println("Страница " + (genres.getNumber() + 1) + " из " + genres.getTotalPages());
                    }
                    case "5" -> {
                        System.out.println("Список фильмов:");
                        filmService.getAll().forEach(f -> System.out.println(f.getId() + ". " + f.getTitleRu()));

                        System.out.println("Список жанров:");
                        genreService.getAll().forEach(g -> System.out.println(g.getId() + ". " + g.getNameRu()));

                        System.out.print("Введите ID фильма: ");
                        int filmId = Integer.parseInt(sc.nextLine());
                        System.out.print("Введите ID жанра: ");
                        int genreId = Integer.parseInt(sc.nextLine());

                        boolean success = filmService.addGenreToFilm(filmId, genreId);
                        if (success) {
                            System.out.println("✅ Жанр привязан к фильму");
                        } else {
                            System.out.println("⚠️ Неверный ID фильма или жанра!");
                        }
                    }
                    case "6" -> {
                        System.out.println("Выход...");
                        return;
                    }
                    default -> System.out.println("Неизвестная команда");
                }
            }
        }
    }
}