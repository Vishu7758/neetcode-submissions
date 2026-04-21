class Solution {
public:
    bool dfs(int node, int parent, vector<vector<int>>& adj, vector<bool>& visited) {
        visited[node]=true;
        for(auto nbr : adj[node]) {
            if(visited[nbr] and nbr!=parent) return false;
            else if(!visited[nbr] and !dfs(nbr, node, adj, visited)) return false;
        }
        return true;
    }
    bool validTree(int n, vector<vector<int>>& edges) {
        vector<bool> visited(n, false);
        vector<vector<int>> adj(n);
        for(auto &edge : edges) {
            auto [u, v] = make_pair(edge[0], edge[1]);
            adj[u].push_back(v); adj[v].push_back(u);
        }
        if(!dfs(0, -1, adj, visited)) return false;
        for(auto i : visited) if(!i) return false;
        return true;
    }
};
