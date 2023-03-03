package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class triangleMaxSum {
    public int solution(int[][] triangle) {   
        int answer = 0;
        int[][] dp = triangle;
        for(int i =1 ; i < triangle.length; i++){  
            for(int j = 0; j < triangle[i].length; j++){     
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }   else if(j == i){
                   dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
                }                
            }      
        }

        for(int i =0 ; i < triangle.length; i++){
           answer = Math.max(answer,  dp[triangle.length-1][i]);
        }

    
        
        return answer;
    }

    @Test
    public void test(){
        int[][] triangle = {{1}, {1, 1}, {1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1, 2}};
        assertEquals(this.solution(triangle), 6);


    }

    
    @Test
    public void test1(){
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        assertEquals(this.solution(triangle), 30);
    }

    
    @Test
    public void test3(){
        int[][] triangle = {{1}, {1, 1}, {1, 2, 1}, {1, 2, 2, 1}, {1, 1, 1, 1, 7}};
        assertEquals(this.solution(triangle), 11);
    }
    
    
}
