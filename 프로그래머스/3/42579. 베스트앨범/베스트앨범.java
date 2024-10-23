import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreNum = new HashMap<>();
        Map<String, Map<Integer, Integer>> genreList = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            int temp = genreNum.getOrDefault(genres[i], 0)+plays[i];
            genreNum.put(genres[i], temp);
            
            Map<Integer, Integer> list = new HashMap<>();
            list = genreList.getOrDefault(genres[i], list);
            list.put(i, plays[i]);
            genreList.put(genres[i], list);
        }
        
        List<Integer> answer = new ArrayList<>();
        List<String> genreNumList = new ArrayList<>(genreNum.keySet());
        genreNumList.sort((a, b) -> genreNum.get(b) - genreNum.get(a));
        
        for(int i=0; i<genreNumList.size(); i++) {
            Map<Integer, Integer> temp = genreList.get(genreNumList.get(i));
            List<Integer> tempList = new ArrayList<>(temp.keySet());
            tempList.sort((a, b) -> {
                if(temp.get(a) != temp.get(b)) return temp.get(b) - temp.get(a);
                else return a-b;
            });
            
            int standard = Math.min(2, tempList.size());
            for(int j=0; j<standard; j++) {
                answer.add(tempList.get(j));
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}