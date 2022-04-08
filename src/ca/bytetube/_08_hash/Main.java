package ca.bytetube._08_hash;

public class Main {

    public static void main(String[] args) {
        float num = 10.5f;
        int bits = Float.floatToIntBits(num);
       // System.out.println(bits);//1093140480
        int hashCode = str_hash_code("jack");
        System.out.println(hashCode);//3254239

    }

    public static int str_hash_code(String s){
        int hashCode = 0;
        //jack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashCode = (hashCode << 5) - hashCode + c;
        }

        return hashCode;

    }
}
