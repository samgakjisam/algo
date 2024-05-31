#include<iostream>
#include<queue>

using namespace std;

int n, x, cnt;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;
	cnt = 0;

	for (int i = 0; i < n; i++) {
		cin >> x;
		if (x > 0) {
			pq.push(x);
			cnt++;
		}
		else if (cnt > 0) {
			int a = pq.top();
			pq.pop();
			cnt--;
			cout << a << "\n";
		}
		else {
			cout << 0 << "\n";
		}
	}

	return 0;
}
