package com.it.yousefl.dataalgo.da.hackerrank;

public class Array2d {

    public static void main(String[] args) {

        int[][] lottery = {
                {20, 15, 7},
                {8, 7, 19},
                {7, 13, 47}
        };

        int[][] let = new int[3][3];
        let[0][0] = 10;

        //[row][column]

        System.out.println(lottery[0][0]);
    }


    /**
     * Q:-
     * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
     */
// Complete the hourglassSum function below.
    public static int hourglassSum(int[][] arr) {

        int row = arr.length;
        int colomnus = arr[0].length;

        int max_hour_glass_sum = Integer.MIN_VALUE;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < colomnus - 2; j++) {
                int current_hour_glass_sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1] +
                        arr[i + 2][j]
                        + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                max_hour_glass_sum = Math.max(max_hour_glass_sum, current_hour_glass_sum);
            }
        }
        return max_hour_glass_sum;
    }

}