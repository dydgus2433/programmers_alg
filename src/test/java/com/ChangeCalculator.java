package com;

public class ChangeCalculator {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0 ;
        for(int i = 1; i <= count; i++){
            sum += price * i;
        }
        answer = money - sum;
        return  answer >= 0 ? 0 : Math.abs(answer);
    }
}
