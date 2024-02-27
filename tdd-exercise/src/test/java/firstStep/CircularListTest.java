package firstStep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.firstStep.CircularList;
import tdd.firstStep.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    public void setUp() {
        this.circularList = new CircularListImpl();
    }

    @Test
    public void testIsEmptyMethod() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testSize() {
        this.populateList();
        assertEquals(this.circularList.size(), 3);
    }

    @Test
    public void testNext() {
        this.populateList();
        assertEquals(this.circularList.next().get(), 0);
        assertEquals(this.circularList.next().get(), 1);
        assertEquals(this.circularList.next().get(), 2);
        assertEquals(this.circularList.next().get(), 0);
    }

    @Test
    public void testPrevious() {
        this.populateList();
        assertEquals(this.circularList.previous().get(), 2);
        assertEquals(this.circularList.previous().get(), 1);
        assertEquals(this.circularList.previous().get(), 0);
        assertEquals(this.circularList.previous().get(), 2);
    }

    @Test
    public void testReset() {
        this.populateList();
        this.circularList.next();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(this.circularList.next().get(), 0);
    }

    private void populateList() {
        this.circularList.add(0);
        this.circularList.add(1);
        this.circularList.add(2);
    }
}
