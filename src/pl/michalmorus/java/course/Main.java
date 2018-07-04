package pl.michalmorus.java.course;

import pl.michalmorus.java.course.bisection.Bisection;
import pl.michalmorus.java.course.bubblesort.BubbleSort;
import pl.michalmorus.java.course.fibonacci.Fibonacci;
import pl.michalmorus.java.course.mergesort.MergeSort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("1. Sortowanie bąbelkowe");
        System.out.println("2. Wypisz N pierwszych wyrazów ciągu Fibonacciego");
        System.out.println("3. Implementacja merge sort");
        System.out.println("4. Algorytm bisekcji");
        System.out.println("5. Zaimplementuj hierarchię klas (auta, rośliny, zwierzę)");

        Bisection.run();
        boolean correct = false;
        do {
            try {
                System.out.print("Wybierz program [1-5]: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        correct = true;
                        new BubbleSort().run();
                        break;
                    case 2:
                        correct = true;
                        new Fibonacci().run();
                        break;
                    case 3:
                        correct = true;
                        new MergeSort().run();
                        break;
                    case 4:
                        correct = true;
                        Bisection.run();
                        break;
                    default:
                        System.out.println("Nic nie wybrano");
                }
            } catch (Exception exception) {
                System.out.println("\nNieprawidłowa wartość, spróbuj jeszcze raz!");
            }
        } while (!correct);
    }
}
