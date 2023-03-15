package com;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MultipleLCMFinder {

    HashSet<Integer> set = new HashSet<>();
    public int solution(int[] arr) {
        int answer = 1;


        for(int number : arr){
            getInsu(number);
        }
        Iterator<Integer> it =  set.iterator();
         
        while(it.hasNext()){
            answer *= it.next();
        }
        set = new HashSet<>();
        return answer;
    }
    
    
    public void getInsu(int number){
        int cnt = 0;
        for(int i = 2; i < number; i++){
           
            if(number%i == 0)  {
                cnt++;
                set.add(i);
                
            }
        }
        
         if(cnt == 0){
            set.add(number);
         }           
        
    }

    @Test
    public void test(){
        assertEquals(this.solution(new int[]{2,6,8,14}), 168);
        assertEquals(this.solution(new int[]{2,6,8,16,14}), 336);

        assertEquals(this.solution(new int[]{1,2,3}), 6);
        assertEquals(this.solution(new int[]{1,2,3,7}), 42);
        assertEquals(this.solution(new int[]{1,3,7}), 21);
    }
}
