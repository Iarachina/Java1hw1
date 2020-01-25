package ru.geekbrains.GuessTheNumber;
import java.util.Scanner;
public class Main {
    public static void main(String[] arg) {
        guessNumber();
    }

    public static void guessNumber() {

        //Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число. \
        // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        Scanner scanner = new Scanner(System.in);
        System.out.print("Привет! Я загадал число от 0 до 100, у тебя 7 попыток,чтобы угадать: ");
        int range = 100;
        int count = 7;
        int number = (int) (Math.random() * range);
        while (count > 0) {
            System.out.println("Угадайте число от 0 до " + range);
            int userAnswer = scanner.nextInt();
            count--;
            if (userAnswer > number) {
                System.out.println("Загаданное число меньше. У вас:" + count + "попыток");
            } else if (userAnswer < number) {
                System.out.println("Загаданное число больше.У вас:" + count + "попыток");
            } else {
                System.out.println("Поздравляю! Вы победили! Загаданное число" + number);
                System.out.println("1.Повторить игру\n 2.Выйти из игры\n Введите число");
                int checkUnswer = scanner.nextInt();
                if (checkUnswer == 1) {
                    guessNumber();
                } else if (checkUnswer == 2) {
                    return;
                }

                count--;
            }if (count == 0){
                System.out.println("Ваши попытки закончились, Вы проиграли! Загаданное число:" + number);
            }
        }

    }
}