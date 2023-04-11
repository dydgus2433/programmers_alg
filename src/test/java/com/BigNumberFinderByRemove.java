package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BigNumberFinderByRemove {
    public String solution(String number, int k) {
        String answer = number;

        for(int i =0 ; i < k; i++){
            answer = getBigNumberByRemove(answer);
        }

        return answer;
    }


    private String getBigNumberByRemove(String answer) {
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < answer.length(); i++){
            min = Math.min(min, Integer.parseInt(answer.substring(i, i+1)));
        }
       

        return  answer.replaceFirst(min+"", "");
    }

    @Test
    public void test(){
        assertEquals(this.solution("1924",1), "924");
    }


    @Test
    public void test4(){
        assertEquals(this.solution("1924",2), "94");
    }

    @Test
    public void test1(){
        assertEquals(this.solution("1231234",3), "3234");
    }

    @Test
    public void test2(){
        assertEquals(this.solution("4177252841",4), "775841");
    }
}
