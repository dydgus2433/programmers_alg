package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PivoFinder {

    int[] arr;

    public int solution(int n) {
        System.out.printf("%d %n",n);
        arr = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;
        int s = pivoFunction(n);
        //int test = s %1234567;
        return s;
    }

    public int pivoFunction(int n){

        if(n == 0 || n == 1){
            return arr[n];
        }
        
        if(arr[n] > 0 && n >= 2){
            
            System.out.printf("path 1 : n : %d, arr[n] : %d %n", n, arr[n]);
            return arr[n];
        }

        arr[n] = (pivoFunction(n-1) + pivoFunction(n-2) )% 1234567;     
        System.out.printf("path 2 :  n : %d, arr[n] : %d %n", n, arr[n]);
        return arr[n];
    }

    @Test
    public void test(){
        assertEquals(this.solution(3), 2);
        assertEquals(this.solution(5), 5);
        assertEquals(this.solution(6), 8);
        assertEquals(this.solution(10), 55);
        assertEquals(this.solution(30), 832040);
        assertEquals(this.solution(35), 9227465%1234567);
        assertEquals(this.solution(40), 102334155%1234567);
        assertEquals(this.solution(50), 12586269025L%1234567);
    }
    
}
