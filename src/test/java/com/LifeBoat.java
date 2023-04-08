package com;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int cnt = 0;
            for(int i = people.length-1; i >= 0; i--){
            int bigNum = people[i];
            if(bigNum < 40){
                continue;
            }
            if( bigNum > limit - people[cnt] && i != 0 ){
                people[i] = -1;
                answer++;
                continue;
            }
            if(limit == bigNum){
                people[i] = -1;
                answer++;
                continue;
            }else if(limit > bigNum){
                int stadardNum = limit - bigNum;
                int deleteElement = -1;
                for(int j =cnt; j < i; j++){
                    if(people[j] < 40){
                        continue;
                    }
                    if(stadardNum >= people[j]){
                        deleteElement = j;
                        people[j] = -1;   
                        cnt++;
                    }
                    break;
                }
                if(deleteElement >= 0){                    
                 people[deleteElement] = -1;
                 people[i] = -1;  
                 answer++;
                }else{
                    people[i] = -1;    
                    answer++;
                }
            }


        }
        // for(int i = 0; i < people.length; i++){
        //     int smallNum = people[i];
        //     if(smallNum < 40){
        //         continue;
        //     }
        //     if( smallNum > limit - smallestNum && i != 0 ){
        //         people[i] = -1;
        //         answer++;
        //         continue;
        //     }
        //     if(limit == smallNum){
        //         people[i] = -1;
        //         answer++;
        //         continue;
        //     }else if(limit > smallNum){
        //         int stadardNum = limit - smallNum;
        //         int deleteElement = -1;
        //         for(int j =people.length-1-i; j > 0; j--){
        //             if(people[j] < 40){
        //                 continue;
        //             }
        //             if(stadardNum >= people[j]){
        //                 deleteElement = j;
        //                 people[j] = -1;   
        //                 break;
        //             }
        //         }
        //         if(deleteElement >= 0){                    
        //          people[deleteElement] = -1;
        //          people[i] = -1;  
        //          answer++;
        //         }else{
        //             people[i] = -1;    
        //             answer++;
        //         }
        //     }


        // }
        return answer;
    }

    @Test
    public void test(){
        assertEquals(this.solution(new int[]{70, 50, 80, 50},100), 3);
        assertEquals(this.solution(new int[]{70, 80,  50},100), 3);
        assertEquals(this.solution(new int[]{40, 40,  40},120), 2);
        assertEquals(this.solution(new int[]{40, 40,  40,40},120), 2);
        assertEquals(this.solution(new int[]{40, 40,  50,50},90), 2);
    }
}
