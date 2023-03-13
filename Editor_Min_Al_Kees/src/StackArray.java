import javax.swing.*;

public class StackArray<E> implements Stack<E> {

    private int t = -1;
    static final int cap = 20;
    private E[] data;

    public StackArray() {
        data = (E[]) new Object[cap];
    }

    @Override
    public boolean isEmpty() {
        return t==-1;
    }

    @Override
    public int size() {
        return t+1;
    }

    @Override
    public E top() {
        if (isEmpty())
        return null;
        return data[t];
    }

    @Override
    public void push(E e) {
        if (size()==data.length)
            JOptionPane.showMessageDialog(null,"Cant add more shapes, You've reached the limit.");
        else data[++t] = e;
    }

    @Override
    public E pop() {
        if (isEmpty())
        return null;
        E deleted = data[t];
        data[t] = null;
        t--;
        return deleted;
    }
}
