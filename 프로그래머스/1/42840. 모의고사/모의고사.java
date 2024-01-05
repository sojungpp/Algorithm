import java.util.*;

class Solution {
    
    private int[] people1(int[] answers) {
        List<Integer> answerSheets = new ArrayList<>();
        for(int i=1; i <= answers.length; i++){
            if(i%5 == 0) answerSheets.add(5);
            else answerSheets.add(i%5);
        }
        return answerSheets.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int[] people2(int[] answers) {
        List<Integer> answerSheets = new ArrayList<>();
        for(int i=1; i <= answers.length; i++){
            if(i%2 == 1) answerSheets.add(2);
            else if(i%8 == 2) answerSheets.add(1);
            else if(i%8 == 4) answerSheets.add(3);
            else if(i%8 == 6) answerSheets.add(4);
            else answerSheets.add(5);
        }
        return answerSheets.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int[] people3(int[] answers) {
        List<Integer> answerSheets = new ArrayList<>();
        for(int i=1; i <= answers.length; i++){
            if(i%10 == 1 || i%10 == 2) answerSheets.add(3);
            else if(i%10 == 3 || i%10 == 4) answerSheets.add(1);
            else if(i%10 == 5 || i%10 == 6) answerSheets.add(2);
            else if(i%10 == 7 || i%10 == 8) answerSheets.add(4);
            else answerSheets.add(5);
        }
        return answerSheets.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private Integer mark(int[] answerSheets, int[] answers) {
        Integer score = 0;
        for(int i=0; i<answers.length; i++) {
            if(answerSheets[i] == answers[i]) score++;
        }
        return score;
    }
    
    private int[] findMaxScore(Map<Integer, Integer> people) {
         int maxScore = people.values().stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);

        return people.entrySet().stream()
                .filter(entry -> entry.getValue() == maxScore)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
    
    
    public int[] solution(int[] answers) {
        Map<Integer, Integer> people = new HashMap<>();
        people.put(1, mark(people1(answers), answers));
        people.put(2, mark(people2(answers), answers));
        people.put(3, mark(people3(answers), answers));
        
        return findMaxScore(people);
    }
}