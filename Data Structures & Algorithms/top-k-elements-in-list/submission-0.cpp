class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> freq;
        for(auto &i : nums) freq[i]++;
        map<int, vector<int>, greater<int>> mp;
        for(auto i : freq) {
            mp[i.second].push_back(i.first);
        }
        vector<int> ans;
        for(auto i : mp) {
            for(auto nums : i.second) {
                ans.push_back(nums); k--;
                if(k==0) return ans;
            }
        }
        return ans;
    }
};
