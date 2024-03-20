class Solution {
    public int reverse(int x) {
        long finalNum = 0;
        int lastDig;
        while(x!=0){
            lastDig = x%10;
            finalNum += lastDig;
            finalNum = finalNum*10;
            x= x/10;
        }
        finalNum = finalNum/10;
        if(finalNum > Integer.MAX_VALUE || finalNum<Integer.MIN_VALUE){
            return 0;
        }else if(x<0){
            return (int)(-1*finalNum);
        }else{
            return (int)finalNum;
        }
    }
}