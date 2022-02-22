package ca.bytetube._04_queue.list;

public abstract class AbstractList<E> implements List<E> {
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
         return  indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }


    public void rangeCheck(int index){
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("error index :"+ index );
        }

    }

    public void rangeCheckForAdd(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("error index :"+ index );
        }

    }



}
