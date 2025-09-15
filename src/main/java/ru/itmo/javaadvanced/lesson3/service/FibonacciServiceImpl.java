package ru.itmo.javaadvanced.lesson3.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    private final boolean cacheEnabled;
    private final Map<Integer, Long> cache = new HashMap<>();

    public FibonacciServiceImpl(@Value("${fibonacci.cache.enabled:true}") boolean cacheEnabled) {
        this.cacheEnabled = cacheEnabled;
    }

    @Override
    public long getFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n должно быть >= 0");
        }

        if (cacheEnabled && cache.containsKey(n)) {
            return cache.get(n);
        }

        long result;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            long a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                long tmp = a + b;
                a = b;
                b = tmp;
            }
            result = b;
        }

        if (cacheEnabled) {
            cache.put(n, result);
        }

        return result;
    }
}
