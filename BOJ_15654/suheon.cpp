#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M;
int arr[8] = { 0, };
bool visited[8] = { false, };
vector <int> v;

void dfs(int cnt) {
	if (cnt == M) {
		for (auto it = v.begin(); it != v.end(); it++) {
			cout << *it << " ";
		}
		cout << "\n";
		return;
	}

	else {
		for (int i = 0; i < N; i++) {
			if (visited[i] == true) continue;
			v.push_back(arr[i]);
			visited[i] = true;
			dfs(cnt + 1);
			v.pop_back();
			visited[i] = false;
		}
	}
}

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		int tmp;
		cin >> tmp;
		arr[i] = tmp;
	}

	sort(arr, arr + N);

	int cnt = 0;
	dfs(cnt);
}
