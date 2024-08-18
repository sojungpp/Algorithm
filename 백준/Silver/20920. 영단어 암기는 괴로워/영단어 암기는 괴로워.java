import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        /*
        자주 나오는 단어일수록 앞에 배치한다.
        해당 단어의 길이가 길수록 앞에 배치한다.
        알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> wordSheet = new HashMap<>();
        
        for(int i=0; i<N; i++) {
            String target = br.readLine();
            if(target.length() < M) continue;
            wordSheet.put(target, wordSheet.getOrDefault(target, 0)+1);
        }

        List<String> keys = new ArrayList<>(wordSheet.keySet());
        keys.sort((o1, o2) -> {
            if(wordSheet.get(o1) != wordSheet.get(o2)) return wordSheet.get(o2) - wordSheet.get(o1);
            else if(o1.length() != o2.length()) return o2.length() - o1.length();
            else return o1.compareTo(o2);
        });
        
        for(String k : keys) {
            bw.write(k + "\n");
        }
        bw.flush();
    }
}