class Solution {
    void printPq(PriorityQueue<Integer> pq) {
        var itr = pq.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next()+" ");
        }
        System.out.println();
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(var stone : stones) pq.add(stone);
        // printPq(pq);
        while(pq.size()>1) {
            int x = pq.poll(), y = pq.poll();
            if(x==y) continue;
            pq.add(Math.abs(x-y));
            // printPq(pq);
        }
        return !pq.isEmpty() ? pq.peek() : 0;
    }
}
