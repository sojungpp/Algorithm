class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        for(int value: index_list){
            answer += my_string.charAt(value);
        }
        return answer;
    }
}