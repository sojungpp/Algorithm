import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        Queue<String> q = new LinkedList<>();
        q.add(T);
        
        int answer = 0;
        while(!q.isEmpty()) {
            String temp = q.poll();
            if(S.length() == temp.length()) {
                if(S.equals(temp)) {
                    answer = 1;
                }
            }
            
            if(temp.endsWith("A")) q.add(temp.substring(0, temp.length()-1));
            if(temp.startsWith("B")) {
                StringBuffer sb = new StringBuffer(temp.substring(1, temp.length()));
                q.add(sb.reverse().toString());
            }
        }

        System.out.println(answer);
    }
}