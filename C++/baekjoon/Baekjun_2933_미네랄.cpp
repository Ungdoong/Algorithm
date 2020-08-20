//#include <stdio.h>
//#include <iostream>
//#include <queue>
//
//using namespace std;
//
//#define MAX 100
//
//int arr[MAX][MAX];
//
//int dy[4] = { 1, 0, -1, 0 };
//int dx[4] = { 0, 1, 0, -1 };
//
//bool isFalling(int R, int C, int y, int x) {
//	queue<pair<int, int>> q;
//	bool tmp_arr[MAX][MAX];
//
//	q.push(make_pair(y, x));
//	tmp_arr[y][x] = true;
//
//	while (!q.empty()) {
//		int cy = q.front().first;
//		int cx = q.front().second;
//		q.pop();
//
//		for (int d = 0; d < 4; d++) {
//			int ny = y + dy[d];
//			int nx = x + dx[d];
//			if (ny < 0 || nx < 0 || nx >= C || tmp_arr[ny][nx])	continue;
//
//			if (ny >= R) {
//				return false;
//			}
//
//			if (arr[ny][nx] == 'X') {
//				q.push(make_pair(ny, nx));
//				tmp_arr[ny][nx] = true;
//			}
//		}
//	}
//
//	return true;
//}
//
//void falling(int R, int C, int y, int x) {
//	queue<pair<int, int>> q;
//
//	q.push(make_pair(y, x));
//
//	while (!q.empty()) {
//		int cy = q.front().first;
//		int cx = q.front().second;
//		q.pop();
//
//		if (arr[cy][cx] == 1) {
//			int tmp_y = cy;
//			while (tmp_y < R && arr[tmp_y][cx] == 0)	tmp_y++;
//			arr[cy][cx] = 0;
//			arr[tmp_y - 1][cx] = 1;
//		}
//
//		for (int d = 0; d < 4; d++) {
//			int ny = y + dy[d];
//			int nx = x + dx[d];
//			if (ny < 0 || nx < 0 || ny >= R || nx >= C)	continue;
//			
//			if (arr[ny][nx] == 1) {
//				q.push(make_pair(ny, nx));
//			}
//		}
//	}
//}
//
//void shoot(int R, int C, int h, bool flag) {
//	int index;
//	if (flag) {
//		index = 0;
//		while (index < C && arr[R - h][index] == 0)	index++;
//		if (index < C) {
//			arr[R - h][index] = 0;
//			if (isFalling(R, C, R - h, index))	falling(R, C, R - h, index);
//		}
//	}
//	else {
//		index = C - 1;
//		while (index >= 0 && arr[R - h][index] == 0)	index--;
//		if (index < C) {
//			arr[R - h][index] = 0;
//			if (isFalling(R, C, R - h, index))	falling(R, C, R - h, index);
//		}
//	}
//}
//
//void main(int argc, char* argv[]) {
//	int R, C, N;
//
//	scanf_s("%d %d", &R, &C);
//	
//	for (int i = 0; i < R; i++) {
//		for (int j = 0; j < C; j++) {
//			char val;
//			cin >> val;
//			if (val == 'x') {
//				arr[i][j] = 1;
//			}
//		}
//	}
//
//
//	scanf_s("%d", &N);
//
//	bool flag = true;
//	for (int i = 0; i < N; i++) {
//		int h;
//		scanf_s("%d", &h);
//		shoot(R, C, h, flag);
//		flag = !flag;
//	}
//
//
//	for (int i = 0; i < R; i++) {
//		for (int j = 0; j < C; j++) {
//			printf("%d", arr[i][j]);
//		}
//		printf("\n");
//	}
//}