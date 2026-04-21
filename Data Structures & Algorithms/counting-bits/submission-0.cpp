class Solution {
public:
    int solve(int n) {
        int ans=0;
        while(n) {
            ans += n&1;
            n >>= 1;
        }
        return ans;
    }
    vector<int> countBits(int n) {
        vector<int> ans(n+1, 0);
        for(int i=0; i<=n; i++) ans[i] = solve(i);
        return ans;;
    }
};
