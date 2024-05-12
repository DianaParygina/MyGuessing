package com.example.myapplication_number7;

import java.util.Random;

public class ProgrammGuess {
    private int remainingAttempts = 3;
    private int minNumber = 1;
    private int maxNumber = 100;
    private int guess;

    public ProgrammGuess() {
        Random random = new Random();
        this.guess = random.nextInt(maxNumber - minNumber + 1) + minNumber;
    }

    public String makeGuess() {
        if (remainingAttempts > 0) {
            remainingAttempts--;
            return "Я думаю, что это " + guess + "?\nОсталось попыток: " + remainingAttempts;
        } else {
            return "У меня не осталось попыток! Я сдаюсь!";
        }
    }

    public void higher() {
        minNumber = guess + 1;
        guess = (minNumber + maxNumber) / 2;
    }

    public void lower() {
        maxNumber = guess - 1;
        guess = (minNumber + maxNumber) / 2;
    }
}