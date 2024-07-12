import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String[] alphabets = word.toUpperCase().split("");
        HashMap<String, Integer> map = new HashMap<>();
        for(String alphabet : alphabets){
            map.put(alphabet, map.getOrDefault(alphabet, 0)+1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        if(list.size() <= 1) System.out.println(list.get(0).getKey());
        else if(list.get(0).getValue().equals(list.get(1).getValue())) System.out.println("?");
        else System.out.println(list.get(0).getKey());

    }
}