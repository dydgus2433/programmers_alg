package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SumConsecutiveNumbersFinder {
    static int[][] arr; // 전역변수 배열 선언

    public int solution(int n) {
        int answer = 1; // 리턴값을 1로 초기화
        arr = new int[n + 2][n + 2]; // 전역배열에 대한 크기 할당
        for (int i = 1; i <= n / 2; i++) { // 1~n/2 까지 반복
            int sumNum = 0;
            for (int j = i; j < n; j++) { // i부터 n까지 반복
                sumNum = sum(i, j); // sum함수로 i~j 합을 구함
                if (sumNum == n) { // 합이 n과 같을 경우
                    answer++; // 정답수 1 증가
                    break; // 반복 종료
                }
                if (sumNum > n) { // 합이 n보다 큰 경우
                    break; // 반복 종료
                }
            }
        }
        return answer; // 정답 반환
    }

    public int sum(int start, int end) { // i~j 까지의 합을 계산하는 함수
        int sumNum = 0;

        if (start > 0 && end > 0) { // 전역변수 배열에 값이 있는 경우
            if (arr[start][end - 1] != 0) { // 전에 계산한 배열의 값이 있는 경우
                sumNum += arr[start][end - 1] + end; // 계산 결과 배열에 넣음
                arr[start][end] = sumNum; // 계산된 결과값을 배열에 저장
                return sumNum; 
            }

        }

        for (int i = start; i <= end; i++) { // i부터 j까지 반복
            sumNum += i; // i~j 합을 계산하여 sumNum에 저장
        }
        arr[start][end] = sumNum; // 계산된 결과값을 배열에 저장
        return sumNum; 
    }

    @Test
    public void test() {
        assertEquals(this.solution(4), 1); 
        assertEquals(this.solution(15), 4); 
    }

}
