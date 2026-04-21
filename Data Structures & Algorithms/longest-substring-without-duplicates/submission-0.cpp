class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> st;
        int ans=0;
        int i=0, j=0;
        while(i<s.size() and j<s.size()) {
            if(st.count(s[j]) == 0) {
                st.insert(s[j++]);
            } else {
                st.erase(s[i++]);
            }
            ans = max(ans, (int)st.size());
            // for(auto i : st) cout<<i<<' ';cout<<endl;
        }
        return ans;
    }
};
