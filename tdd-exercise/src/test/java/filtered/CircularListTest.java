package filtered;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.filtered.CircularListImpl;
import tdd.filtered.CircularList;

public class CircularListTest {
    private CircularList circularList;
    private static final int OVERLOAD = 2000;

    @BeforeEach
    public void setUp() {
        this.circularList = new CircularListImpl();
    }

    @Test
    public void testFilteredNextWithEvenNumbers() {
        this.populateList();
        Optional<Integer> element = this.circularList.filteredNext((n) -> n % 2 == 0);
        assertEquals(element.get(), 0);
    }

    @Test
    public void testFilteredNextWithOddNumbers() {
        this.populateList();
        Optional<Integer> element = this.circularList.filteredNext((n) -> n % 2 == 1);
        assertEquals(element.get(), 1);
    }

    @Test
    public void testFilteredNextWithWrongCondition() {
        this.populateList();
        Optional<Integer> element = this.circularList.filteredNext((n) -> n > OVERLOAD);
        assertEquals(element, Optional.empty());
    }

    @Test
    public void testFilteredNextOnEmptyList() {
        Optional<Integer> element = this.circularList.filteredNext((n) -> n % 2 == 1);
        assertEquals(element, Optional.empty());
    }

    private void populateList() {
        for (int i = 0; i < 4; i++) {
            this.circularList.add(i);
        }
    }

}
