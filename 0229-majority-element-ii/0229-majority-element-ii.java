class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int el1 = -1, el2 = -1;
        for(int i = 0; i < nums.length; i++){
            if(cnt1 == 0 && nums[i] != el2){
                cnt1 = 1;
                el1 = nums[i];
            } else if(cnt2 == 0 && nums[i] != el1){
                cnt2 = 1;
                el2 = nums[i];
            } else if(nums[i] == el1){
                cnt1++;
            } else if(el2 == nums[i]){
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        int cntS1 = 0;
        int cntS2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el1) {
                cntS1++;
            } else if (nums[i] == el2) {
                cntS2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (cntS1 > nums.length / 3) {
            result.add(el1);
        }
        if (cntS2 > nums.length / 3) {
            result.add(el2);
        }

        return result;
    }
}