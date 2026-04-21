class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(var ch : s.toLowerCase().toCharArray()) {
            if(Character.isLetterOrDigit(ch)) sb.append(ch);
        }
        s = sb.toString();
        int i = 0, j = s.length()-1;
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
