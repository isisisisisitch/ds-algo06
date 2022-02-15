package ca.bytetube.list.single;

import ca.bytetube.list.AbstractList;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> {

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 15;

    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {

        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        this.elements =  (E[]) new Object[capacity];

    }



    // Clear all the elements
    public void clear(){
        size = 0;
    };


    // Add elements to the index position
    public void add(int index, E element){

        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index ; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    };


    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;//size
        if (oldCapacity >= capacity) {
           return;
        }else {
            //当前容量已经不够了，需要扩容
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            E[] newElements = (E[]) new Object[newCapacity];

            //数据的迁移
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }


    // Delete elements to the index position
    public E remove(int index){

        rangeCheck(index);

       E oldElement =  elements[index];

        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        elements[--size] = null;

        return oldElement;
    };


    // Set the element at the index position
    public E set(int index, E element){
        rangeCheck(index);
        E oldElement =  elements[index];
        elements[index] = element;
        return oldElement;
    };



    // Returns the element corresponding to the index position
    public E get(int index){
        rangeCheck(index);

        return elements[index];
    };


    // Return the index of the element
    public int indexOf(E element){
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }

        }else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element))  return i;
            }
        }


        return ELEMENT_NOT_FOUND;
    };


    @Override
    public String toString() {
        return "ArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(10);
        integerArrayList.add(20);
        integerArrayList.add(30);
        integerArrayList.add(40);
        System.out.println(integerArrayList);
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("bytetube1");
        stringArrayList.add("bytetube2");
        stringArrayList.add("bytetube3");
        stringArrayList.add("bytetube4");
        System.out.println(stringArrayList);
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(10);
//        arrayList.add(20);
//        arrayList.add(30);
//        arrayList.add(40);
//        arrayList.add(2,null);
//        //arrayList.remove(2);
//        arrayList.set(1,100);
//        arrayList.add("bytetube");
//        System.out.println(arrayList.size());
//        System.out.println(arrayList.indexOf(null));

    }

}
