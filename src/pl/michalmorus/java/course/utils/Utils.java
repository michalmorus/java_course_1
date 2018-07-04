package pl.michalmorus.java.course.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static int[] getRandomIntArray(int size, int max) {
        int[] array = new int[size];
        Random generator = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = generator.nextInt(max);
        }

        return array;
    }

    public static int getIntValue(String message, int min, int max) {
        int value = -1;
        do {
            try {
                System.out.print(message);
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\nNiepoprawny argument, spróbuj jeszcze raz!");
            }
        } while (value > max & value < min);

        return value;
    }
}
