#include <stdio.h>
#include <iostream>

using namespace std;

int player[100001];

int main(int argc, char* argv[]) {
	int N, jimin, hansu, round = 0;
	bool meet = false;
	cin >> N >> jimin >> hansu;
	jimin--;
	hansu--;
	while (jimin != hansu) {
		jimin = jimin / 2;
		hansu = hansu / 2;
		round++;
	}

	cout << round;
}