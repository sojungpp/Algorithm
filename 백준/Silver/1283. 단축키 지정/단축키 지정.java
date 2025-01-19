import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            String[] word = input.split(" ");

            boolean isKey = false;
            for(int j=0; j<word.length; j++) {
                if(!set.contains(Character.toUpperCase(word[j].charAt(0)))){
                    set.add(Character.toUpperCase(word[j].charAt(0)));

                    for(int z=0; z<j; z++) {
                        System.out.print(word[z] + " ");
                    }
                    System.out.print("[" + word[j].charAt(0) + "]" + word[j].substring(1, word[j].length()) + " ");
                    for(int z=j+1; z<word.length; z++) {
                        System.out.print(word[z] + " ");
                    }
                    System.out.println();
                    isKey = true;
                    break;
                }
            }

            if(isKey) continue;
            for(int j=0; j<input.length(); j++) {
                if(!set.contains(Character.toUpperCase(input.charAt(j))) && input.charAt(j) != ' ') {
                    set.add(Character.toUpperCase(input.charAt(j)));
                    System.out.println(input.substring(0, j) + "[" + input.charAt(j) + "]" + input.substring(j+1, input.length()));
                    isKey = true;
                    break;
                }
            }
            if(isKey) continue;
            System.out.println(input);
        }
    }
}