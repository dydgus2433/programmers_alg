package com;

public class ParenthesesChecker {
    boolean solution(String s) {
        boolean answer = true;
       for(int i = 0; i < s.length(); i++){
           if('(' == s.charAt(i)){
               int count = 1;
               for(int j = i+1; j < s.length();j++){
               if('(' == s.charAt(j)){
                   count++;
               }    
                   if(')' == s.charAt(j)){count--;}
                   if(count == 0){ i = j; break; }
                      
                   
                   }
               if(count > 0){
                   answer = false;
                   }
           }else{
               answer =  false;
           }
           
       }
       
        return answer;
           
    
        }
}
