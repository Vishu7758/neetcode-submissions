class Solution {
    public int maxArea(int[] arr) {
        int l=0, r=arr.length-1;
        int result = 0;
        while(l<=r) {
            int area = (r-l)*Math.min(arr[l], arr[r]);
            result = Math.max(area, result);
            if(arr[l]<arr[r]) l++;
            else r--;
        }
        return result;
    }
}
