class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(var num : nums) {
            if(pq.size()<k) pq.add(num);
            else if(pq.peek()<num) {
                pq.poll(); pq.add(num);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size()<k) pq.add(val);
        else if(pq.peek()<val) {
            pq.poll(); pq.add(val);
        }
        return pq.peek();
    }
}
