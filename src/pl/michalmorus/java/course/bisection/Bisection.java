package pl.michalmorus.java.course.bisection;

import pl.michalmorus.java.course.utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bisection {

    private static int[] polynomial;

    public static void run() {
        parsePolynomial(readLine());

        double start = Utils.getDoubleValue("Początek przedziału: ");
        double end = Utils.getDoubleValue("Koniec przedziału: ");
        try {
            double result = bisection(start, end);
            System.out.println("wynik: " + result);
        } catch (Exception e) {
            System.out.println("Nie udało się obliczyć wartości");
        }
    }

    private static double bisection(double min, double max) {
        if (f(min) * f(max) > 0) {
            throw new Error("Not found!");
        }
        double center = (min + max) / 2;
        if (f(center) == 0) {
            return center;
        } else if (f(min) * f(center) < 0) {
            return bisection(min, center);
        } else {
            return bisection(center, max);
        }
    }

    private static String readLine() {
        String line = "";
        do {
            System.out.print("\nWprowadź wielomian w formacie -4x^4+2x^2+1: ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Spróbuj jeszcze raz");
            }
        } while (line.length() == 0);

        return line;
    }

    private static double f(double x) {
        double result = polynomial[0];
        for (int i = 1; i < polynomial.length; i++) {
            result += (polynomial[i] * Math.pow(x, i));
        }

        return result;
    }

    private static void parsePolynomial(String pharse) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Pattern monomialPattern = Pattern.compile("[+-]?[0-9]+x\\^[0-9]+");
        Matcher monomialMatcher = monomialPattern.matcher(pharse);

        while (monomialMatcher.find()) {
            Pattern wordPattern = Pattern.compile("[+-]?[0-9]+");
            Matcher wordMatcher = wordPattern.matcher(monomialMatcher.group());

            ArrayList<Integer> params = new ArrayList<>();
            while (wordMatcher.find()) {
                params.add(Integer.parseInt(wordMatcher.group()));
            }
            if (params.size() == 2) {
                if (treeMap.containsKey(params.get(1))) {
                    throw new Error("Duplicated degree " + params.get(0));
                }
                treeMap.put(params.get(1), params.get(0));
            }
        }
        int maxDegree = treeMap.lastKey();
        maxDegree++;
        polynomial = new int[maxDegree];
        for (int i = 0; i < maxDegree; i++) {
            polynomial[i] = treeMap.getOrDefault(i, 0);
        }

        Pattern firstDegreePattern = Pattern.compile("[+-]?[0-9]+x(?!\\^)");
        Matcher firstDegreeMatcher = firstDegreePattern.matcher(pharse);
        if (firstDegreeMatcher.find()) {
            polynomial[1] = Integer.parseInt(firstDegreeMatcher.group().replace("x", ""));
        }

        Pattern zeroDegreePattern = Pattern.compile("[+-]?[0-9]+$");
        Matcher zeroDegreeMatcher = zeroDegreePattern.matcher(pharse);
        if (zeroDegreeMatcher.find()) {
            polynomial[0] = Integer.parseInt(zeroDegreeMatcher.group());
        }

        if (polynomial.length == 0) {
            System.out.println("Brak wielomianu!");
            System.exit(0);
        }
    }
}
