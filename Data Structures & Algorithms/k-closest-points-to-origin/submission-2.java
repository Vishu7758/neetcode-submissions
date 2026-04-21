class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Pair<Integer, Integer> pr = new Pair<>(5,8);
        PriorityQueue<Pair<Integer, Integer>> pq = new 
        PriorityQueue<>((a,b) -> ((a.getKey()*a.getKey()) + (a.getValue()*a.getValue()))
        >((b.getKey()*b.getKey()) + (b.getValue()*b.getValue())) ? 1 : -1);
        for(var pt : points) {
            var temp = new Pair<>(pt[0], pt[1]);
            pq.add(temp);
        }
        int[][] result = new int[k][];
        int idx = 0;
        while(k>0) {
            printPq(pq);
            var top = pq.poll();
            result[idx++] = new int[]{top.getKey(), top.getValue()};
            k--;
            // System.out.println(Arrays.deepToString(result));
        }
        return result;
    }
    void printPq(PriorityQueue<Pair<Integer, Integer>> pq) {
        var itr = pq.iterator();
        while(itr.hasNext()) System.out.print(itr.next() + " ");
        System.out.println();
    }
}
