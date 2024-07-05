#include<iostream>
#include<queue>

using namespace std;

static void brute(int a, int b) {
	queue<int> qu;
	string vis[10000] = {""};
	qu.push(a);
	vis[a] = "s";

	while (!qu.empty()) {
		int x = qu.front();
		if (x == b) {
			string ans = vis[x].substr(1);
			cout << ans << "\n";
			return;
		}
		qu.pop();

		int d, s, l, r;
		string bef = vis[x];

		d = (x * 2) % 10000;
		if (vis[d] == "") {
			qu.push(d);
			vis[d] = bef + "D";
		}
		s = (x + 9999) % 10000;
		if (vis[s] == "") {
			qu.push(s);
			vis[s] = bef + "S";
		}
		l = x / 1000 + (x % 1000) * 10;
		if(vis[l] == "") {
			qu.push(l);
			vis[l] = bef + "L";
		}
		r = x / 10 + (x % 10) * 1000;
		if(vis[r] == "") {
			qu.push(r);
			vis[r] = bef + "R";
		}
	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int t;
	cin >> t;

	for (int i = 0; i < t; i++) {
		int a, b;
		cin >> a >> b;
		brute(a, b);
	}

	return 0;
}
