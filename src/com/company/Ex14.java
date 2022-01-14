package com.company;

/**
 *
 */
public class Ex14 {

    /**
     * O(n),O(4)
     *
     * @param a
     * @param x
     * @param y
     * @return
     */
    public static int findMinDiff(int[] a, int x, int y) {
        int minDistance = Integer.MAX_VALUE, tempX = -1, tempY = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                tempX = i;
                if (tempY > -1)
                    if (minDistance > tempX - tempY)
                        minDistance = tempX - tempY;
            }
            if (a[i] == y) {
                tempY = i;
                if (tempX > -1)
                    if (minDistance > tempY - tempX)
                        minDistance = tempY - tempX;
            }
        }
        return minDistance;
    }

    /**
     *
     * @param mat
     * @param num
     * @return
     */
    public static boolean search(int[][] mat, int num) {
        return search(mat,num, mat.length/2,0,0);
    }

    /**
     *
     * @param mat
     * @param num
     * @param length
     * @param i
     * @param j
     * @return
     */
    public static boolean search(int[][] mat, int num, int length, int i, int j) {
        if (!(mat[i][j]>num)) {
            if (mat[i][j] == num) {
                System.out.println();
                System.out.println("row ="+i);
                System.out.println("col ="+j);
                return true;
            }
            if (length >= 1)
                return search(mat, num, length / 2, i, j)
                        || search(mat, num, length / 2, i + length, j)
                        || search(mat, num, length / 2, i + length, j + length)
                        || search(mat, num, length / 2, i, j + length);
        }
        return false;
    }

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
        return isSpecial(n,2,n);
    }

    /**
     *
     * @param n
     * @param delete
     * @param place
     * @return
     */
    public static boolean isSpecial (int n,int delete,int place){
        if (place%delete==0)
            return false;
        if (place<delete) {
            System.out.println(place);
            return true;
        }
        return isSpecial(n,delete+1,place-place/delete);
    }

}
