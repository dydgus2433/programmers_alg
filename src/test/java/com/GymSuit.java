package com;

public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
       // n은 배열의 개수         
       int[] students = new int[n];
               
       // 기본 체육복 수 1개
       for(int i = 0; i < n; i++) {
           students[i] = 1;
       }
       
       // 잃어버리면 -1 
       for(int j = 0; j < lost.length; j++) {
           students[lost[j]-1]--;
       }
       
       // 여분 있으면 +1
       for(int j = 0; j < reserve.length; j++) {
           students[reserve[j]-1]++;
       }
       
       // i 가 0이면 n+1만 확인
       // i가 1이면 n-1 // n+1 확인
       // i가 n-1 이면 n-2만 확인
       for(int i = 0; i < n; i++) {
           // 학생이 없을 경우 
          if(students[i] == 0) {
              // 0인 경우는 -1이 없기때문에 1만 검사하면됨 
              if(i == 0) {
                  if(students[i+1] == 2) {
                      students[i+1]--;
                      students[i]++;
                  }    
               // 배열의 최대인덱스 (n-1)의 경우는 뒷배열이 없기 때문에 최종배열 앞[n-1-1]만 검사
              }else if(i == n-1) {
                  if(students[i-1] == 2) {
                      students[i-1]--;
                      students[i]++;
                  } 
              }else {             
                  // 2개면 빌려주는 코드
                  if(students[i-1] == 2) {
                      students[i-1]--;
                      students[i]++;
                      // 이미 빌려줬기에 2번째껀 할 필요가 없음
                      continue;
                  } 
                  
                  if(students[i+1] == 2) {
                      students[i+1]--;
                      students[i]++;
                  }    
              }
          }
       }
       // 체육복 1개 이상있는 학생 카운트
       for(int i = 0; i < n; i++) {
           if(students[i] > 0) {
               answer++;
           }
       }
       
       return answer;
   }
}
