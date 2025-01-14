// https://softeer.ai/practice/11001

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<N; i++) {
            List<Integer> list = new ArrayList<>();
            String input = br.readLine();
            int key = 0;
            if(!input.contains(".")) {
                key = Integer.parseInt(input);
                list.add(-1);
            } else {
                String[] inputs = input.split("\\.");
                key = Integer.parseInt(inputs[0]);
                list.add(Integer.parseInt(inputs[1]));
            }

            if(map.containsKey(key)) {
                list.addAll(map.get(key));
            }
            map.put(key, list);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for(Integer k : keySet) {
            List<Integer> value = map.get(k);
            Collections.sort(value);
            for(Integer v : value) {
                if(v == -1) System.out.println(k);
                else System.out.println(k + "." + v);
            }
        }
        
    }
}
