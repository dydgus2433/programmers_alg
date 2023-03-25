package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class PrefixPhoneNumber {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;

    
        Arrays.sort(phoneBook);
        for(int i = 0 ; i < phoneBook.length-1; i++){
            String phoneCheck = phoneBook[i];
            String phoneStr = phoneBook[i+1];
            if(phoneStr.startsWith(phoneCheck) ){
                answer = false;
                break;
            }

        }
        
        return answer;
    }
    /*
    
    public boolean solution(String[] phoneBook) {
        boolean answer = true;

    
        Arrays.sort(phoneBook);
        for(int i = 0 ; i < phoneBook.length-1; i++){
            String phoneCheck = phoneBook[i];
            for(int k = i+1; k < phoneBook.length; k++){
                String phoneStr = phoneBook[k];
                if(phoneStr.startsWith(phoneCheck) ){
                    answer = false;
                    break;
                }
            }            
            if(!answer){
                break;
            }

        }
        
        return answer;
    }
     */

    @Test
    public void test(){
        assertEquals(solution(new String[]{"119", "97674223", "1195524421"}), false);
        assertEquals(solution(new String[]{"123","456","789"}), true);
        assertEquals(solution(new String[]{"1235","567","88"}), true);
    }
}
