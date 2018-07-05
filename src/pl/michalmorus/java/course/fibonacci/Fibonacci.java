package pl.michalmorus.java.course.fibonacci;

import pl.michalmorus.java.course.utils.Utils;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer, BigInteger> resultCache;

    static {
        resultCache = new HashMap<>();
        resultCache.put(0, BigInteger.ZERO);
        resultCache.put(1, BigInteger.ONE);
    }

    public static void run() {
        System.out.println("\nFibonacci");
        int arg = Utils.getIntValue("Podaj liczbę naturalną: ", 0, Integer.MAX_VALUE);
        if (arg == 0) {
            System.out.println("Wynik: 0");
        } else {
            try {
                BigInteger result = fibonacci(arg);
                System.out.println("Wynik: " + result);
            } catch (StackOverflowError stackOverflowError) {
                System.err.println("Nie udało się wykonać obliczeń");
            }
        }
    }

    private static BigInteger fibonacci(int n) {
        if ((n == 1) || (n == 2))
            return BigInteger.ONE;
        else if (resultCache.containsKey(n)) {
            return resultCache.get(n);
        } else {
            BigInteger value = fibonacci(n - 1).add(fibonacci(n - 2));
            resultCache.put(n, value);
            return value;
        }
    }
}
