class Solution {
public:
    void dfs(int node, vector<bool>& visited, vector<vector<int>>& adj) {
        visited[node] = true;
        for(int nbr : adj[node]) {
            if(!visited[nbr]) dfs(nbr, visited, adj);
        }
    }
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<bool> visited(n, false);
        vector<vector<int>> adj(n);
        for(auto &edge : edges) {
            auto [u, v] = make_pair(edge[0], edge[1]);
            adj[u].push_back(v); adj[v].push_back(u);
        }
        int res=0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, visited, adj); res++;
            }
        }
        return res;
    }
};
