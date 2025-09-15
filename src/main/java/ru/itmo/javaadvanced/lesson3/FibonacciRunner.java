package ru.itmo.javaadvanced.lesson3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itmo.javaadvanced.lesson3.service.FibonacciService;

import java.util.Scanner;

@Component
public class FibonacciRunner implements CommandLineRunner {

    private final FibonacciService service;

    public FibonacciRunner(FibonacciService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер n: ");
        int n = scanner.nextInt();

        long start = System.nanoTime();
        long result = service.getFibonacci(n);
        long end = System.nanoTime();

        System.out.println("F(" + n + ") = " + result);
        System.out.println("Время вычисления: " + (end - start) / 1_000_000.0 + " ms");
    }
}