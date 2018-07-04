package pl.michalmorus.java.course.bubblesort;

import pl.michalmorus.java.course.utils.Utils;

import java.util.Arrays;

public class BubbleSort {

    public void run() {
        System.out.println("\nBubblesort");

        int arraySize = Utils.getIntValue("Podaj wielkość tablicy do sortowania: ", 1, Integer.MAX_VALUE);
        int[] array = Utils.getRandomIntArray(arraySize, 1000);

        System.out.println("Tablica przed sortowaniem:");
        System.out.println(Arrays.toString(array));

        int[] result = bubbleSort(array);

        System.out.println("Tablica po sortowaniu:");
        System.out.println(Arrays.toString(result));
    }


    private static int[] bubbleSort(int[] array) {
        int size = array.length, temp;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - 1); j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}
