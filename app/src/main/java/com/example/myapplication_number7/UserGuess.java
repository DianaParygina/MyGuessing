package com.example.myapplication_number7;

public class UserGuess {
    int secretNumber = (int) (Math.random() * 100);
    private int remainingAttempts = 3;

    public String checkGuess(int guess) {
        if (remainingAttempts > 1) {
            remainingAttempts--;
            if (guess == secretNumber) {
                return "Поздравляю, вы угадали число!";
            } else if (guess < secretNumber) {
                return "Загаданное число больше!\nОсталось попыток: " + remainingAttempts;
            } else {
                return "Загаданное число меньше!\nОсталось попыток: " + remainingAttempts;
            }
        }
        return "Вы проиграли!\nПравильный ответ: " + secretNumber;
    }
}