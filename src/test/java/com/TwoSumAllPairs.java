package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class TwoSumAllPairs {
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
}
