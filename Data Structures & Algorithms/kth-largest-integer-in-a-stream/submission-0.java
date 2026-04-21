class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    Integer k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(var num : nums) pq.add(num);
    }
    
    public int add(int val) {
        pq.add(val);
        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<(k-1); i++) {
            temp.add(pq.poll());
        }
        Integer result = pq.peek();
        for(var num : temp) pq.add(num);
        return result;
    }
}
