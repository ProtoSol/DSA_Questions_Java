class Solution {
    public int findMin(int[] a) {
        int res = a[0];
        int l=0,r=a.length-1;
        while(l<=r){
            if(a[l] < a[r]){
                res = Math.min(res, a[l]);
                break;
            }
            int mid = l + (r - l)/2;
            res = Math.min(res, a[mid]);
            if(a[mid] >= a[l]){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}