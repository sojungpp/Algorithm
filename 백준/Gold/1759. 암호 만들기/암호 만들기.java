import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static List<String> answer = new ArrayList<>();
    static boolean[] visited;
    static int L, C;
    static List<String> charList = new ArrayList<>();

    private static void dfs(int depth, int start, String temp){
        if(depth == L){
            if(isValid(temp)) System.out.println(temp);
            return;
        }

        for(int i=start; i<C; i++){
            if(!visited[i]){
                visited[i] = true;
                temp += charList.get(i);
                dfs(depth+1, i+1, temp);
                temp = temp.substring(0, temp.length()-1);
                visited[i] = false;
            }
        }
        return;
    }

    private static boolean isValid(String temp){
        char[] arrays = temp.toCharArray();
        int vowelCount = 0;
        int conCount = 0;
        for(char a : arrays){
            if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') vowelCount++;
            else conCount++;
        }
        return vowelCount >=1 && conCount >=2;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        visited = new boolean[C];

        for(int i=0; i<C; i++){
            charList.add(sc.next());
        }
        Collections.sort(charList);

        dfs(0, 0, "");
    }
}