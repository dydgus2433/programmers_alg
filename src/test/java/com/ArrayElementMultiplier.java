package com;

import java.util.Arrays;

public class ArrayElementMultiplier {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);        
        Arrays.sort(B);
        // desc 정렬이 없어서 Integer로 변경 후 곱함
        // Integer b[] = Arrays.stream(B).boxed().toArray(Integer[]::new);         
        // Arrays.sort(b, Collections.reverseOrder());
        
        for(int i = 0 ; i < A.length; i++){
            answer += A[i] * B[A.length-i-1];
        }

        return answer;
    }
}
