class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for(char item: sentence.toCharArray()){
            arr[item-'a'] = 1;
        }
    for(int item:arr){
        if(item!=1){
            return false;
        }
    }
    return true;
    }
}