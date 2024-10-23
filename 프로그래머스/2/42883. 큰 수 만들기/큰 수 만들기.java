import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String[] numbers = number.split("");
        int num = numbers.length - k;
        String answer = "";
        int index = 0;
        while(answer.length() != num) {
            int standard = numbers.length - num + answer.length() + 1;
            for(int i=index; i<standard; i++) {
                if(Integer.parseInt(numbers[i]) > Integer.parseInt(numbers[index])) index = i;
                if(numbers[index].equals("9")) break;
            }
            answer += numbers[index];
            index++;
        }
        
        

        return answer;
    }
}