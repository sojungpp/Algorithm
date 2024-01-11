class Solution {
    
    private String checkLastWord(String new_id) {
        if(new_id.length() == 0) return new_id;
        if(new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);
        return new_id;
    }
    
    public String solution(String new_id) {
        // step 1
        new_id = new_id.toLowerCase();
        // step 2
        new_id = new_id.replaceAll("[^a-z0-9._-]", "");
        // step 3
        new_id = new_id.replaceAll("\\.{2,}", ".");
        // step 4
        if(new_id.charAt(0) == '.') new_id = new_id.substring(1);
        new_id = checkLastWord(new_id);
        // step 5
        if(new_id.isEmpty()) new_id = "a";
        // step 6
        if(new_id.length() >= 16) new_id = new_id.substring(0, 15);
        new_id = checkLastWord(new_id);
        // step 7
        if(new_id.length() <= 2) new_id = new_id + new_id.substring(new_id.length()-1).repeat(3 - new_id.length());
        return new_id;
    }
}