package ca.bytetube._13_divide;

public class GetMaxFromArray {
    public static void main(String[] args) throws Exception {
        int max = getMax(new int[]{5, -4, 7, 6, 3, 13, 25, 11});
        System.out.println(max);
    }


    public static int getMax(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) throw new Exception("data error");
        if (arr.length == 1) return arr[0];

        return getMax(arr, 0, arr.length - 1);
    }

    private static int getMax(int[] arr, int left, int right) {
        if (left == right) return arr[left];

        int mid = (left + right) >> 1;

        int leftMax = getMax(arr, left, mid);
        int rightMax = getMax(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }
}
