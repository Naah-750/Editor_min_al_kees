import java.util.LinkedList;

public class LinkedStack<E> extends LinkedList<E> implements Stack<E>{
    @Override
    public boolean add(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public E top() {
        return super.getFirst();
    }

    @Override
    public E pop() {
        return super.removeFirst();
    }
}
