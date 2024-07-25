import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.next();
        int answer = Integer.MAX_VALUE;

        int countA = 0;
        for(int i=0; i<words.length(); i++){
            if(words.charAt(i) == 'a') countA++;
        }

        for(int i=0; i<words.length(); i++){
            int count = 0;
            for(int j=i; j<countA+i; j++){
                if(words.charAt(j % words.length()) == 'b') count++;
            }
            answer = Math.min(answer, count);
        }
        System.out.println(answer);
    }
}