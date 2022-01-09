package com.company;

/**
 *
 */
public class Ex14 {

    /**
     *
     * @param a
     * @param x
     * @param y
     * @return
     */
    public static int findMinDiff (int[] a, int x, int y){
        int minDistance=Integer.MAX_VALUE,tempX=-1,tempY=-1;
        for (int i=0;i< a.length;i++){
            if (a[i]==x){
                tempX=i;
                if (tempY>-1)
                    if (minDistance>tempX-tempY)
                    minDistance=tempX-tempY;
            }
            if (a[i]==y){
                tempY=i;
                if (tempX>-1)
                    if (minDistance>tempY-tempX)
                        minDistance=tempY-tempX;
            }
        }
       return minDistance;
    }

}
