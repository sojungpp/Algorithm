import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        
        while(left <= right) {
            answer++;
            if(people[left]+people[right] <= limit) {
                left++;
                right--;
            }
            else {
                right--;
            }
        }

        return answer;
    }
}