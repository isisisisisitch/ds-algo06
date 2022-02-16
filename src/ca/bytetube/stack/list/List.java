package ca.bytetube.stack.list;

public interface List<E> {

    public static final int ELEMENT_NOT_FOUND = -1;
    int size(); // Number of elements

    boolean isEmpty(); // Is it empty

    boolean contains(E element); //Contains a certain element

    void add(E element); // Add elements to the end

    E get(int index); // Returns the element corresponding to the index position

    E set(int index, E element); // Set the element at the index position

    void add(int index, E element); // Add elements to the index position

    E remove(int index); // Delete elements to the index position

    int indexOf(E element); // Return the index of the element

    void clear(); // Clear all the elements
}
