import java.util.*;

class Solution {
    
    private final int ASCII_A = (int)'A';
    private final int ASCII_Z = (int)'Z';
    private final int ASCII_a = (int)'a';
    private final int ASCII_z = (int)'z';
    private final int ASCII_BLANK = (int)' ';
    
    public String solution(String s, int n) {
        char[] inputs = s.toCharArray();
        String answer = "";
        for(int i=0; i<inputs.length; i++) {
            char word;
            int input = (int)inputs[i];
            int code = input+n;
            if(code-n == ASCII_BLANK) word = inputs[i];
            else if((code >= ASCII_A && code <= ASCII_Z) || 
                   (code >= ASCII_a && code <= ASCII_z && input>ASCII_Z)) word = (char)code;
            else word = (char)(code-26);
            answer += word;
        }
        return answer;
    }
}