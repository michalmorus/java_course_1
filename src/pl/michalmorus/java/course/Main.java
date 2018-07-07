package pl.michalmorus.java.course;

import pl.michalmorus.java.course.Bisection.Bisection;
import pl.michalmorus.java.course.BubbleSort.BubbleSort;
import pl.michalmorus.java.course.College.College;
import pl.michalmorus.java.course.Fibonacci.Fibonacci;
import pl.michalmorus.java.course.MergeSort.MergeSort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("1. Sortowanie bąbelkowe");
        System.out.println("2. Wypisz N pierwszych wyrazów ciągu Fibonacciego");
        System.out.println("3. Implementacja merge sort");
        System.out.println("4. Algorytm bisekcji");
        System.out.println("5. Zaimplementuj hierarchię klas (auta, rośliny, zwierzę)");

        boolean correct = false;
        do {
            try {
                System.out.print("Wybierz program [1-5]: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        correct = true;
                        BubbleSort.run();
                        break;
                    case 2:
                        correct = true;
                        Fibonacci.run();
                        break;
                    case 3:
                        correct = true;
                        MergeSort.run();
                        break;
                    case 4:
                        correct = true;
                        Bisection.run();
                        break;
                    case 5:
                        correct = true;
                        College.run();
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
