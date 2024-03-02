class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[] strings = my_string.toCharArray();
        for(char s : strings){
            if(s >= '1' && s <= '9') answer += (int) s - 48;
        }
        return answer;
    }
}