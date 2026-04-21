class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(var edge : prerequisites) {
            var u = edge[1];
            var v = edge[0];
            adj.get(u).add(v);
            arr[v]++;
        }
        // for(int i = 0; i<numCourses; i++) {
        //     System.out.print(i + " : ");
        //     for(var nbr : adj.get(i)) System.out.print(nbr + ", ");
        //     System.out.println();
        // }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<numCourses; i++) {
            if(arr[i]==0) q.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            var front = q.poll(); res.add(front);
            for(var nbr : adj.get(front)) {
                arr[nbr]--;
                if(arr[nbr]==0) q.add(nbr);
            }
        }
        for(var i : arr) if(i>0) return new int[0];
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
