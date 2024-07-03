#include<iostream>
#include<queue>
#include<map>

using namespace std;

void func() {
    int k, cnt;
    cnt = 0;

    priority_queue<int> lq;
    priority_queue<int, vector<int>, greater<int>> gq;
    map<int, int> cmap;
    
    cin >> k;

    for (int i = 0; i < k; i++) {
        char c;
        int n;

        cin >> c >> n;

        if (c == 'I') {
            lq.push(n);
            gq.push(n);
            cmap[n]++;
            cnt++;
        }

        else if (cnt > 0) {
            bool flg = true;

            if (n > 0) {                
                while (flg) {
                    int a = lq.top();

                    if (cmap[a] > 0) {
                        flg = false;
                        cmap[a]--;
                    }
                    lq.pop();
                }
            }

            else {
                while (flg) {
                    int a = gq.top();

                    if (cmap[a] > 0) {
                        flg = false;
                        cmap[a]--;
                    }
                    gq.pop();
                }
            }

            cnt--;
        }

        if (cnt == 0) {
            lq = priority_queue<int> ();
            gq = priority_queue<int, vector<int>, greater<int>>();
            cmap = map<int, int>();
        }
    }

    if (cnt > 0) {
        int ma, mi;

        while (true) {
            int a = lq.top();
            
            if (cmap[a]) {
                ma = a;
                break;
            }
            lq.pop();
        }

        while (true) {
            int a = gq.top();

            if (cmap[a]) {
                mi = a;
                break;
            }
            gq.pop();
        }

        cout << ma << " " << mi << "\n";
    }
    else {
        cout << "EMPTY\n";
    }
}


int main() {
    int t;
    cin >> t;
    for (int i = 0; i < t; i++) {
        func();
    }
    return 0;
}
