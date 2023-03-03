package com;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Scoville1 {
    public int solution(int[] scoville, int K) {
        // 가장 낮은 두개의 숫자 찾기 
            int minScoville = 0;
            int arrLength = scoville.length;
            int count = 0;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
            for(int i : scoville){
                maxHeap.add(i);
            }
            while(true){     
                if(maxHeap.peek() >= K ){
                    break;
                }                        
                if(arrLength-count < 2 && minScoville < K){
                    count = -1;
                    break;
                }
                
                maxHeap.add(calc(maxHeap.poll(),maxHeap.poll()));     
                count++;   
            }
            
            return count;
        }
        
        public int calc(int a, int b){
            return a + (b*2);
        }

    
	@Test
	void contextLoads() {
		assertEquals(this.solution(new int[] {1, 2, 3, 9, 10, 12}, 7), 2);
	}
    
}
