import java.util.*;
import java.lang.*;
import java.io.*;

class Main {   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> gamePeople = new HashMap<>(){
            {
                put("Y", 2);
                put("F", 3);
                put("O", 4);
            }
        };
        int N = sc.nextInt();
        String game = sc.next();
        int limitNum = gamePeople.get(game);
        int gameRound = 0;
        
        Set<String> people = new HashSet<>();
        for(int i=0; i<N; i++){
            people.add(sc.next());
        }
        int peopleNum = people.size();
        
        while(peopleNum >= limitNum-1){
            gameRound++;
            peopleNum = peopleNum - limitNum+1;
        }

        System.out.println(gameRound);
        
    }
}