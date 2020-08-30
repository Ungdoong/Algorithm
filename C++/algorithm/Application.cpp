#include <stdio.h>
#include <iostream>
#include <algorithm>
#include "BinarySearch.h"
#include "KMP.h"
#include "Stack.h"

using namespace std;

int* test() {
	static int arr[10] = { 0, 1, 2, 3, 4, 5,6,7 , 8, 9 };

	return arr;
}

int main(int argc, char* argv) {
	// BinarySearch
	//int arr[10] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
	//BinarySearch binary_seacrh;
	//sort(arr, arr+10);
	//binary_seacrh.binarySearch(0, 9, 9, arr);

	// ===============================================
	// KMP
	/*char pattern[100];
	char str[100];

	cout << "패턴 : ";
	cin >> pattern;
	cout << "문자열 : ";
	cin >> str;

	KMP kmp;

	cout << kmp.kmp(str, pattern) << endl;*/

	// ===============================================
	// Stack
	MyStack stack;
	stack.push(1);
	cout << stack.pop() << endl;

	return 0;
}