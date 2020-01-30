package ru.geekbrains.GuessTheNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void showtable(char[][] t){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j <5; j++){
                System.out.print("|" + t[i][j]);
            }
            System.out.println("|");
        }
    }
    static void chekVictory(int [][] X, boolean user ){
        for (int i = 0; i < 5; i++){
            int sX = 0, sY = 0, dS1 = 0, dS2 = 0;
            for (int j = 0; j < 5; j++){
                sX += X[i][j];
                sY += X[j][i];
                dS1 += X[j][j];
                dS2 += X[j][4 - j];
                if(sX == 5 || sY == 5 || dS1 == 5 || dS2 == 5 ){
                    System.out.println(user?"Вы победили!" : "Вы проиграли");
//System.out.print(sX + " " + sY + " " + dS1 + " " + dS2 + " ");
                    System.exit(0);
                }
            }
        }

    }
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        char def = '_';
        char [][] t = new char [5][5];
        int [][] X = new int[5][5];
        int [][] o = new int[5][5];
        for (int i = 0; i < 5; i++){
            Arrays.fill(t[i], def);
        }
        showtable(t);
        System.out.println("Вы играете крестиками!" +
                "Выберите номер строки и столба," +
                "куда хотите совершить ход");
        char user = 'X';
        while (true){
            System.out.println("Ваш ход:");
            int x = in.nextInt(), y = in.nextInt();
            x--; y--;
            t[x][y] = user;
            X[x][y] = 1;
            showtable(t);
            chekVictory(X, true);
            System.out.print("Компьютер думает");
            for (int i = 0; i < 7; i++){
                System.out.print("*");
                Thread.sleep(250);
            }
            System.out.print("");
            moveAI(t,o);
            showtable(t);
            chekVictory(o, false);
            System.out.println("*******");
        }
    }

    private static void moveAI(char[][]t, int [][] X){
        ArrayList<int []> pairs = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            for (int j = 0; j <5; j++){
                if (t[i][j] == '_'){
                    pairs.add(new int[]{i,j});
                }
            }
        }
        if(pairs.size() == 0){
            return;
        }
        int [] rnd = pairs.get(new Random().nextInt(pairs.size()));
        t[rnd[0]][rnd[1]] = '0';
        X [rnd[0]][rnd[1]] = '1';
    }
}
