class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] stringList = my_string.toCharArray();
        for(char target : stringList){
            if(Character.isUpperCase(target)) answer += Character.toLowerCase(target);
            else answer += Character.toUpperCase(target);
        }
        return answer;
    }
}