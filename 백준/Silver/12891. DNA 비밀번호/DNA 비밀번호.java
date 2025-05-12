import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Map<Character, Integer> map;
    static Set<Character> set;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        map.put('A', Integer.parseInt(st.nextToken()));
        map.put('C', Integer.parseInt(st.nextToken()));
        map.put('G', Integer.parseInt(st.nextToken()));
        map.put('T', Integer.parseInt(st.nextToken()));

        set = new HashSet<>();
        set.add('A');
        set.add('C');
        set.add('G');
        set.add('T');
        
        int answer = 0;
        for(int i=0; i<P; i++) {
            Character key = input.charAt(i);
            map.put(key, map.get(key)-1);
        }
        if(isTrue()) answer++;

        for(int i=P; i<S; i++) {
            map.put(input.charAt(i-P), map.get(input.charAt(i-P))+1);
            map.put(input.charAt(i), map.get(input.charAt(i))-1);
            if(isTrue()) answer++;
        }
        System.out.println(answer);
    }

    private static boolean isTrue() {
        List<Character> keys = new ArrayList<>(map.keySet());
        for(Character k : keys) {
            if(!set.contains(k)) continue;
            if(map.get(k) > 0) return false;
        }
        return true;
    }
}