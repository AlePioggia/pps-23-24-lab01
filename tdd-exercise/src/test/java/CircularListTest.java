import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;

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
        this.circularList.add(0);
        this.circularList.add(1);
        assertEquals(this.circularList.size(), 2);
    }

    @Test
    public void testNext() {
        this.circularList.add(0);
        this.circularList.add(1);
        assertEquals(this.circularList.next().get(), 0);
        assertEquals(this.circularList.next().get(), 1);
        assertEquals(this.circularList.next().get(), 0);
    }

    @Test
    public void testPrevious() {
        this.circularList.add(0);
        this.circularList.add(1);
        this.circularList.add(2);
        assertEquals(this.circularList.previous().get(), 2);
        assertEquals(this.circularList.previous().get(), 1);
        assertEquals(this.circularList.previous().get(), 0);
        assertEquals(this.circularList.previous().get(), 2);
    }

    @Test
    public void testReset() {
        this.circularList.add(0);
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.next();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(this.circularList.next().get(), 0);
    }

}
