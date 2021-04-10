package com.it.yousefl.dataalgo.da.courseleetcode;

public class SlidingWindow {

    public static void main(String[] args) {

        int[] arr = {80, -50, 90, 100};
        System.out.println(maxSum(arr, 2));
        System.out.println(maxSum2(arr, 2));
    }

    //TODO:-Brute Force Approach
    public static int maxSum(int[] arr, int k) {
        // Java code here
        // O(n*k) solution for finding
        // maximum sum of a subarray
        // of size k
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n - k + 1; i++) {
            int currentSum = 0;
            for (int j = 0; j < k; j++) {
                currentSum += arr[i + j];
            }
            max = Math.max(max, currentSum);
        }
        return max;
    }

    //TODO:-Sliding Window
    public static int maxSum2(int[] arr, int k) {
   // n must be greater
        int n = arr.length;
        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }
        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - k];//
            max_sum = Math.max(max_sum, window_sum);
        }
        return max_sum;
    }
}
