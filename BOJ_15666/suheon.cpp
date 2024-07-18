#include <iostream>
#include <vector>
#include <set>

using namespace std;

int N;
int M;
set <int> s;
vector <int> v;

void f(int last, int num) {

	if (num == M) {
		for (int i = 0; i < v.size(); i++) {
			cout << v[i] << " ";
		}
		cout << "\n";
		return;
	}

	else {
		for (auto it = s.begin(); it != s.end(); it++) {
			int tmp;
			tmp = *it;
			if (tmp >= last) {
				v.push_back(tmp);
				f(tmp, num + 1);
				v.pop_back();
			}
		}
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int tmp;
		cin >> tmp;
		s.insert(tmp);
	}

	f(0,0);
}
