#include <iostream>
#include "BinarySearch.h"

using namespace std;

bool BinarySearch::binarySearch(int left, int right, int key, int arr[]) {
	if (left > right) return false;
	int middle = (left + right) / 2;
	if (arr[middle] == key) {
		cout << "index : " << middle << " / arr[" << middle << "] : " << arr[middle] << endl;
		return true;
	}
	else if (arr[middle] < key)	return binarySearch(middle + 1, right, key, arr);
	else	return binarySearch(left, middle - 1, key, arr);
}