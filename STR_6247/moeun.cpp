#include<iostream>
#include<map>
#include<algorithm>

using namespace std;
int n, q;
int eq[50000];
map<int, int> ma;

int main(int argc, char** argv)
{    
    cin >> n >> q;
    for (int i = 0; i < n; i++) {
        cin >> eq[i];
    }

    sort(eq, eq + n);

    for (int i = 0; i < n; i++) {
        ma[eq[i]] = i * (n - i - 1);
    }
    
    for (int i = 0; i < q; i++) {
        int a;
        cin >> a; 

        if (ma.find(a) != ma.end()) {
            cout << ma[a] << "\n";
        } else {
            cout << 0 << "\n";
        }
    }
   return 0;
}
