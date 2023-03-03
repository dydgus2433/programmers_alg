package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class MissingNumberSumFinder {

    public int solution(int[] arr) {
       int sum = 0;
       ArrayList<Integer> arrList = new ArrayList<>();
       for(int i = 0 ; i < arr.length; i++){
        arrList.add(arr[i]);
       }

       for(int i = 0 ; i < 10; i++){
            if(arrList.indexOf(i) < 0){
                sum += i;
            }
       }

    return sum;
    }

    /*

     */
    @Test
    public void test(){
        assertEquals( solution(new int[]{1,2,3,4,6,7,8,0}), 14);
        assertEquals( solution(new int[]{5,8,4,0,6,7,9}), 6);
    }
    
}
