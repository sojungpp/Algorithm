import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int video_len_sec = stringToSeconds(video_len);
        int pos_sec = stringToSeconds(pos);
        int op_start_sec = stringToSeconds(op_start);
        int op_end_sec = stringToSeconds(op_end);
        
        for(int i=0; i<commands.length; i++) {
            
            // 오프닝 건너뛰기
            if(isOpening(pos_sec, op_start_sec, op_end_sec)) pos_sec = op_end_sec;
            
            if(commands[i].equals("prev")) {
                if(pos_sec - 10 <= 0) pos_sec = 0;
                else pos_sec = pos_sec - 10;
            }
            
            if(commands[i].equals("next")) {
                System.out.println(pos_sec);
                if(pos_sec + 10 >= video_len_sec) pos_sec = video_len_sec;
                else pos_sec = pos_sec + 10;
            }
            
            // 오프닝 건너뛰기
            if(isOpening(pos_sec, op_start_sec, op_end_sec)) pos_sec = op_end_sec;
        }
        
        return secondsToString(pos_sec);
    }
    
    private boolean isOpening(int now, int op_start, int op_end) {
        return now >= op_start && now <= op_end;
    }
    
    private int stringToSeconds(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
    }
    
    private String secondsToString(int seconds){
        int min = seconds/60;
        int sec = seconds%60;
        
        String min_string = String.format("%02d", min);
        
        return String.format("%02d", min) + ":" + String.format("%02d", sec);
    }
}