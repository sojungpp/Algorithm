import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        ArrayList<Integer> rank = new ArrayList<>();
        for(int[] s : score){
            rank.add(s[0] + s[1]);
        }
        Collections.sort(rank, Collections.reverseOrder());
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            answer[i] = rank.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
    }
}