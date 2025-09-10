package ru.itmo.javaadvanced.lesson2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itmo.javaadvanced.lesson2.service.RomanConverter;

@Component
@RequiredArgsConstructor
public class RomanRunner implements CommandLineRunner {

    private final RomanConverter service;

    @Override
    public void run(String... args) {
        System.out.println("=== Roman Converter ===");
        System.out.println("XIV -> " + service.romanToInt("XIV"));     // 14
        System.out.println("MCMXC -> " + service.romanToInt("MCMXC")); // 1990
        System.out.println("MMXXV -> " + service.romanToInt("MMXXV")); // 2025
    }
}