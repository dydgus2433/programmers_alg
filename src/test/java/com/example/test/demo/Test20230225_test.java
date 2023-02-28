package com.example.test.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Test20230225_test {

    public int solution(int[] arr) {
        int sosuCount = 0;
        for(int i = 0 ; i < arr.length-2; i++){
            for(int j  = i +1 ; j < arr.length-1; j++){
                for(int k = j+1; k < arr.length; k++){
                    if(sosu(i+j+k)){
                        sosuCount++;
                    }
                }
            }
        }

        return sosuCount;
    }

    public boolean sosu(int a){
        int count = 0;
        for(int i = a-1; i > 2; i--){
            if(a%i == 0){
                count ++;
                break;
            }
        }
        return count == 0;
    }
    /*
자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

제한 사항
n은 1,000,000 이하의 자연수 입니다.
입출력 예
n	result
78	83
15	23

     */
    @Test
    public void test(){
        assertEquals( Integer.toBinaryString(78), "1001110");
        assertEquals( solution(new int[]{1,2,3,4}), 1);
        assertEquals( solution(new int[]{1,2,7,6,4}), 4);
    }
    
}
