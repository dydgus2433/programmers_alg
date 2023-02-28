package com.example.test.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Test20230225 {

    public int solution(int n) {
        int a = n;
        String aStr = Integer.toBinaryString(a);
        int aCount = 0;

        for(int i = 0 ; i < aStr.length(); i++){
            if('1' == aStr.charAt(i)){
                aCount++;
            }
        }
        while(true){
            a++;
            int b = Integer.parseInt(Integer.toBinaryString(a),2);
            String bStr = Integer.toBinaryString(b);            
            int bCount = 0;    

            for(int i = 0 ; i < bStr.length(); i++){
                if('1' == bStr.charAt(i)){
                    bCount++;
                }
            }
            if(aCount == bCount){
                break;
            }
            
        }

        return a;
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
        assertEquals( solution(78), 83);
        assertEquals( solution(15), 23);
    }
    
}
