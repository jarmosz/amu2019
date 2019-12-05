package pl.edu.amu.advjava;

import java.util.ArrayList;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

final class FibonacciNumbersExercise {

    /*
         ZADANIE: dopasuj implementację klasy FibonacciSupplier tak, żeby generowała kolejne liczby ciągu
         Fibonacciego.
     */
    static int[] generateFibonacciNumbers(int n) {
        return IntStream.generate(new FibonacciSupplier()).limit(n).toArray();
    }

    /*
     *   ZADANIE: dopasuj implementację wyrażenia lambda tak, żeby generowało kolejne liczby ciągu Fibonacciego.
     */
    static int[] generateFibonacciNumbersWithLambda(int n) {
        final ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);
        return IntStream.generate(() -> {
            if(n == 0){
                return 0;
            }
            if(n == 1){
                return 1;
            }
            else if(fib.size() == n) {
                return fib.get(n-1);
            }
            else{
                fib.add(fib.get(fib.size()-1) + fib.get(fib.size()-2));
                return fib.get(fib.size()-1);
            }
        }).limit(n).toArray();
    }

}

final class FibonacciSupplier implements IntSupplier {

    int firstElement = 0;
    int secondElement = 1;

    int pom = 0;

    @Override
    public int getAsInt() {
        pom = secondElement;
        secondElement = firstElement + secondElement;
        firstElement = pom;

        return firstElement;


    }
}

