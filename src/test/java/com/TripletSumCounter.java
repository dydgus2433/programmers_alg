package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TripletSumCounter {

    public int solution(int[] number) {
        int answer = 0;


        for(int i =0 ; i < number.length; i ++){
            for(int k = i+1; k < number.length; k++){
                for(int j = k+1; j < number.length; j++){
                    if(testArr(number,i,k,j) == 0){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public int testArr(int[] number, int a, int b, int c){
        int result = number[a] + number[b] + number[c];
        return result;
    }

    
    public int testFunction( int a, int b){
        return 0;
    }

    

    @Test
    public void test(){                      // 0 1 2 3 4
        assertEquals(this.solution(new int[]{-2, 3, 0, 2, -5}), 2);
        assertEquals(this.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}), 5);
        assertEquals(this.solution(new int[]{-1,1,-1,1}), 0);
    }
    // 3 개는 조합 1개   f(3,3) = 1;
    // 4개는 조합 4개    f(4,3) = 4;
    // 5개는 조합 10개   f(5,3) = 10;
    //                  f(6,3) = 17;
    // @Test
    // public void test22(){       // 0    1   2   3   4   5 
    //     int [] number = new int[]{-3,   -2, -1, 0,  1,  2}; 
    //     assertEquals(this.testArr(number,0,1,2 ), -6);
    //     assertEquals(this.testArr(number,0,1,3 ), -5);
    //     assertEquals(this.testArr(number,0,1,4 ), -4);
    //     assertEquals(this.testArr(number,0,1,5 ), -3);

    //     assertEquals(this.testArr(number,0,2,3 ), -4);
    //     assertEquals(this.testArr(number,0,2,4 ), -3);
    //     assertEquals(this.testArr(number,0,2,5 ), -2);

    //     assertEquals(this.testArr(number,0,3,4 ), -2);
    //     assertEquals(this.testArr(number,0,3,5 ), -1);

    //     assertEquals(this.testArr(number,1,2,3 ), -3);
    //     assertEquals(this.testArr(number,1,2,4 ), -2);
    //     assertEquals(this.testArr(number,1,2,5 ), -1);

    //     assertEquals(this.testArr(number,1,3,4 ), -1);
    //     assertEquals(this.testArr(number,1,3,5 ), 0);

    //     assertEquals(this.testArr(number,2,3,4 ), 0);
    //     assertEquals(this.testArr(number,2,3,5 ), 1);

    //     assertEquals(this.testArr(number,3,4,5 ), 3);
    // }
    
    
}

