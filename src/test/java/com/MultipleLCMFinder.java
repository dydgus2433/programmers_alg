package com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MultipleLCMFinder {

    HashMap<Integer,Integer> list = new HashMap<>();
    public int solution(int[] arr) {
        int answer = 1;


        for(int number : arr){
            getLCM(number);
        }
        Set<Integer> set = list.keySet();
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            Integer i = it.next();
            int num1 = isNotNull(list.get(i)) ? list.get(i) : 0;
            for(int k = 0 ; k < num1; k++){
                answer *= i;
            }
        }
         
        list = new HashMap<>();
        return answer;
    }
    
    // 소인수 구하기 
    public HashMap<Integer,Integer> getSoinsu(int num){
        int temp = num;
        HashMap<Integer,Integer> list = new HashMap<>();
        for(int i = 2; i <= num; i++){
            if(temp < i){
                break;
            }

            int count = 0;
            // temp나눠진값이 0이면 계속 나눠
            while(temp % i == 0){
                temp = temp / i;
                count++;

                if(temp == 1){
                    break;
                }
            }
            if(count > 0){
                list.put(i, count);
            }
        }
        return list;
    }

    public boolean isNotNull(Integer num){
        return num != null;
    }

    
    public void getLCM(int a){
        HashMap<Integer,Integer> list2 = getSoinsu(a); // 6  = 2 (1), 3 (1)

        Set<Integer> set = list2.keySet();
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            Integer i = it.next();
            int num1 = isNotNull(list.get(i)) ? list.get(i) : 0;
            int num2 = isNotNull(list2.get(i)) ? list2.get(i) : 0;

            if(num2 > num1){
                list.put(i, num2);
            }
        }
    }



    @Test
    public void getLCM(){
        assertEquals(this.solution(new int[]{2,3}), 6);
        
        assertEquals(this.solution(new int[]{2,4}), 4);
    }

    @Test
    public void test1(){
        assertEquals(this.solution(new int[]{12, 32, 45, 67, 72}), 96480);
    }

    @Test
    public void test(){
        assertEquals(this.solution(new int[]{13,26}), 26);
        assertEquals(this.solution(new int[]{17,34}), 34);
        assertEquals(this.solution(new int[]{2,3,4}), 12);
        assertEquals(this.solution(new int[]{4,6,8}), 24);
        assertEquals(this.solution(new int[]{2,6,8,16,14}), 336);
        assertEquals(this.solution(new int[]{2,6,8,14}), 168);
        assertEquals(this.solution(new int[]{7,11,13}), 1001);
        assertEquals(this.solution(new int[]{9, 10, 15}), 90 );
        assertEquals(this.solution(new int[]{1,2,3}), 6);
        assertEquals(this.solution(new int[]{1,2,3,7}), 42);
        assertEquals(this.solution(new int[]{1,3,7}), 21);
    }
}
