#include <stdio.h>
#include <iostream>
#include <malloc.h>
#include "KMP.h"

using namespace std;

int* KMP::getPi(char* p) {
	int M = strlen(p);
	int j = 0;
	static int pi[100];
	fill_n(pi, 100, 0);

	for (int i = 1; i < M; i++) {
		while (j > 0 && p[i] != p[j])	j = pi[j - 1];
		if (p[i] == p[j])	pi[i] = ++j;
	}

	return pi;
}

int KMP::kmp(char* str, char* pattern) {
	int j = 0, result = 0;
	int *pi = getPi(pattern);
	int N = strlen(str);
	int M = strlen(pattern);

	for (int i = 0; i < N; i++) {
		while (j > 0 && str[i] != pattern[j])	j = pi[j - 1];
		if (str[i] == pattern[j]) {
			if (j == M - 1) {
				result++;
				j = pi[j];
			}
			else {
				j++;
			}
		}
	}

	return result;
}