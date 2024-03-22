import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<LocalTime[]> q = new PriorityQueue<>(Comparator.comparing(arr -> arr[0]));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        for(int i=0; i<book_time.length; i++){
            LocalTime inTime = LocalTime.parse(book_time[i][0], formatter);
            LocalTime outTime = LocalTime.parse(book_time[i][1], formatter);
            if(outTime.isAfter(LocalTime.of(23, 49))) outTime = LocalTime.of(23, 49);
            LocalTime[] time = {inTime, outTime.plusMinutes(10)};
            q.add(time);
        }
        
        ArrayList<LocalTime> list = new ArrayList<>();
        int answer = 1;
        LocalTime[] firstTime = q.poll();
        list.add(firstTime[1]);
        
        while(!q.isEmpty()){
            LocalTime[] t = q.poll();
            // 만약 가능한 방이 있다면, t[1]로 변경
            answer++;
            for(int i=0; i<list.size(); i++){
                if(t[0].isAfter(list.get(i)) || t[0].equals(list.get(i)) ){
                    answer--;
                    list.remove(i);
                    break;
                }
            }
            list.add(t[1]);
            // 가능한 방이 없다면, list에 추가하고 answer++;
        }
        
        return answer;
    }
}