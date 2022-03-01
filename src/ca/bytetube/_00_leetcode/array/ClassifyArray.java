package ca.bytetube._00_leetcode.array;

public class ClassifyArray {


    public static void sortColors(int[] nums) {
        classifyArray(nums,1);
    }


    public static int[] classifyArray(int[] arr,int num){
      return   classify(arr,0,arr.length-1, num);
    }


    private static int[] classify(int[] arr,int l, int r,int num){
        int less = l - 1;
        int more = r + 1;
        while (l < more){
            if (arr[l] < num)   swap(arr,++less,l++);
            else if (arr[l] > num)  swap(arr,-- more ,l);
            else  l++;
        }

        return arr;

    }


    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    public static void printArray(int[] arr){
        for (int element : arr) {
            System.out.print(element+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,9,70,3,-4,11,90,43,85,47};
        printArray(arr);
        int[] classifyArray = classifyArray(arr, 43);
        System.out.println("==================");
        printArray(classifyArray);
    }


}
