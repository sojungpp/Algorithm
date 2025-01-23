// https://softeer.ai/practice/6255

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        String keys = br.readLine();

        // 표 만들기
        char[][] chart = new char[6][6];
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<keys.length(); i++) {
            if(!set.contains(keys.charAt(i))) {
                set.add(keys.charAt(i));
                list.add(keys.charAt(i));
            }
        }

        for(int i=(int)'A'; i<=(int)'Z'; i++) {
            if(i == (int)'J') continue;
            if(!set.contains((char)i)) {
                list.add((char)i);
            }
        }

        // 암호 메세지 분리
        List<char[]> code = new ArrayList<>();
        for(int i=0; i<message.length(); i++) {
            if(i+1 == message.length()) {
                code.add(new char[]{message.charAt(i), 'X'});
                break;
            }
            if(message.charAt(i) == message.charAt(i+1)) {
                if(message.charAt(i) == 'X') {
                    code.add(new char[]{'X', 'Q'});
                } else {
                    code.add(new char[]{message.charAt(i), 'X'});
                }
            } else {
                code.add(new char[]{message.charAt(i), message.charAt(i+1)});
                i++;
            }
        }

        // 암호화
        for(char[] c : code) {
            int startCode = list.indexOf(c[0]);
            int endCode = list.indexOf(c[1]);

            // 같은 열
            if(startCode/5 == endCode/5) {
                if(startCode%5 == 4) System.out.print(list.get(startCode-4));
                else System.out.print(list.get(startCode+1));
                if(endCode%5 == 4) System.out.print(list.get(endCode-4));
                else System.out.print(list.get(endCode+1));
                continue;
            }

            // 같은 행
            if(startCode%5 == endCode%5) {
                if(startCode/5 == 4) System.out.print(list.get(startCode%5));
                else System.out.print(list.get(startCode+5));
                if(endCode/5 == 4) System.out.print(list.get(endCode%5));
                else System.out.print(list.get(endCode+5));
                continue;
            }

            // 다른 열, 다른 행
            System.out.print(list.get(5*(startCode/5)+(endCode%5)));
            System.out.print(list.get(5*(endCode/5)+(startCode%5)));
        }
    }
}
