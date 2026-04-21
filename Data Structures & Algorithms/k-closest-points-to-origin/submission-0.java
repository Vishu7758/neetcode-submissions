class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            (b, a) -> (dist(a) > dist(b) ? 1 : -1)
        );
        for(var p : points) {
            var x = new Pair<>(p[0], p[1]);
            if(pq.size()<k) pq.add(x);
            else if(dist(x) < dist(pq.peek())) {
                pq.poll(); pq.add(x);
            }
        }
        int[][] result = new int[k][];
        for(int i=0; i<k; i++) {
            var x = pq.poll();
            result[i] = new int[]{x.getKey(), x.getValue()};
        }
        return result;
    }

    private double dist(Pair<Integer, Integer> pr) {
        int a = pr.getKey();
        int b = pr.getValue();
        return Math.sqrt((a*a)+(b*b));
    }
}
