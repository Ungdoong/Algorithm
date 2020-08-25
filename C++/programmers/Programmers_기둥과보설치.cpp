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
		int x = cur[0];	// ���� ��ǥ
		int y = cur[1];	// ���� ��ǥ
		int a = cur[2];	// 0:���, 1:��
		int b = cur[3];	// 0:����, 1:��ġ

		// ��ġ
		if (b == 1) {
			insert(x, y, a);
		}
		// ����
		else {
			del(x, y, a);
		}
	}

	// answer�� �Է�
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
	// ��� ��ġ
	if (a == 0) {
		// ��ġ ���� ���� �Ǻ�
		if ((x - 1 >= 0 && bo[x - 1][y] == 1) || bo[x][y] == 1 || (y - 1 >= 0 && gidoong[x][y - 1] == 1)) {
			gidoong[x][y] = 1;
		}
	}
	// �� ��ġ
	else if (a == 1 && y != 0) {
		// ��ġ ���� ���� �Ǻ�
		if ((y - 1 >= 0 && gidoong[x][y - 1] == 1)
			|| (y - 1 >= 0 && x + 1 <= 100 && gidoong[x + 1][y - 1] == 1)
			|| (x = 1 >= 0 && bo[x - 1][y] == 1 && x + 1 <= 100 && bo[x + 1][y] == 1)) {
			bo[x][y] = 1;
		}
	}
}

bool isPossible(int x, int y, int a) {
	// ���� ���
	if (a == 1) {
		// �������� üũ
		if ((x - 1 >= 0 && bo[x - 1][y] == 1 && x + 1 <= 100 && bo[x + 1][y] == 1) 
			|| (x + 1 <= 100 && gidoong[x + 1][y - 1] == 1)) {
			return true;
		}
	}
	// ����� ���
	else {
		// �������� üũ
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

	// ����̸�
	if (a == 0) {
		// ���� ���� �÷����ִ��� üũ
		if (bo[x][y + 1 == 1]) {
			if (!isPossible(x, y + 1, 1))	flag = false;
		}
		// ���� ���� ���� ����� �ִ� ���
		else if(gidoong[x][y+1] == 1) {
			flag = false;
		}
	}
	// ��
	else {
		// ���ʿ� ���� ����
		if (x - 1 >= 0 && bo[x - 1][y] == 1) {
			if (!isPossible(x - 1, y, 1))	flag = false;
		}
		// �����ʿ� ���� ����
		if (x + 1 <= 100 && bo[x + 1][y] == 1) {
			if (!isPossible(x + 1, y, 1))	flag = false;
		}
		// ���� ����� ����
		if (gidoong[x][y] == 1) {
			if (!isPossible(x, y, 0))	flag = false;
		}
	}

	// ����
	if (flag) {
		if (a == 0)	gidoong[x][y] = 0;
		if (a == 1) bo[x][y] = 0;
	}
}

int main(int argc, char* argv[]) {
	
}