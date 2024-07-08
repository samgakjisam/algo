#include <iostream>
#include <vector>


using namespace std;

int n, m;
vector<int> v;

void dfs(int idx, int cnt) {
	if (cnt == m) {
		for (const auto& num : v) {
			cout << num << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = idx; i <= n; i++) {
		v.push_back(i);
		dfs(i, cnt + 1);
		v.pop_back();
	}
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;
	dfs(1, 0);
	
	return 0;
}