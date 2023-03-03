package com;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Scoville {
    public int solution(int[] scoville, int K) {
        // 가장 낮은 두개의 숫자 찾기 
            int minScoville = 0;
            int arrLength = scoville.length;
            int count = 0;
            int temp[];
            
            while(true){     
                Arrays.sort(scoville);   
                minScoville = scoville[0]; 
                if(minScoville >= K ){
                    break;
                }                        
                if(arrLength-count < 2 && minScoville < K){
                    count = -1;
                    break;
                }
                
                scoville[1] = calc(scoville[0],scoville[1]);     
                count++;
                temp = new int[scoville.length -1];
                for(int i =0; i < temp.length;i++){
                    temp[i] = scoville[i+1];
                }    
                scoville =  temp;
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
