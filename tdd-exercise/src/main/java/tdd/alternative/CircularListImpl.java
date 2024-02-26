package tdd.alternative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> list = new ArrayList<>();
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
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!iterator.hasNext()) {
                    iterator = list.listIterator();
                }
                return iterator.next();
            }

        };
    }

}
