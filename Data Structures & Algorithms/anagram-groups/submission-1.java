class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.asList(strs).stream() //
            .map(s -> new Pair<String, String>(computeKey(s), s)) //
            .collect(Collectors.groupingBy(Pair::getKey, 
            Collectors.mapping(Pair::getValue, Collectors.toList()))) //
            .values());
    }

    private static String computeKey(final String s) {
        int arr[] = new int[26];
        for(var ch : s.toCharArray()) {
            arr[ch-'a']++;
        }
        return Arrays.toString(arr);
    }
}
