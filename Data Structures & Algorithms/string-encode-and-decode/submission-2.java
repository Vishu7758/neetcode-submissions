class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        var result = strs.stream() //
            .map(s -> s.length() + "#" + s)
            .reduce((a, b) -> a+b)
            .get();
        System.out.println(result);
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if(str.isEmpty()) return result; 
        int idx = 0;
        while(idx<str.length()) {
            if(str.charAt(idx)=='#') {
                String num = str.substring(0, idx);
                String temp = str.substring(idx+1, idx+1+Integer.parseInt(num));
                result.add(temp);
                str = str.substring(idx+1+Integer.parseInt(num));
                idx = 0;
            } else idx++;
        }
        return result;
    }
}
