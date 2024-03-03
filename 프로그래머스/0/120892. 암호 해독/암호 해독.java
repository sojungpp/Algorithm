class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        char[] values = cipher.toCharArray();
        for(int i=0; i<values.length; i++){
            if(i%code == code-1) answer += values[i];
        }
        return answer;
    }
}