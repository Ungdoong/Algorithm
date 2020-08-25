#include <stdio.h>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

#define MAX_N 101

int gidoong[MAX_N][MAX_N];
int bo[MAX_N][MAX_N];

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
	vector<vector<int>> answer;

	for (int i = 0; i < build_frame.size(); i++) {
		vector<int> cur= build_frame[i];
		int x = cur[0];	// 가로 좌표
		int y = cur[1];	// 세로 좌표
		int a = cur[2];	// 0:기둥, 1:보
		int b = cur[3];	// 0:삭제, 1:설치

		// 설치
		if (b == 1) {
			insert(x, y, a);
		}
		// 삭제
		else {
			del(x, y, a);
		}
	}

	// answer에 입력
	for (int i = 0; i <= 100; i++) {
		for (int j = 0; j <= 100; j++) {
			if (gidoong[i][j] == 1) {
				vector<int> value;
				value.push_back(i);
				value.push_back(j);
				value.push_back(0);
				answer.push_back(value);
			}

			if (bo[i][j] == 1) {
				vector<int> value;
				value.push_back(i);
				value.push_back(j);
				value.push_back(1);
				answer.push_back(value);
			}
		}
	}

	return answer;
}

void insert(int x, int y, int a) {
	// 기둥 설치
	if (a == 0) {
		// 설치 가능 여부 판별
		if ((x - 1 >= 0 && bo[x - 1][y] == 1) || bo[x][y] == 1 || (y - 1 >= 0 && gidoong[x][y - 1] == 1)) {
			gidoong[x][y] = 1;
		}
	}
	// 보 설치
	else if (a == 1 && y != 0) {
		// 설치 가능 여부 판별
		if ((y - 1 >= 0 && gidoong[x][y - 1] == 1)
			|| (y - 1 >= 0 && x + 1 <= 100 && gidoong[x + 1][y - 1] == 1)
			|| (x = 1 >= 0 && bo[x - 1][y] == 1 && x + 1 <= 100 && bo[x + 1][y] == 1)) {
			bo[x][y] = 1;
		}
	}
}

bool isPossible(int x, int y, int a) {
	// 보일 경우
	if (a == 1) {
		// 가능한지 체크
		if ((x - 1 >= 0 && bo[x - 1][y] == 1 && x + 1 <= 100 && bo[x + 1][y] == 1) 
			|| (x + 1 <= 100 && gidoong[x + 1][y - 1] == 1)) {
			return true;
		}
	}
	// 기둥일 경우
	else {
		// 가능한지 체크
		if ((y - 1 > 0 && gidoong[x][y - 1] == 1) || (x - 1 >= 0 && bo[x - 1][y] == 1)) {
			return true;
		}
	}
}

void del(int x, int y, int a) {
	bool flag = true;

	if (y + 1 > 100) {
		if (a == 0)	gidoong[x][y] = 0;
		if (a == 1)	bo[x][y] = 0;
	}

	// 기둥이면
	if (a == 0) {
		// 위에 보가 올려져있는지 체크
		if (bo[x][y + 1 == 1]) {
			if (!isPossible(x, y + 1, 1))	flag = false;
		}
		// 위에 보가 없고 기둥이 있는 경우
		else if(gidoong[x][y+1] == 1) {
			flag = false;
		}
	}
	// 보
	else {
		// 왼쪽에 보가 있음
		if (x - 1 >= 0 && bo[x - 1][y] == 1) {
			if (!isPossible(x - 1, y, 1))	flag = false;
		}
		// 오른쪽에 보가 있음
		if (x + 1 <= 100 && bo[x + 1][y] == 1) {
			if (!isPossible(x + 1, y, 1))	flag = false;
		}
		// 위에 기둥이 있음
		if (gidoong[x][y] == 1) {
			if (!isPossible(x, y, 0))	flag = false;
		}
	}

	// 제거
	if (flag) {
		if (a == 0)	gidoong[x][y] = 0;
		if (a == 1) bo[x][y] = 0;
	}
}

int main(int argc, char* argv[]) {
	
}