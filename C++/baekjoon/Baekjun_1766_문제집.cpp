#include <stdio.h>
#include <iostream>
#include <vector>
#include <functional>
#include <queue>

using namespace std;

#define MAX_N 32001

vector<int> road[MAX_N];
int degree[MAX_N];
int result[MAX_N];

int main(int argc, char* argv[]) {
	int N, M;
	priority_queue<int, vector<int>, greater<int>> q;

	cin >> N;
	cin >> M;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a;
		cin >> b;
		degree[b]++;
		road[a].push_back(b);
	}

	for (int i = 1; i <= N; i++) {
		if (degree[i] == 0)	q.push(i);
	}

	int index = 1;

	for (int i = 0; i < N; i++) {
		if (q.empty()) {
			cout << "Cycle" << endl;
			return 0;
		}

		int cur = q.top();
		q.pop();
		result[i] = cur;
		for (int j = 0; j < road[cur].size(); j++) {
			int target = road[cur][j];
			if (--degree[target] == 0) {
				q.push(target);
			}
		}
	}

	for (int i = 0; i < N; i++) {
		cout << result[i] << " ";
	}
	cout << endl;

	return 0;
}