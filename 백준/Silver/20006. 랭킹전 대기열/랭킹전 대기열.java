import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> people = new HashMap<>();
        Map<Integer, ArrayList<String>> room = new HashMap<>();

        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            people.put(nickname, level);
            boolean isJoined = false;
            // 룸 체크
            for(int j=0; j<room.size(); j++){
                // 레벨 체크
                ArrayList<String> participants = room.get(j);
                int firstLevel = people.get(participants.get(0));
                int min = firstLevel - 10;
                int max = firstLevel + 10;
                if(level >= min && level <= max){
                    if(participants.size() < m){
                        isJoined = true;
                        participants.add(nickname);
                        room.put(j, participants);
                        break;
                    }
                }
            }
            
            // 새로운 룸
            if(!isJoined){
                ArrayList<String> participants = new ArrayList<>();
                participants.add(nickname);
                room.put(room.size(), participants);
            }
        }

        for(int i=0; i<room.size(); i++){
            ArrayList<String> participants = room.get(i);
            if(participants.size() == m) {
                System.out.println("Started!");
            } else System.out.println("Waiting!");

            Collections.sort(participants);

            for(String participant : participants) {
                System.out.println(people.get(participant) + " " + participant);
            }
        }
    }
}
