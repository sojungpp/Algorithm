import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();        
        for(int i=0; i<T; i++){

            Map<Integer, List<Integer>> teamMap = new HashMap<>();
            Map<Integer, Integer> countMap = new HashMap<>();
            List<Integer> input = new ArrayList<>();
            Set<Integer> denyTeam = new HashSet<>();
            
            int N = sc.nextInt();
            for(int j=0; j<N; j++) {
                int team = sc.nextInt();
                input.add(team);
                countMap.put(team, countMap.getOrDefault(team, 0)+1);
            }

            List<Integer> keys = new ArrayList<>(countMap.keySet());
            for(Integer k : keys){
                if(countMap.get(k) != 6) {
                    denyTeam.add(k);
                }
            }

            Map<Integer, Integer> scoreMap = new HashMap<>();
            int rank = 0;
            for(Integer team : input){
                if(denyTeam.contains(team)) continue;
                rank++;
                List<Integer> list = new ArrayList<>();
                if(teamMap.containsKey(team)){
                    list = teamMap.get(team);
                    if(list.size() < 4) scoreMap.put(team, scoreMap.get(team)+rank);
                } else {
                    scoreMap.put(team, rank);
                }
                list.add(rank);
                teamMap.put(team, list);
            }

            List<Integer> list = new ArrayList<>(scoreMap.keySet());
            list.sort((o1, o2) -> {
                if(!scoreMap.get(o2).equals(scoreMap.get(o1))) return scoreMap.get(o1) - scoreMap.get(o2);
                else{
                    return teamMap.get(o1).get(4) - teamMap.get(o2).get(4);
                }
            });

            System.out.println(list.get(0));           
        }
    }
}