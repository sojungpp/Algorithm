class Solution {
    public String solution(String phone_number) {
        String temp = phone_number.substring(phone_number.length()-4);
        String answer = "*".repeat(phone_number.length()-4) + temp; 
        return answer;
    }
}