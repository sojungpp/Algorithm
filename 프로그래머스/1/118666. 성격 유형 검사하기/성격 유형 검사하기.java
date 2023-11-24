import java.util.*;

class Solution {

    Map<String, Integer> test = new HashMap<String, Integer>();

    private String getTestResult() {
        String result = "";
        result += compareTest("R", "T");
        result += compareTest("C", "F");
        result += compareTest("J", "M");
        result += compareTest("A", "N");
        return result;
    }

    private String compareTest(String type1, String type2) {
        if(test.get(type1) >= test.get(type2)) return type1;
        return type2;
    }

    public String solution(String[] survey, int[] choices) {

        test.put("R", 0);
        test.put("T", 0);
        test.put("C", 0);
        test.put("F", 0);
        test.put("J", 0);
        test.put("M", 0);
        test.put("A", 0);
        test.put("N", 0);

        for(int i=0; i<survey.length; i++) {
            String[] type = survey[i].split("");
            if(choices[i]<4) {
                test.put(type[0], test.get(type[0]) + 4-choices[i]);
            }
            if(choices[i]>4) {
                test.put(type[1], test.get(type[1]) + choices[i]-4);
            }
        }
        return getTestResult();
    }
}