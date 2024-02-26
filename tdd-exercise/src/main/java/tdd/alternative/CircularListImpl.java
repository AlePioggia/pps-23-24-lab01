package tdd.alternative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CircularListImpl implements CircularList {

    private List<Integer> list = new ArrayList<>();
    private List<Integer> reversedList = new ArrayList<>();
    private Iterator<Integer> iterator;

    public CircularListImpl() {
        this.iterator = this.list.iterator();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
        this.iterator = this.list.iterator();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        this.iterator = this.list.iterator();
        return getIterator();
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        this.reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        this.iterator = this.reversedList.iterator();
        return getIterator();
    }

    private Iterator<Integer> getIterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!iterator.hasNext()) {
                    iterator = list.iterator();
                }
                return iterator.next();
            }
        };
    }
}
