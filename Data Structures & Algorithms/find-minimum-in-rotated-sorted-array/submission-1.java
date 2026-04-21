class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int res = 0, n = nums.length-1;
        int s = 0, e = n, mid=0;
        if(nums[0]<nums[n]) return nums[0];
        int key = Integer.MAX_VALUE;
        while(s<=e) {
            mid = (s+e)/2;
            key = Math.min(nums[mid], key);
            // start n mid in 1st line
            if(nums[s]<=nums[mid]) {
                if(nums[mid]>nums[e]) s = mid + 1;
                else e = mid - 1;
            } else {
                e = mid - 1;
            }
        }
        return key;
    }
}
