package pl.michalmorus.java.course.mergesort;

import pl.michalmorus.java.course.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public void run() {
        System.out.println("\nMerge sort");

        int arraySize = Utils.getIntValue("Podaj wielkość tablicy: ", 1, Integer.MAX_VALUE);
        int array[] = Utils.getRandomIntArray(arraySize, 1000);

        System.out.println("Tablica przed sortowaniem");
        System.out.println(Arrays.toString(array));

        mergeSort(array, 0, arraySize - 1);

        System.out.println("Po sortowaniu");
        System.out.println(Arrays.toString(array));
    }

    private void mergeSort(int array[], int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int center = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, center);
            mergeSort(array, center + 1, rightIndex);
            merge(array, leftIndex, center, rightIndex);
        }
    }

    private void merge(int array[], int leftIndex, int centerIndex, int rightIndex) {

        ArrayList left = new ArrayList();
        for (int i = leftIndex; i <= centerIndex; i++) {
            left.add(array[i]);
        }
        ArrayList right = new ArrayList();
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
//
//
//        int leftSize = centerIndex - leftIndex + 1;
//        int leftTemp[] = new int[leftSize];
//        for (int i = 0; i < leftSize; ++i) {
//            leftTemp[i] = array[leftIndex + i];
//        }
//        int rightSize = rightIndex - centerIndex;
//        int rightTemp[] = new int[rightSize];
//        for (int i = 0; i < rightSize; ++i) {
//            rightTemp[i] = array[centerIndex + 1 + i];
//        }
//
//
//        int leftIdx = 0, rightIdx = 0, currIdx = leftIndex;
//        while (leftIdx < leftSize & rightIdx < rightSize) {
//            if (leftTemp[leftIdx] <= rightTemp[rightIdx]) {
//                array[currIdx] = leftTemp[leftIdx];
//                leftIdx++;
//            } else {
//                array[currIdx] = rightTemp[rightIdx];
//                rightIdx++;
//            }
//            currIdx++;
//        }
//
//        while (leftIdx < leftSize) {
//            array[currIdx] = leftTemp[leftIdx];
//            leftIdx++;
//            currIdx++;
//        }
//
//        while (rightIdx < rightSize) {
//            array[currIdx] = rightTemp[rightIdx];
//            rightIdx++;
//            currIdx++;
//        }
    }
}
