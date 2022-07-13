package ca.bytetube._00_leetcode.array;

public class FindMaxInversionOfArray {
    public static void main(String[] args) {
        int[] arr = {1,5,4,3,2,6,7,2,8};
        int[] inversion = FindMaxInversionOfArray(arr);
        System.out.println(inversion[0]);
        System.out.println(inversion[1]);
    }

   public static int[] FindMaxInversionOfArray(int[] nums){
       if (nums == null || nums.length == 0|| nums.length == 1) return null;
       if (nums.length == 2)  return nums[1] == Math.max(nums[0], nums[1]) ? new int[]{-1, -1} : new int[]{0, 1};
       //从左向右扫描，得到数组最大逆序对的右区间
       int max = nums[0];
       int r  = -1;
       for (int cur = 1; cur < nums.length; cur++) {
           if (nums[cur] >= max) {
               max = nums[cur];
           }else {
               r = cur;
           }
       }
       //从右向左扫描，得到数组最大逆序对的左区间
       int min = nums[nums.length - 1];
       int l  = -1;
       for (int cur = nums.length - 2; cur >= 0; cur--) {
           if (nums[cur] <= min) {
               min = nums[cur];
           }else {
               l = cur;
           }

       }

       return new int[]{l,r};
   }

}
