import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[] endSwitch;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String start = br.readLine();
        boolean[] startSwitch = new boolean[start.length()];
        for(int i=0; i<start.length(); i++) {
            if(start.charAt(i) == '0') startSwitch[i] = true;
            else startSwitch[i] = false;
        }
        String end = br.readLine();
        endSwitch = new boolean[end.length()];
        for(int i=0; i<end.length(); i++) {
            if(end.charAt(i) == '0') endSwitch[i] = true;
            else endSwitch[i] = false;
        }

        int answerFirstOn = checkNum(true, Arrays.copyOf(startSwitch, N));
        int answerFirstOff = checkNum(false, Arrays.copyOf(startSwitch, N));
        int answer = Math.min(answerFirstOn, answerFirstOff);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
        
    }

    private static int checkNum(boolean isFirstOn, boolean[] target) {
        int cnt = 0;
        if(isFirstOn) {
            target[0] = !target[0];
            target[1] = !target[1];
            cnt++;
        }
        
        for(int i=1; i<target.length; i++) {
            if(target[i-1] != endSwitch[i-1]) {
                target = pressNum(target, i);
                cnt++;
            }
        }
        if (!Arrays.equals(target, endSwitch)) return Integer.MAX_VALUE;
        return cnt;
    }

    private static boolean[] pressNum(boolean[] target, int num) {
        if(num==target.length-1) return pressLast(target);
        target[num-1] = !target[num-1];
        target[num] = !target[num];
        target[num+1] = !target[num+1];
        return target;
    }

    private static boolean[] pressLast(boolean[] target) {
        target[target.length-1] = !target[target.length-1];
        target[target.length-2] = !target[target.length-2];
        return target;
    }

    
}