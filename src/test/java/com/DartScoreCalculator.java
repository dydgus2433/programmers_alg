package com;

public class DartScoreCalculator {
    public int solution(String dartResult) {
        int answer = 0;
        String temp = "";
        int score[] = {0,0,0,0,0};
        int index = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            // 글자 추출
            char num = dartResult.charAt(i);
            // 숫자면 추가 
            if (num > 47 && num < 58) {
                temp += num;
                continue;
            } else {
                int originScore = 0;
                if (!"".equals(temp)) {
                    originScore = Integer.parseInt(temp);
                    // 숫자로 확인되면 다음 index 
                    index++;
                    temp = "";
                }
                switch (num) {
                    case 'S':
                        score[index] += originScore;
                        break;
                    case 'D':
                        originScore = (int) Math.pow(originScore, 2);
                        score[index] += originScore;
                        break;
                    case 'T':
                        originScore = (int) Math.pow(originScore, 3);
                        score[index] += originScore;
                        break;
                    case '*':
                        score[index - 1] *= 2;
                        score[index] *= 2;
                        break;
                    case '#':
                        score[index] *= -1;
                        break;
                }
            }


        }

        for (int i = 0; i < score.length; i++) {
            answer += score[i];
        }
    
        return answer;
    }
}
