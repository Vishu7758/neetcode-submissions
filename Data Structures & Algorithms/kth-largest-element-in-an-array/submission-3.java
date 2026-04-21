class Solution {
    int solve(int[] nums, int l, int r, int k) {
        int pivot = nums[r-1];
        int pIdx=l;
        System.out.println(l + " " + r +" "+k+" "+pIdx+" "+pivot+" : "+Arrays.toString(nums));
        for(int i=l; i<r; i++) {
            if(nums[i]<pivot) {
                var temp = nums[i];
                nums[i] = nums[pIdx];
                nums[pIdx++] = temp;
            }
        }
        var temp = nums[pIdx];
        nums[pIdx] = nums[r-1];
        nums[r-1] = temp;
        System.out.println(l + " " + r +" "+k+" "+pIdx+" "+pivot+" : "+Arrays.toString(nums));
        if(pIdx==k) return nums[pIdx];
        else if(pIdx>k) return solve(nums, l, pIdx, k);
        return solve(nums, pIdx+1, r, k);
    }
    public int findKthLargest(int[] nums, int k) {
        return solve(nums, 0, nums.length, nums.length-k);
    }
}
