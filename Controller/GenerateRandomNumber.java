package io.github.some_example_name.Controller;

import java.util.Random;

public class GenerateRandomNumber {
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
