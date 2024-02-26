import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList = new CircularListImpl();

    @BeforeEach
    public void setUp() {
        this.circularList = new CircularListImpl();
    }

    @Test
    public void testIsEmptyMethod() {
        assertTrue(this.circularList.isEmpty());
    }

}
