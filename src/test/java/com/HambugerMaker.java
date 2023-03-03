package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HambugerMaker {
    
    public int solution(int[] ingredient) {
        // 빵 1 야채 2 고기 3 빵 1 
        // 1 2 3 1 이면 
        String hamberger = "1231";
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        for(int i  : ingredient){
            sb.append(i);
            if(sb.length() > 3 &&  sb.subSequence(sb.length()-4, sb.length()).equals(hamberger)){
                answer++;
                sb.delete(sb.length()-4, sb.length());               
            }
        }

        return answer;
    }


    @Test
    public void test(){
        assertEquals(this.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}), 2);

        // 2, 1, 1, 2, 3, 1, 2, 3, 1  // 2,3,4,5  = 0

        // 2, 1, 0, 0, 0, 0, 2, 3, 1  // 1, 0은 pass , 6,7,8


    }

    
    @Test
    public void test1(){
        assertEquals(this.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}), 0);
    }

    
    @Test
    public void test3(){
        assertEquals(this.solution(new int[]{1, 2, 1, 2, 3, 1, 3, 1, 1, 2, 3, 1}), 3);
    }
    
    
}
