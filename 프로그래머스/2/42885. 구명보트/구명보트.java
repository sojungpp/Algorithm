import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int answer = 0;

        while(left <= right){
            answer++;
            // 같이 탈 수 있는 경우
            if(people[left]+people[right]<=limit){
                right--;
                left++;
            } else right--;
        }
        return answer;
    }
}
