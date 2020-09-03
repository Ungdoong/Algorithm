#include <stdio.h>
#include <memory>
#define MAX_SIZE 100

class MyPQ {
private:
	int heap[MAX_SIZE];
	int size;
public:
	MyPQ() {
		size = 0;
		memset(heap, 0, MAX_SIZE);
	}

	int push(int v) {
		if (size >= MAX_SIZE) {
			printf("pq is full");
			return 0;
		}

		heap[size] = v;

		int current = size;
		while (current > 0 && heap[current] < heap[(current - 1) / 2]) {
			int temp = heap[(current - 1) / 2];
			heap[(current - 1) / 2] = heap[current];
			heap[current] = temp;
			current = (current - 1) / 2;
		}

		size = size + 1;

		return 1;
	}

	int pop(int *v) {
		if (size <= 0) {
			printf("is Empty");
			return 0;
		}

		*v= heap[0];
		size--;
		
		heap[0] = heap[size];
		int current = 0;
		while (current * 2 + 1 < size) {
			int child;
			if (current * 2 + 2 == size) {
				child = current * 2 + 1;
			}
			else {
				child = (heap[current * 2 + 1] < heap[current * 2 + 2]) ? current * 2 + 1 : current * 2 + 2;
			}

			if (heap[current] < heap[child]) {
				break;
			}

			int temp = heap[current];
			heap[current] = heap[child];
			heap[child] = temp;

			current = child;
		}

		return 1;
	}
};


void main() {
	int T, N;

	scanf_s("%d", &T);

	for (int test_case = 1; test_case <= T; test_case++) {
		scanf_s("%d", &N);

		MyPQ pq;

		for (int i = 0; i < N; i++) {
			int value;
			scanf_s("%d", &value);
			pq.push(value);
		}

		printf("#%d ", test_case);

		for (int i = 0; i < N; i++) {
			int value;
			pq.pop(&value);
			printf("%d ", value);
		}
		printf("\n");
	}
}