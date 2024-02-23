class Solution {
    public int solution(int[] num_list) {
        int mutiplyValue = 1;
        int addValue = 0;
        for(int n : num_list){
            mutiplyValue *= n;
            addValue += n;
        }
        if(mutiplyValue < addValue*addValue) return 1;
        else return 0;
    }
}