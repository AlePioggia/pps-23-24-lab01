package secondStep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.secondStep.CircularList;
import tdd.secondStep.CircularListImpl;

public class CircularListTest {
    private final static int FORWARD_STEPS = 4;
    private final static int BACKWARD_STEPS = 3;
    CircularList circularList;

    @BeforeEach
    public void setUp() {
        this.circularList = new CircularListImpl();
    }

    @Test
    public void testForwardIterator() {
        Iterator<Integer> iterator = this.circularList.forwardIterator();
        this.populateList();
        this.iterate(iterator, FORWARD_STEPS);
        assertEquals(iterator.next(), 1);
    }

    @Test
    public void testBackwardIterator() {
        Iterator<Integer> iterator = this.circularList.backwardIterator();
        this.populateList();
        this.iterate(iterator, BACKWARD_STEPS);
        assertEquals(iterator.next(), 0);
    }

    private void iterate(Iterator<Integer> iterator, int stepsNumber) {
        for (int i = 0; i < stepsNumber; i++) {
            iterator.next();
        }
    }

    private void populateList() {
        this.circularList.add(0);
        this.circularList.add(1);
        this.circularList.add(2);
    }

}
