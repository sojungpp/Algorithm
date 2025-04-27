/*
🛠 문제 제목:
"중복 없는 문자 찾기"

✨ 문제 설명
주어진 문자열에 중복되지 않는 문자 중 첫 번째 문자를 찾아 반환하는 메소드를 작성하시오.
만약 그런 문자가 없다면 '_' (언더바)를 반환하시오.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<input.length(); i++) {
            char value = input.charAt(i);
            map.put(value, map.getOrDefault(value, 0)+1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        for(int i=0; i<list.size(); i++) {
            char target = list.get(i);
            if(map.get(target) == 1) {
                System.out.println(target);
                return;
            }
        }
        System.out.println("_");
    }
}
