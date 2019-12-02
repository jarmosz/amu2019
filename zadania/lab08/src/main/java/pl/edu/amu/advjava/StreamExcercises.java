package pl.edu.amu.advjava;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class StreamExcercises {

    /*
         ZADANIE: dla podanej kolekcji zwróć sumę opakowanych liczb.
     */
    static int sum(Collection<CustomNumber> numbers) {
        throw new UnsupportedOperationException();
    }

    /*
         ZADANIE: dla podanej kolekcji zwróć tylko te nieujemne.
     */
    static List<CustomNumber> positiveNumbers(Collection<CustomNumber> numbers) {
        throw new UnsupportedOperationException();
    }

    /*
         ZADANIE: dla podanej kolekcji zwróć kolekcję zawierającą kwadraty opakowanych liczb.
     */
    static List<Integer> squares(Collection<CustomNumber> numbers) {
        throw new UnsupportedOperationException();
    }

    /*
         ZADANIE: dla podanej kolekcji zwróć sumę liczb ujemnych z kolekcji.
     */
    static int sumOfNegativeNumbers(Collection<CustomNumber> numbers) {
        throw new UnsupportedOperationException();
    }

    /*
         ZADANIE: dla podanej kolekcji iloczyn liczb z wszystkich kolekcji.
     */
    static long productOfNumbers(Collection<CustomNumberCollection> customNumberCollection) {
        throw new UnsupportedOperationException();
    }

    /*
         ZADANIE: zwracana mapa powinna zawierać jako klucz kwadrat liczby z kolekcji, a jako wartość - liczby,
         które są pierwiastkami kwadratowymi tej liczby.
     */
    static Map<Integer, Set<Integer>> squareRoots(Collection<CustomNumber> numbers) {
        throw new UnsupportedOperationException();
    }

    static final class CustomNumber {
        int number;

        CustomNumber(int number) {
            this.number = number;
        }

        boolean isPositive() {
            return number >= 0;
        }

        boolean isNegative() {
            return !isPositive();
        }
    }

    static final class CustomNumberCollection {
        private Collection<CustomNumber> customNumbers;

        CustomNumberCollection(Collection<CustomNumber> customNumbers) {
            this.customNumbers = customNumbers;
        }

        Collection<CustomNumber> getCustomNumbers() {
            return customNumbers;
        }
    }
}
