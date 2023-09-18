import java.util.*;

public class SortedBag<E> implements IBag<E> {// sorted bag implements generics bag interface
    private ArrayList<E> data = data = new ArrayList<E>();// arraylist to store all the elements;

    public void add(E item) {// add items
        int i = 0;// keeps track of index
        while (true) {
            if (data.size() == 0 || i >= data.size()) {// if array is empty or we've reached the end of the array append
                                                       // it to the end.
                data.add(item);
                return;
            } else {
                if (((String) item).compareTo(data.get(i).toString()) > 0) {// continue if item is greater than the
                                                                            // current index
                    i++;
                } else {
                    data.add(i, item);// add item to index
                    return;
                }
            }
        }
    }

    public E remove(int index) {
        return data.remove(index);// returns removed item
    }

    public boolean contains(E item) {
        return data.contains(item);// returns true if item is in array else false
    }

    public boolean empty() {
        data = new ArrayList<E>();// creates a new arraylist
        if (data.size() == 0) {
            return true;// return true if empty
        } else {
            return false;// returns true if something goes wrong
        }
    }
}
