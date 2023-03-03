package com;

public class MbtiSolution {
    static int[] arr = new int[] {0, -3, -2, -1, 0, 1, 2, 3};
    static String str = "RTCFJMAN"; // EISNTFPJ
    
    public String solution(String[] survey, int[] choices) {
    int[] scoreArr = new int[8];
        String answer = "";
        for (int i =0; i < choices.length; i++) {
            int score =  arr[choices[i]];            
            String sur = survey[i];
            int startIndex = str.indexOf(sur.substring(0, 1));
            int endIndex = str.indexOf(sur.substring(1, 2));
            if (score > 0) {
                scoreArr[endIndex] += score;
            }
            if (score < 0) {
                scoreArr[startIndex] += Math.abs(score);
            }
        }

        for (int i = 0; i < 8; i += 2) {
            if (scoreArr[i] < scoreArr[i + 1]) {
                answer += str.substring(i + 1, i + 2);
            } else {
                answer += str.substring(i, i + 1);
                // 같으면
            }
        }
        return answer;
    }
}
