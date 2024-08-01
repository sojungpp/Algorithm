import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int M = Integer.parseInt(br.readLine());
        
        Stack<String> stack = new Stack<>();
        Stack<String> tempStack = new Stack<>();

        String[] words = word.split("");
        for(String w : words){
            stack.push(w);
        }
        
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "L":
                        if(!stack.isEmpty()) tempStack.push(stack.pop());
                        break;
                case "D":
                        if(!tempStack.isEmpty()) stack.push(tempStack.pop());
                        break;
                case "B":
                        if(!stack.isEmpty()) {
                            stack.pop();
                        }
                        break;
                case "P":
                        String addWord = st.nextToken();
                        stack.push(addWord);
                        break;
            }
        }
        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        answer.reverse();
        
        
        while (!tempStack.isEmpty()) {
            answer.append(tempStack.pop());
        }
        
        System.out.println(answer.toString());   
    }
}