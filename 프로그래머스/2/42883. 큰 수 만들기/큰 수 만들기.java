class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int index = 0;
        while(answer.length() != number.length()-k) {
            int standard = k + answer.length();
            for(int i=index; i<=standard; i++) {
                if(number.charAt(i) > number.charAt(index)) index=i;
                if(number.charAt(index) == '9') break;
            }
            answer += String.valueOf(number.charAt(index));
            index++;
        }

        return answer;
    }
}