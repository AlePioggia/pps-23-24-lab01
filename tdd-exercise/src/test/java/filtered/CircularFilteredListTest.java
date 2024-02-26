package filtered;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularListImpl;
import tdd.filtered.CircularFilteredList;
import tdd.filtered.CircularFilteredListImpl;

public class CircularFilteredListTest {
    private CircularFilteredList circularFilteredList;

    @BeforeEach
    public void setUp() {
        this.circularFilteredList = new CircularFilteredListImpl();
    }

    @Test
    public void testFilteredNextWithEvenNumbers() throws Exception {
        this.populateList();
        List<Optional<Integer>> evenNumbersList = StreamSupport
            .stream(this.circularFilteredList.filteredNext((n) -> n % 2 == 0).spliterator(), false)
            .collect(Collectors.toList());
        assertEquals(evenNumbersList, List.of(0, 2));
    }

    @Test
    public void testFilteredNextWithOddNumbers() throws Exception {
        this.populateList();
        List<Optional<Integer>> evenNumbersList = StreamSupport
            .stream(this.circularFilteredList.filteredNext((n) -> n % 3 == 1).spliterator(), false)
            .collect(Collectors.toList());
        assertEquals(evenNumbersList, List.of(1, 3));
    }

    private void populateList() {
        ((CircularListImpl) this.circularFilteredList).add(0);
        ((CircularListImpl) this.circularFilteredList).add(1);
        ((CircularListImpl) this.circularFilteredList).add(2);
        ((CircularListImpl) this.circularFilteredList).add(3);
    }

}
