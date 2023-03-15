package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimeSumFinder {

    public int solution(int[] arr) {
        int primeCount = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (isPrime(arr[i] + arr[j] + arr[k])) {
                        primeCount++;
                    }
                }
            }
        }
        return primeCount;
    }
    
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Test
    public void test(){
        assertEquals( Integer.toBinaryString(78), "1001110");
        assertEquals( solution(new int[]{1,2,3,4}), 1);
        assertEquals( solution(new int[]{1,2,7,6,4}), 4);
    }
    
}
