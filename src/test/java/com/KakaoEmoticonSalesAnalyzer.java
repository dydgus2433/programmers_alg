package com;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class KakaoEmoticonSalesAnalyzer {
    public int[] solution(int[][] users, int[] emoticons) {
        int joinNum = 0;
        int sum = 0;
        int[] per = {10,20,30,40};

        
        for(int k =0 ; k < per.length; k++){    
            int perJoin = 0;
            int perSum = 0;
            for(int i = 0; i<users.length;i++){  
                int userPer = users[i][0];
                int userPrice = users[i][1];
                boolean isJoin = false;
                int sumPrice = 0;
                for(int j = 0; j < emoticons.length; j++){
                        if(userPer >= per[k]){   
                            // 이모티콘당 
                            sumPrice += emoticons[j] * (double) (100 - per[k]) * (double)(0.01);
                        }

                        if(sumPrice > userPrice){
                            isJoin = true;
                            break;
                        }
                        
                }

                if(isJoin){
                    perJoin++;
                }else{
                    perSum += sumPrice;
                }
            }

            if(perJoin > joinNum){
                joinNum =   perJoin;
                sum = perSum;
            }else if(perJoin == joinNum && perSum > sum){
                sum = perSum;    
            }
        }
            return new int[] {joinNum,sum};
    }

    @Test
    public void test(){
        assertArrayEquals(this.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[] {7000, 9000}), new int[] {1, 5400});
        assertArrayEquals(this.solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}, 
        new int[] {1300, 1500, 1600, 4900}), new int[] {4, 13860});
    }
}
