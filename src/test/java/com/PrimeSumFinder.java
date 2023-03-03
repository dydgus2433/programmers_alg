package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimeSumFinder {

    public int solution(int[] arr) {
        int sosuCount = 0;
        for(int i = 0 ; i < arr.length-2; i++){
            for(int j  = i +1 ; j < arr.length-1; j++){
                for(int k = j+1; k < arr.length; k++){
                    if(sosu(i+j+k)){
                        sosuCount++;
                    }
                }
            }
        }

        return sosuCount;
    }

    public boolean sosu(int a){
        int count = 0;
        for(int i = a-1; i > 2; i--){
            if(a%i == 0){
                count ++;
                break;
            }
        }
        return count == 0;
    }

    @Test
    public void test(){
        assertEquals( Integer.toBinaryString(78), "1001110");
        assertEquals( solution(new int[]{1,2,3,4}), 1);
        assertEquals( solution(new int[]{1,2,7,6,4}), 4);
    }
    
}
