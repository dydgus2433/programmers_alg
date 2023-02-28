package com.example.test.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ongali {
    public int solution(String[] babbling) {
        
        String[] validSounds = {"aya", "ye", "woo", "ma"};
        int wordCount = 0;
        for (String word : babbling) {
            String lastSound = null;
            String tempWord = word;
            int start = 0;
            for (int i = 0; i <= word.length(); i++) {
                String sound = word.substring(start, i);

                if(sound.equals(lastSound)){
                    break;
                }

                if (Arrays.asList(validSounds).contains(sound) ) {
                    lastSound = sound;
                    tempWord = tempWord.replaceFirst(sound, "");
                    start = i;
                }

            }
            if(tempWord.length() == 0){
                wordCount++;
            }
        }
        return wordCount;
    }
    

    @Test
    public void test(){
        assertEquals(3, solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa","ayawooye"}));
      //  assertEquals(1, solution(new String[]{"aya", "yee", "u", "maa"}));
        
    }

    @Test
    void testSolution() {
        String[] babbling1 = {"aya", "yee", "u", "maa"};
        int result1 = solution(babbling1);
        assertEquals(1, result1);

        String[] babbling2 = {"aya", "ye", "woo", "ma"};
        int result2 = solution(babbling2);
        assertEquals(4, result2);

        String[] babbling3 = {"aya", "yee", "woo", "maa", "ayaya", "ma"};
        int result3 = solution(babbling3);
        assertEquals(3, result3);
    }
    
}
