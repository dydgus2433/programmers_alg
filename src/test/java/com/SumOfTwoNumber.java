package com;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class SumOfTwoNumber {
    public int[] solution(int[] numbers) {
        
        HashSet<Integer> set = new HashSet<>();
               
        for(int i = numbers.length-1 ; i > 0; i--){  
            for(int j = i-1; j >= 0; j--){
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        int cnt = 0;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            answer[cnt] =  (int)it.next();
            cnt++;
        }
        Arrays.sort(answer);
        return  answer;
    }

    @Test
    public void test(){
        assertArrayEquals(this.solution(new int[]{2,1,3,4,1}), new int[]{2,3,4,5,6,7});
    }
    
}
