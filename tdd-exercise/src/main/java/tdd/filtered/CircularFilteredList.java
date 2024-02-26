package tdd.filtered;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularFilteredList {
    Iterable<Optional<Integer>> filteredNext(Predicate<Integer> predicate) throws Exception;
}
