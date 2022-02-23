package ca.bytetube._00_leetcode.array;

public class BubbleSort {
    
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1 ; j++) {

                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }

            }
        }
        
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
        int[] arr = {4,-7,3,10,5,1};
        printArray(arr);
        sort(arr);
        System.out.println();
        System.out.println("after sort:");
        printArray(arr);
    }
}
