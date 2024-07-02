#include <string>
#include <vector>
#include <queue>

using namespace std;
vector<int> boa[1000001];
int glo[1000001] = {0,};
int po = -1;

int bfs(int x) {
    queue<int> qu;
    int vis[1000001] = {0,};
    qu.push(x);
    vis[x] = 1;
    int flg = 0;
    
    while(!qu.empty()) {
        int a = qu.front();
        glo[a] = 1;
        qu.pop();
        
        // cout << a << "\n";
        
        if (boa[a].size() == 0) {
            return 0;
        }
        
        else if (boa[a].size() == 1) {
            int b = boa[a][0];
            if (vis[b] == 1 && flg == 0) {
                flg = 1;
            }
            if (flg == 1 && vis[b] == 1) {
                return 1;
            }
            qu.push(b);
            vis[b]++;
        }
        
        else {
            flg = 2;
            for (int i = 0; i < 2; i++) {
                int y = boa[a][i];

                if (vis[y] == 0) {
                    qu.push(y);
                    vis[y]++;
                }
            }
        }
    }
    
    return flg;
}

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer;
    
    int start[1000001] = {0,};
    int end[1000001] = {0,};
    
    for (int i = 0; i < edges.size(); i++) {
        int a = edges[i][0];
        int b = edges[i][1];
        start[a]++;
        end[b]++;
        
        boa[a].push_back(b);
        
        if (start[a] > 2) {
            po = a;
        }
    }
    
    if (po == -1) {
        for (int i = 1; i < 1000001; i++) {
            if (start[i] > 0 && end[i] == 0) {
                po = i;
                break;
            }
        }
    }
    
    answer.push_back(po);
    
    int stick = 0;
    int donut = 0;
    int eight = 0;
    
    for (int i = 0; i < edges.size(); i++) {
        int x = edges[i][0];
        if (x != po && glo[x] == 0) {
            int ans = bfs(x);
            // cout << "ans: " << ans << "\n";
            
            if (ans == 1) {
                donut++;
            }
            else if (ans == 2) {
                eight++;
            }
        }
    }
    
    stick = start[po] - donut - eight;
    
    answer.push_back(donut);
    answer.push_back(stick);
    answer.push_back(eight);    

    return answer;
}
