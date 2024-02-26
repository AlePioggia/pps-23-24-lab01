package tdd.filtered;

import java.util.Optional;
import java.util.function.Predicate;

import tdd.CircularListImpl;

public class CircularFilteredListImpl extends CircularListImpl implements CircularFilteredList{
    

    public CircularFilteredListImpl() {
        super();
    }

    @Override
    public Iterable<Optional<Integer>> filteredNext(Predicate<Integer> predicate) throws Exception {
        throw new Exception();
    }

    
}
