class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> f1, f2;
        for(auto &i : s) f1[i]++;
        for(auto &i : t) f2[i]++;
        return f1==f2;
    }
};
