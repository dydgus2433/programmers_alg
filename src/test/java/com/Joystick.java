package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Joystick {
    public int solution(String name) {
        int answer = 0;
        int minMove = name.length() - 1; // 최소 좌우 이동 초기화

        char[] arrCh = name.toCharArray();

        for(int i = 0; i < arrCh.length; i++){
            answer += getDistance(arrCh[i]);

            // 다음 변경해야 할 알파벳의 위치 찾기
            int next = i + 1;
            while (next < arrCh.length && arrCh[next] == 'A') {
                next++;
            }

            // 현재 위치에서 가장 가까운 변경해야 할 문자로 이동하는 횟수
            int move = i + name.length() - next + Math.min(i, name.length() - next);
            minMove = Math.min(minMove, move);
        }

        return answer + minMove;      
    }


    public int getDistance(char c ){
        return (int)Math.min(c-'A', 'Z'-c + 1);
    }

    public int getPriority(){
        return 0;
    }
    @Test
    public void test1(){                
        assertEquals(this.getDistance('A'), 0);
        assertEquals(this.getDistance('Z'), 1);
    }

    @Test
    public void test(){                
        assertEquals(this.solution("JEROEN"), 56);
        assertEquals(this.solution("JAN"), 23);
    }
    
}
