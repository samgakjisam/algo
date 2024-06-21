#include <iostream>
#include <queue>
#include <utility>

using namespace std;

struct compare{
	bool operator()(pair<int, int> a, pair<int, int> b) {
		if (a.first == b.first) {
			return a.second > b.second; // 같을 경우 음수 먼저
		}
		return a.first > b.first; // 절댓값 작은 수가 우선
	}
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	// 절댓값이 가장 작은 수
	// 절댓값 같을 경우 음수
	// 앞이 절대값, 뒤가 원래 값
	priority_queue <pair<int, int>, vector<pair<int,int>>, compare> pq;

	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int x;
		cin >> x;

		if (x == 0) {
			if (pq.empty()) cout << "0" << "\n";
			else {
				// pop
				cout << pq.top().second << "\n";
				pq.pop();

			}
		}
		else {
			// push
			if (x < 0) {
				pq.push(pair<int,int>(-x, x));
			}
			else {
				pq.push(make_pair(x, x));
			}
			// pq.push({abs(x), x}); // 이거로 한 번에 가능
		}
	}
}
