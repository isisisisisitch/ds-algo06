package ca.bytetube._08_hash;

import java.util.HashMap;

public class Person {
    private int age;
    private float height;
    private String name;

    public Person(int age, float height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    public int hashCode(){//hash算法可以自己指定
        //string
        int hashCode = Integer.hashCode(age);
        hashCode =  hashCode * 31 + Float.hashCode(height);
        hashCode =  hashCode * 31 +(name != null ? name.hashCode() : 0);


        return hashCode;
    }

    public static void main(String[] args) {
        Person p1 = new Person(50,16.7f,"jack");

        Person p2 = new Person(50,16.7f,"jack");
//       System.out.println( p1.equals(p2));
        System.out.println(p1.hashCode());//1580066828
        System.out.println(p2.hashCode());//491044090
        HashMap<Object,Object> hashMap = new HashMap<>();
        hashMap.put(p1,"abc");
        hashMap.put(p2,"bcd");
        System.out.println(hashMap.size());
        //compare equals
    }


}
