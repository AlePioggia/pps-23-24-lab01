package tdd.alternative;

import java.util.Iterator;

public interface CircularList {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * 
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * 
     * @return a new java.util.Iterator, which yields next elements, circularly
     */
    Iterator<Integer> forwardIterator();
}
