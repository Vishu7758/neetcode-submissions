class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<map<char, int>, vector<string>> mp;
        for(auto &str : strs) {
            map<char, int> temp;
            for(auto &ch : str) temp[ch]++;
            mp[temp].push_back(str);
        }
        vector<vector<string>> ans;
        for(auto i : mp) {
            vector<string> temp;
            for(auto &str : i.second) temp.push_back(str);
            ans.push_back(temp);
        }
        return ans;
    }
};
