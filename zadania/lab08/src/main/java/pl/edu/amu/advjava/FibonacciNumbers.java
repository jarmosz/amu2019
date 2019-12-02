package pl.edu.amu.advjava;

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
        return IntStream.generate(() -> {
            // TODO add implementation here
            throw new UnsupportedOperationException("Not yet implemented");
        }).limit(n).toArray();
    }

}

final class FibonacciSupplier implements IntSupplier {

    @Override
    public int getAsInt() {
        // TODO add implementation here
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

