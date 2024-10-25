import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int max = 0;
        
        int[][] person = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        for(int i=0; i<3; i++) {
            int[] personAnswer = person[i];
            int num = check(personAnswer, answers);
            if(max < num) {
                answer.clear();
                answer.add(i+1);
                max = num;
            } else if(max == num) answer.add(i+1);
            
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int check(int[] personAnswer, int[] answers) {
        int cnt = 0;
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == personAnswer[i%personAnswer.length]) cnt++;
        }
        return cnt;
    }
}