package com.company;

/**
 * class Ex14
 */
public class Ex14 {

    /**
     *findMinDiff is a function that returns the minimum distance between two given values in an array
     * running complexity O(n),place complexity O(4)
     * @param a the given array
     * @param x first given value
     * @param y second given value
     * @return minimum distance between two given values in an array
     */
    public static int findMinDiff(int[] a, int x, int y) {
        int minDistance = Integer.MAX_VALUE, tempX = -1, tempY = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                tempX = i;
                // tempY>-1 in order to see if the y value is in the array
                if (tempY > -1)
                    if (minDistance > tempX - tempY)
                        minDistance = tempX - tempY;
            }
            if (a[i] == y) {
                tempY = i;
                // tempX>-1 in order to see if the x value is in the array
                if (tempX > -1)
                    if (minDistance > tempY - tempX)
                        minDistance = tempY - tempX;
            }
        }
        return minDistance;
    }

    /**
     * search is a function that check's if a given number is in the give sorted two dimensional arraY
     * running complexity O(Log4N),place complexity O(3)
     * @param mat a given sorted two dimensional array
     * @param num a given number
     * @return true if the given number is in the array
     */
    public static boolean search(int[][] mat, int num) {
        int length = mat.length / 2, i = 0, j = 0;
        while (length >= 1) {

            //biggest part of the array
            if ((mat[i + length][j] <= num))
                i = i + length;
            //second biggest part of the array
            else if ((mat[i + length][j + length] <= num)) {
                i = i + length;
                j = j + length;
                // third biggest part of the array and if num is smaller then this
                // its in the smallest part of the array i,j don't change
            } else if ((mat[i][j + length] <= num))
                j = j + length;
            if ((mat[i][j] == num)) {
                System.out.println();
                System.out.println("row ="+i);
                System.out.println("col ="+j);
                return true;
            }

            length = length / 2;
        }
        return false;
       // return search(mat,num, mat.length/2,0,0);
    }
/*
    public static boolean search(int[][] mat, int num, int length, int i, int j) {
        if (!(mat[i][j]>num)) {
            if (mat[i][j] == num) {
                System.out.println();
                System.out.println("row ="+i);
                System.out.println("col ="+j);
                return true;
            }
            if (length >= 1)
                return  search(mat, num, length / 2, i + length, j)
                        || search(mat, num, length / 2, i + length, j + length)
                        || search(mat, num, length / 2, i, j + length)
                        || search(mat, num, length / 2, i, j);
        }
        return false;
    }

    ***************it's a great solution so i didn't want to discard it**************
 */

    /**
     *
     * @param arr
     * @return
     */
    public static boolean equalSplit(int[] arr) {
        if (arr.length % 2 != 0)
            return false;

        return equalSplit(arr,0,0,0,0,0);
    }

    /**
     *
     * @param arr
     * @param i
     * @param sum1
     * @param sum2
     * @param counter1
     * @param counter2
     * @return
     */
    public static boolean equalSplit(int[] arr,int i,int sum1,int sum2,int counter1,int counter2) {
        if (i==arr.length)
            return sum1==sum2&&counter1==counter2;
        return equalSplit(arr,i+1,sum1+arr[i],sum2,counter1+1,counter2)
                ||equalSplit(arr,i+1,sum1,sum2+arr[i],counter1,counter2+1);
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean isSpecial (int n){
        return isSpecial(2,n);
    }

    /**
     *
     * @param delete
     * @param place
     * @return
     */
    public static boolean isSpecial (int delete,int place){
        if (place%delete==0)
            return false;
        if (place<delete) {
            System.out.println(place);
            return true;
        }
        return isSpecial(delete+1,place-place/delete);
    }

}
