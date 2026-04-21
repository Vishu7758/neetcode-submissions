class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int result = 0, n = nums.length, maxNum=Integer.MIN_VALUE, minNum=Integer.MAX_VALUE;
        for(var num : nums) {
            mp.put(num, 1);
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }
        // System.out.println(mp);
        for(int i=maxNum; i>=minNum; i--) {
            if(mp.containsKey(i)) {
                mp.put(i, mp.getOrDefault(i+1, 0)+1);
                result = Math.max(result, mp.get(i));
            }
        }
        // System.out.println(maxNum + ", " + minNum);
        // System.out.println(mp);
        return result;
    }
}
