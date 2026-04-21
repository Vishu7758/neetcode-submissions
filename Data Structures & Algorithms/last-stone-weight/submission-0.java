class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(var num : stones) pq.add(num);
        while(pq.size()>1) {
            int x = pq.poll() - pq.poll();
            if(x>0) pq.add(x);
        }
        return pq.size()>0? pq.peek() : 0;
    }
}
