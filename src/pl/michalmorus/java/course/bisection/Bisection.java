package pl.michalmorus.java.course.bisection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bisection {

    private static TreeMap<Integer, Integer> polynomial;

    public static void run() {
//        String input = readLine();
//        System.out.println(input.length());
        parsePolynomial("3x^6-2x^2");
        System.out.println(polynomial.toString());

    }

    private static String readLine() {
        String line = "";
        do {
            System.out.print("\nWprowadź wielomian w formacie -4x^4+2x^2+1 lub wprowadź 0 aby wygenerować losowy: ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Spróbuj jeszcze raz");
            }
        } while (line.length() == 0);

        return line;
    }


    private static double f(int x) {
        ArrayList values = new ArrayList();
        polynomial.forEach((key,value)-> {
            values.add(value * Math.pow(x, key));
        });
        ;
    }

    private static void parsePolynomial(String pharse) {
        TreeMap treeMap = new TreeMap();
        Pattern polynomialPattern = Pattern.compile("[+-]?[0-9]+x\\^[0-9]+");
        Matcher polynomialMatcher = polynomialPattern.matcher(pharse);

        Pattern factorPolynomialPattern = Pattern.compile("[+-]?[0-9]+");
        while (polynomialMatcher.find()) {
            System.out.println(polynomialMatcher.group());
            Matcher factor = factorPolynomialPattern.matcher(polynomialMatcher.group());
            ArrayList<Integer> params = new ArrayList<Integer>();
            while (factor.find()){
                params.add(Integer.parseInt(factor.group()));
            }
            System.out.println(params.toString());
            if (params.size() == 2) {
                treeMap.put(params.get(1), params.get(0));
            }
        }
        polynomial = treeMap;
    }
}
