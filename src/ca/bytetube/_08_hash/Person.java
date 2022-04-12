package ca.bytetube._08_hash;

import java.util.HashMap;

public class Person {
    private int age;
    private float height;
    private String name;
    //private Car car;

    public Person(int age, float height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    /**
     * 重写equals方法的目的：
     * 当发生hash冲突时，用来比较2个key是否相等
     *
     * 假设有一个index的位置上连接了多个node，这时我们再插入一个新key时，让它先生成自己的hashCode，
     * 生成完code之后通过%运算得到bucket array中对应的index，
     * 假设新的key所对应的index和之前key所对应的index是相同的，
     * 既然index相同，我们就需要用这个key和list上其他node所对应的key去进行比较，
     * 如果是同一个key，则覆盖
     * 如果key不相同，则再list后追加新node
     *
     *
     *为什么不能拿hashCode作为equals比较的标准？
     * 原因：
     * 1.不同类型数据计算得到相同的hashcode值 long num = 974872356; String s = "bytetube";
     * 2.相同类型的数据也有可能计算出相同的hashcode值 [50,16.7f,"jack"] [45,18.3f,"pony"]
     *
     */
//    public boolean equals(Object obj){
//        if (this == obj) return true;
//        if (obj == null || obj.getClass() != this.getClass()) return false;
//        Person person = (Person)obj;
//        return person.age == this.age && person.height == this.height
//                && person.name == null ? name == null: person.name.equals(this.name);
//    }


    @Override
    public int hashCode(){//hash算法可以自己指定
        //string
        int hashCode = Integer.hashCode(age);
        hashCode =  hashCode * 31 + Float.hashCode(height);
        hashCode =  hashCode * 31 +(name != null ? name.hashCode() : 0);
        //hashCode =  hashCode * 31 +(car != null ? car.hashCode() : 0);

        return hashCode;
    }

    public static void main(String[] args) {
        Person p1 = new Person(50,16.7f,"jack");

        Person p2 = new Person(50,16.7f,"jack");

        String s = "bytetube";
//       System.out.println( p1.equals(p2));
        System.out.println(p1.hashCode());//1580066828
        System.out.println(p2.hashCode());//491044090
        HashMap<Object,Object> hashMap = new HashMap<>();
        hashMap.put(p1,"abc");
        hashMap.put(p2,"bcd");
        hashMap.put(s,"ccc");
       // System.out.println(hashMap.size());
        //equals key

        //1.只重写了equals的话，不重写hashcode，size = 1/2
        //1.只重写了hashcode的话，不重写equals，size = 2



    }




}
