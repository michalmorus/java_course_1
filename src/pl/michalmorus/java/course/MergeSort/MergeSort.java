package pl.michalmorus.java.course.MergeSort;

import pl.michalmorus.java.course.Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void run() {
        System.out.println("\nMerge sort");

        int arraySize = Utils.getIntValue("Podaj wielkość tablicy: ", 1, Integer.MAX_VALUE);
        int array[] = Utils.getRandomIntArray(arraySize, 1000);

        System.out.println("Tablica przed sortowaniem");
        System.out.println(Arrays.toString(array));

        mergeSort(array, 0, arraySize - 1);

        System.out.println("Po sortowaniu");
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int array[], int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int center = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, center);
            mergeSort(array, center + 1, rightIndex);
            merge(array, leftIndex, center, rightIndex);
        }
    }

    private static void merge(int array[], int leftIndex, int centerIndex, int rightIndex) {

        ArrayList<Integer> left = new ArrayList<>();
        for (int i = leftIndex; i <= centerIndex; i++) {
            left.add(array[i]);
        }
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = centerIndex + 1; i <= rightIndex; i++) {
            right.add(array[i]);
        }
        int currentIndex = leftIndex;
        while (left.size() > 0 & right.size() > 0) {
            if ((int) left.get(0) > (int) right.get(0)) {
                array[currentIndex] = (int) right.get(0);
                right.remove(0);
            } else {
                array[currentIndex] = (int) left.get(0);
                left.remove(0);
            }
            currentIndex++;
        }

        while (!left.isEmpty()) {
            array[currentIndex] = (int) left.get(0);
            left.remove(0);
            currentIndex++;
        }

        while (!right.isEmpty()) {
            array[currentIndex] = (int) right.get(0);
            right.remove(0);
            currentIndex++;
        }
    }
}
