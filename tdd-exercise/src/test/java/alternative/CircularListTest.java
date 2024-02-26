package alternative;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.alternative.CircularList;
import tdd.alternative.CircularListImpl;

public class CircularListTest {
    CircularList circularList;

    @BeforeEach
    public void setUp() {
        this.circularList = new CircularListImpl();
    }

    @Test
    public void testForwardIterator() {
        Iterator<Integer> iterator = this.circularList.forwardIterator();
        this.populateList();
        for (int i = 0; i < 4; i++) {
            iterator.next();
        }
        assertEquals(iterator.next(), 1);
    }

    private void populateList() {
        this.circularList.add(0);
        this.circularList.add(1);
        this.circularList.add(2);
    }

}
