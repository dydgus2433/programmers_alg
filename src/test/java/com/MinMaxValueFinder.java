package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinMaxValueFinder {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] ss = s.split(" ");
        for(String str : ss){
            int temp = Integer.parseInt(str);
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        return min + " " + max;
    }

    @Test
    public void test(){
        assertEquals(solution("1 2 3 4"), "1 4");
        assertEquals(solution("-1 -2 -3 -4"), "-4 -1");
    }
}
