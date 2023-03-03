package com;

public class Lottery {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
         int rightCount = 0 ;
         
         for(int lotto : lottos) {
             // 0의 개수 
             if(lotto == 0) {
                 zeroCount++;
             }
             // 맞은 개수(0과 중복 안됨 어차피)
             for(int win_num : win_nums) {
                 if(lotto == win_num) {
                     rightCount++;
                 }
             }
         }        
         // 최대 등수는 맞은 개수 + 0의 개수
         // 최소 등수는 맞은 개수
         int[] answer = { Math.min(7- (rightCount + zeroCount), 6)   ,  Math.min(7 - rightCount, 6)};
         return answer;
     }
}
