public interface IBag<E> {
    public void add(E item);

    public E remove(int index);

    public boolean contains(E item);

    public boolean empty();
}