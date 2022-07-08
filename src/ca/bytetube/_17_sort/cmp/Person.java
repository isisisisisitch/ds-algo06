package ca.bytetube._17_sort.cmp;

import java.util.ArrayList;

public class Person implements Comparable<Person>{

    int age;
    String name;

    @Override
    public int compareTo(Person o) {
        return 0;
    }


    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(p1);
        personArrayList.add(p2);
        //...

    }


}
