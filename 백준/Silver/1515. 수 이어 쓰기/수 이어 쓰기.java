import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] target = input.toCharArray();
        int standard = 0;
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<target.length; i++) {
            boolean isNum = false;
            while(!isNum) {
                if(q.isEmpty()) {
                    standard++;
                    char[] standards = Integer.toString(standard).toCharArray();
                    for(char s : standards) q.add(s);
                }

                while(!q.isEmpty()) {
                    char temp = q.poll();
                    if(target[i] == temp) {
                        isNum = true;
                        break;
                    }
                }
            }
        }

        System.out.println(standard);
    }
}