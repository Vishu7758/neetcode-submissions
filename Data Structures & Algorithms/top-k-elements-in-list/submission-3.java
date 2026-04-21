class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var data = IntStream.of(nums) //
            .boxed() //
            .collect(Collectors.groupingBy(s->s, Collectors.counting())) //
            .entrySet() //
            .stream() //
            // .map(x -> new Pair<>(x.getValue(), x.getKey()))
            .sorted((x, y) -> (int)(y.getValue()-x.getValue()))
            .map(Map.Entry::getKey) //
            .limit(k) //
            .mapToInt(i -> i.intValue()) //
            .toArray();
            // .toList();
        // System.out.println(data);
        return data;
        // return new int[2];
    }
}
