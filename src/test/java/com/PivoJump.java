package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PivoJump {
   
    int[] arr;

    public int solution(int n) {
        arr = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        int s = pivoFunction(n);
        return s;
    }

    public int pivoFunction(int n){

        if(n == 0 || n == 1 || n == 2){
            return arr[n];
        }
        
        if(arr[n] > 0 && n >= 2){
            return arr[n];
        }

        arr[n] = (pivoFunction(n-1) + pivoFunction(n-2) )% 1234567;     
        return arr[n];
    }

    

    @Test
    public void test(){
        assertEquals(this.solution(3), 3);
        assertEquals(this.solution(4), 5);
        assertEquals(this.solution(5), 8);
        assertEquals(this.solution(6), 13);
        assertEquals(this.solution(7), 21);
    }
    
}
