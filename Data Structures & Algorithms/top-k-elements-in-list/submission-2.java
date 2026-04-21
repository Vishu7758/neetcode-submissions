class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var data =  IntStream.of(nums) //
            .boxed() //
            .collect(Collectors.groupingBy(s->s, Collectors.counting())) //
            .entrySet() //
            .stream() //
            .map(x -> new Pair<>(x.getValue(), x.getKey()))
            .sorted((x, y) -> (int)(y.getKey()-x.getKey()))
            .map(Pair::getValue) //
            .limit(k) //
            .mapToInt(i -> i.intValue()) //
            .toArray();
        return data;
    }
}
