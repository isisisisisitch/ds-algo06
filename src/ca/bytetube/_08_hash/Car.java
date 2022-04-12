package ca.bytetube._08_hash;

public class Car {
    private String brand;
    private int miles;
    private double width;




    @Override
    public int hashCode(){//hash算法可以自己指定
        //string
        int hashCode = Integer.hashCode(miles);
        hashCode =  hashCode * 31 + Double.hashCode(width);
        hashCode =  hashCode * 31 +(brand != null ? brand.hashCode() : 0);


        return hashCode;
    }

}
