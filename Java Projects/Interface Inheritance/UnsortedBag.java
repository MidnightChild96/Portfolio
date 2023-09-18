import java.util.*;

public class UnsortedBag<E> implements IBag<E> {
    private ArrayList<E> data = new ArrayList<E>();

    public void add(E item) {
        data.add(item);
    }

    public E remove(int index) {
        E item = data.remove(index);
        return item;
    }

    public boolean contains(E item) {
        return data.contains(item);
    }

    public boolean empty() {
        data = new ArrayList<E>();
        if (data.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
