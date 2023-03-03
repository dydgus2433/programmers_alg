package com;

public class StringToNumberConverter {
    public int solution(String s) {        
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j <= s.length(); j++) {
                String tempStr = s.substring(i,j);    
                // 숫자인지 확인 아니면 한글자 더해서 검사         
                // 한글자씩 비교해가면서 숫자뜻이 있는지 확인                
                if(isNumber(tempStr) || isAlphaNumber(tempStr)) {
                    result += chageStringToNumber(tempStr);
                    i++;
                    continue;
                }
            }
        }        
        int answer = Integer.parseInt(result);
        return answer;
    }

    public boolean isNumber(String s) {       
        boolean isNumber = false;
        switch (s) {
            case "1":  
            case "2":  
            case "3":  
            case "4":  
            case "5": 
            case "6": 
            case "7":  
            case "8": 
            case "9":
            case "0":    
                isNumber = true;
                break;
        }        
        return isNumber;
    }

    public boolean isAlphaNumber(String s) {       
        boolean isNumber = false;
        switch (s) {
            case "zero":  
            case "one":  
            case "two":  
            case "three":  
            case "four": 
            case "five": 
            case "six":  
            case "seven": 
            case "eight":
            case "nine":    
                isNumber = true;
                break;
        }        
        return isNumber;
    }

    public String chageStringToNumber(String s) {       
        String number = "0";
        switch (s) {
            case "zero": 
            case "0": 
                number = "0";
                break;
            case "one":  
            case "1":  
                number = "1";
                break;
            case "two": 
            case "2":  
                number = "2";
                break;
            case "three": 
            case "3":
                number = "3";
                break; 
            case "four": 
            case "4": 
                number = "4";
                break;
            case "five": 
            case "5": 
                number = "5";
                break;
            case "six":  
            case "6":  
                number = "6";
                break;
            case "seven": 
            case "7": 
                number = "7";
                break;
            case "eight":
            case "8":
                number = "8";
                break;
            case "nine":  
            case "9":    
                number = "9";
                break;
        }        
        return number;
    }

}
