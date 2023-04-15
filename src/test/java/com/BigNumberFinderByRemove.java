package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class BigNumberFinderByRemove {
    
    public String solution(String answer, int k) {
        Stack<Character> stack = new Stack<>();
        int n = answer.length();
        
        for (int i = 0; i < n; i++) {
            char digit = answer.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() < digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        
        return sb.toString();
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
