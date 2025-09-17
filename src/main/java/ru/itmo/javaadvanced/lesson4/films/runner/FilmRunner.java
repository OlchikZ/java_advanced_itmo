package ru.itmo.javaadvanced.lesson4.films.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itmo.javaadvanced.lesson4.films.model.*;
import ru.itmo.javaadvanced.lesson4.films.service.*;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class FilmRunner implements CommandLineRunner {
    private final FilmService service;
    private final GenreService genreService;
    private final FilmGenreService filmGenreService;


    @Override
    public void run(String... args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("""
                        
                        Меню:
                        1. Добавить фильм
                        2. Показать все фильмы
                        3. Найти фильм по ID
                        4. Удалить фильм
                        5. Добавить жанр
                        6. Показать все жанры
                        7. Привязать жанр к фильму
                        8. Удалить жанр из фильма
                        9. Выход
                        Выбор: """);

                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1" -> {
                        System.out.print("Название (рус): ");
                        String ru = sc.nextLine();
                        System.out.print("Название (англ): ");
                        String en = sc.nextLine();
                        System.out.print("Год: ");
                        int year = Integer.parseInt(sc.nextLine());
                        System.out.print("Длительность (мин): ");
                        int duration = Integer.parseInt(sc.nextLine());

                        service.addFilm(Film.builder()
                                .titleRu(ru).titleEn(en)
                                .year(year).duration(duration)
                                .build());
                        System.out.println("Сохранено");
                    }
                    case "2" -> service.getAll().forEach(System.out::println);
                    case "3" -> {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println(service.getById(id).orElse(null));
                    }
                    case "4" -> {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        service.remove(id);
                        System.out.println("Удалено (если существовало)");
                    }
                    case "5" -> {
                        System.out.print("Название жанра (рус): ");
                        String ru = sc.nextLine();
                        System.out.print("Название жанра (англ): ");
                        String en = sc.nextLine();
                        genreService.addGenre(Genre.builder().nameRu(ru).nameEn(en).build());
                    }
                    case "6" -> genreService.getAll().forEach(System.out::println);
                    case "7" -> {
                        System.out.print("ID фильма: ");
                        int filmId = Integer.parseInt(sc.nextLine());
                        System.out.print("ID жанра: ");
                        int genreId = Integer.parseInt(sc.nextLine());

                        if (service.getById(filmId).isEmpty()) {
                            System.out.println("Фильм с таким ID не найден!");
                            break;
                        }
                        if (genreService.getById(genreId).isEmpty()) {
                            System.out.println("Жанр с таким ID не найден!");
                            break;
                        }

                        filmGenreService.linkFilmToGenre(filmId, genreId);
                        System.out.println("Жанр успешно привязан к фильму");
                    }
                    case "8" -> {
                        System.out.print("ID фильма: ");
                        int filmId = Integer.parseInt(sc.nextLine());
                        System.out.print("ID жанра: ");
                        int genreId = Integer.parseInt(sc.nextLine());

                        if (service.getById(filmId).isEmpty()) {
                            System.out.println("Фильм с таким ID не найден!");
                            break;
                        }
                        if (genreService.getById(genreId).isEmpty()) {
                            System.out.println("Жанр с таким ID не найден!");
                            break;
                        }

                        filmGenreService.unlinkFilmFromGenre(filmId, genreId);
                        System.out.println("Жанр отвязан от фильма");
                    }
                    case "9" -> {
                        System.out.println("Выход...");
                        return;
                    }
                    default -> System.out.println("Неизвестная команда");
                }
            }
        }
    }
}