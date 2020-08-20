//#include <stdio.h>
//
//#define MAX_N 200000
//
//int cave[MAX_N];
//int tmp[MAX_N];
//
//void quick(int *data, int start, int end) {
//	if (start >= end)	return;
//	int pivot = data[(start+end)/2];
//	int left = start;
//	int right = end;
//	int temp;
//
//	while (left <= right) {
//		while (data[left] < pivot)	left++;
//		while (data[right] > pivot)	right--;
//
//		if (left <= right) {
//			temp = data[left];
//			data[left] = data[right];
//			data[right] = temp;
//			left++;
//			right--;
//		}
//	}
//
//	quick(data, start, right);
//	quick(data, left, end);
//}
//
//void main(int argc, char* argv[]) {
//	int N, H, min = 200000, count = 1;
//
//	scanf_s("%d %d", &N, &H);
//
//	for (int i = 0; i < N; i++) {
//		scanf_s("%d", &cave[i]);
//	}
//
//	// 개똥벌레가 지나가는 높이 변화
//	for (int i = 1; i <= N; i++) {
//		// 임시 배열 입력
//		for (int j = 0; j < N; j++) {
//			if (j % 2 == 0) {
//				tmp[j] = cave[j];
//			}
//			else {
//				tmp[j] = ((cave[j] + i) - H)
//		> 0 ? i : 0;
//			}
//		}
//
//		// 배열 정렬
//		quick(tmp, 0, N - 1);
//
//		printf("=====================================\n");
//		for (int i = 0; i < N; i++) {
//			printf("%d\n", tmp[i]);
//		}
//		printf("=====================================\n");
//
//		int index = N / 2;
//		if (tmp[index] < i) {
//			while (tmp[index] < i)	index++;
//		}
//		else {
//			while (tmp[index] >= i)	index--;
//		}
//
//		printf("index : %d\n", index);
//		int result = N - index - 1;
//
//		if (min > result) {
//			min = result;
//			count = 1;
//		}else if(min == result){
//			count++;
//		}
//
//		printf("%d : %d, %d\n", i, min, result);
//	}
//
//	printf("%d %d", min, count);
//}