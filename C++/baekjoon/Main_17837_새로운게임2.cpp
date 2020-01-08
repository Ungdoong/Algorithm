#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

const int dx[5] = {0, 1, -1, 0, 0};
const int dy[5] = { 0, 0, 0, -1, 1 };
int N, K;
bool finish;
int map[12][12][5];
int horses[11][4];

void white(int cy, int cx, int cz, int ny, int nx) {
	int nz = 1;
	while (map[ny][nx][nz] > 0)	nz++;

	while (nz <= 4 && map[cy][cx][cz] > 0) {
		map[ny][nx][nz] = map[cy][cx][cz];
		map[cy][cx][cz] = 0;
		horses[map[ny][nx][nz]][0] = ny;
		horses[map[ny][nx][nz]][1] = nx;
		horses[map[ny][nx][nz]][2] = nz;
		nz++;
		cz++;
	}

	if (nz > 4)	finish = true;
}

void red(int cy, int cx, int cz, int ny, int nx) {
	int nz = 1;
	while (map[ny][nx][nz] > 0)	nz++;

	int cz_start = 4;
	while (map[cy][cx][cz_start] <= 0)	cz_start--;

	while (nz <= 4 && cz_start >= cz) {
		map[ny][nx][nz] = map[cy][cx][cz_start];
		map[cy][cx][cz_start] = 0;
		horses[map[ny][nx][nz]][0] = ny;
		horses[map[ny][nx][nz]][1] = nx;
		horses[map[ny][nx][nz]][2] = nz;
		nz++;
		cz_start--;
	}

	if (nz > 4)	finish = true;
}

void blue(int h) {
	int cy = horses[h][0];
	int cx = horses[h][1];
	int cz = horses[h][2];
	int dir = horses[h][3];
	if (dir == 1 || dir == 3)	dir++;
	else if (dir == 2 || dir == 4)	dir--;
	horses[h][3] = dir;
	int nx = cx + dx[dir];
	int ny = cy + dy[dir];

	if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx][0] == 2) { }
	else if (map[ny][nx][0] == 1)	red(cy, cx, cz, ny, nx);
	else white(cy, cx, cz, ny, nx);
}

void run(int h) {
	int cy = horses[h][0];
	int cx = horses[h][1];
	int cz = horses[h][2];
	int dir = horses[h][3];
	int ny = cy + dy[dir];
	int nx = cx + dx[dir];

	if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx][0] == 2) {
		blue(h);
	}
	else if (map[ny][nx][0] == 0)	white(cy, cx, cz, ny, nx);
	else red(cy, cx, cz, ny, nx);
}

int main() {
	int turn = 1;
	scanf("%d %d", &N, &K);

	for (int i=0; i<N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &map[i][j][0]);
		}
	}

	for (int i = 1; i <= K; i++) {
		scanf("%d", &horses[i][0]);
		horses[i][0]--;
		scanf("%d", &horses[i][1]);
		horses[i][1]--;
		horses[i][2] = 1;
		scanf("%d", &horses[i][3]);
		map[horses[i][0]][horses[i][1]][1] = i;
	}

	finish = false;
	while (!finish && turn <= 1000) {
		for (int h = 1; h <= K; h++) {
			run(h);

			if (finish)	break;
		}
		if (!finish)	turn++;
	}

	if (turn > 1000)
		printf("-1");
	else
		printf("%d", turn);
}