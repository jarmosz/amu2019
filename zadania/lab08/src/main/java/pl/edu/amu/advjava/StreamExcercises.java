package pl.edu.amu.advjava;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

final class StreamExcercises {

    /*
         ZADANIE: dla podanej kolekcji zwróć sumę opakowanych liczb.
     */
    static int sum(Collection<CustomNumber> numbers) {
        return numbers.stream().mapToInt(x -> x.getNumber()).sum();
    }

    /*
         ZADANIE: dla podanej kolekcji zwróć tylko te nieujemne.
     */
    static List<CustomNumber> positiveNumbers(Collection<CustomNumber> numbers) {
        return numbers.stream().filter(x -> x.isPositive()).collect(Collectors.toList());
    }

    /*
         ZADANIE: dla podanej kolekcji zwróć kolekcję zawierającą kwadraty opakowanych liczb.
     */
    static List<Integer> squares(Collection<CustomNumber> numbers) {
        return numbers.stream().map(x -> x.getNumber() * x.getNumber()).collect(toList());
    }

    /*
         ZADANIE: dla podanej kolekcji zwróć sumę liczb ujemnych z kolekcji.
     */
    static int sumOfNegativeNumbers(Collection<CustomNumber> numbers) {
        return numbers.stream().filter(x -> x.isNegative()).mapToInt(x -> x.getNumber()).sum();
    }

    /*
         ZADANIE: dla podanej kolekcji iloczyn liczb z wszystkich kolekcji.
     */
    static long productOfNumbers(Collection<CustomNumberCollection> customNumberCollection) {
        return customNumberCollection.stream().flatMap(x -> x.getCustomNumbers().stream()).mapToInt(x -> x.getNumber()).reduce(1, (x,y) -> x * y);
    }

    /*
         ZADANIE: zwracana mapa powinna zawierać jako klucz kwadrat liczby z kolekcji, a jako wartość - liczby,
         które są pierwiastkami kwadratowymi tej liczby.
     */
    static Map<Integer, Set<Integer>> squareRoots(Collection<CustomNumber> numbers) {
        return numbers.stream().map(CustomNumber::getNumber).collect(groupingBy(x -> x*x, toCollection(HashSet::new)));
    }

    static final class CustomNumber {
        int number;

        CustomNumber(int number) {
            this.number = number;
        }

        int getNumber() { return this.number; }

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
