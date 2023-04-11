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
        String max =  "";
        String number = "0123456789";
        for(int i = 0 ; i < number.length(); i++){
            String indexFinder =number.substring(i, i+1);
            if(answer.indexOf(indexFinder) > -1){
                String ex = answer.replaceFirst(indexFinder, "") ;
                max = max.compareTo(ex) > 0 ? max :  answer.replaceFirst(indexFinder, "") ;
            }
        }
        return  max;
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
