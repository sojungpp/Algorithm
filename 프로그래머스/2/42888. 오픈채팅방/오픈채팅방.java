import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Queue<String[]> chats = new LinkedList<>();
        HashMap<String, String> nickname = new HashMap<>();
        
        // 닉네임 체크
        for(String input : record) {
            String[] msgs = input.split(" ");
            if(msgs[0].equals("Change")) {
                nickname.put(msgs[1], msgs[2]);
            } else if(msgs[0].equals("Enter")) {
                nickname.put(msgs[1], msgs[2]);
                chats.add(msgs);
            } else chats.add(msgs);
        }
        
        // 출력
        String[] answer = new String[chats.size()];
        int index = 0;
        while(!chats.isEmpty()) {
            String[] msgs = chats.poll();
            String msg = "";
            if(msgs[0].equals("Enter")) {
                msg = nickname.get(msgs[1]) + "님이 들어왔습니다.";
            } else msg = nickname.get(msgs[1]) + "님이 나갔습니다.";
            answer[index] = msg;
            index++;
        }
        
        return answer;
    }
}