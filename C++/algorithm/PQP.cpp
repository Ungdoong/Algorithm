#include <stdio.h>

#define MAX 100

int size;
int heap[MAX];

void add(int v) {
	if (size == MAX) {
		printf("Full\n");
		return;
	}

	heap[size] = v;
	int cur = size;

	while (cur > 0 && heap[cur] < heap[(cur - 1) / 2]) {
		int temp = heap[cur];
		heap[cur] = heap[(cur - 1) / 2];
		heap[(cur - 1) / 2] = temp;

		cur = (cur - 1) / 2;
	}

	size++;
	for (int i = 0; i < size; i++) {
		printf("%d ", heap[i]);
	}
	printf("\n");
}

void pop(int *v) {
	if (size == 0) {
		printf("Empty\n");
		return;
	}

	*v = heap[0];
	heap[0] = heap[--size];
	int cur = 0;

	while (cur * 2 + 1 < size) {
		int child;
		if (cur * 2 + 2 == size) {
			child = cur * 2 + 1;
		}
		else {
			child = (heap[cur * 2 + 1] < heap[cur * 2 + 2]) ? cur * 2 + 1 : cur * 2 + 2;
		}

		if (heap[cur] < heap[child])	break;

		int temp = heap[cur];
		heap[cur] = heap[child];
		heap[child] = temp;

		cur = child;
	}
	for (int i = 0; i < size; i++) {
		printf("%d ", heap[i]);
	}
	printf("\n");
}

int main(int argc, char* argv[]) {
	int arr[10] = { 10, 49, 38, 17, 56, 92, 8, 1, 13, 55 };
	int v = 0;
	pop(&v);
	for (int i = 0; i < 10; i++) {
		add(arr[i]);
	}

	pop(&v);
	pop(&v);
	pop(&v);
	pop(&v);
	pop(&v);
}