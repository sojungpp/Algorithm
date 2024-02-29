class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        char[] values = my_string.toCharArray();
        for(char value : values){
            answer += String.valueOf(value).repeat(n);
        }
        
        return answer;
    }
}