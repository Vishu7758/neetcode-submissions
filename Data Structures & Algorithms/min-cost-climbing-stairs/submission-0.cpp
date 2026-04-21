class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size();
        int dp[n+1] = {0};
        for(int i=2; i<=n; i++) {
            dp[i] =  min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        for(auto i : dp) cout<<i<<' ';
        cout<<endl;
        return dp[n];
    }
};
