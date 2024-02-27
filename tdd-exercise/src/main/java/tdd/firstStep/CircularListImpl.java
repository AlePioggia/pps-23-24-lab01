package tdd.firstStep;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> list = new ArrayList<>();
    private ListIterator<Integer> iterator;

    public CircularListImpl() {
        this.iterator = this.list.listIterator();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
        this.iterator = this.list.listIterator();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (!this.iterator.hasNext()) {
            this.iterator = this.list.listIterator();
        }
        return Optional.of(this.iterator.next());
    }

    @Override
    public Optional<Integer> previous() {
        if (!this.iterator.hasPrevious()) {
            this.iterator = this.list.listIterator(list.size());
        }
        return Optional.of(this.iterator.previous());
    }

    @Override
    public void reset() {
        this.iterator = this.list.listIterator();
    }

}
