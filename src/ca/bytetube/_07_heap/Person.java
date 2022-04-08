package ca.bytetube._07_heap;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private double salary;


    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "age=" + age ;
    }


    @Override
    public int compareTo(Person p) {

       //return (int) (this.salary-p.salary);
        return Double.compare(p.salary,this.salary);
    }

    public static void main(String[] args) {
        Person p = new Person("dal",32,432.5);
        Person p2 = new Person("ada",31,432.2);
        System.out.println(p.compareTo(p2));


    }
}
