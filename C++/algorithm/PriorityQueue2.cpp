#include <stdio.h>
#include <memory>

#define MAX 100

class PQ {
private:
	int heap[MAX];
	int size;

public:
	PQ() {
		memset(heap, 0, MAX);
		size = 0;
	}

	int push(int v) {
		if (size == MAX) {
			printf("Full");
			return 0;
		}

		heap[size] = v;
		int current = size;

		while (current > 0 && heap[current] < heap[(current - 1) / 2]) {
			int temp = heap[(current - 1) / 2];
			heap[(current - 1) / 2] = heap[current];
			heap[current] = temp;

			current = (current + 1) / 2;
		}

		size++;

		return 1;
	}

	int pop(int* v) {
		if (size == 0) {
			printf("Empty\n");
			*v = NULL;
			return 0;
		}

		*v = heap[0];
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

			if (heap[current] < heap[child])	break;

			int temp = heap[current];
			heap[current] = heap[child];
			heap[child] = heap[current];

			current = child;
		}

		return 1;
	}
};


void main() {
	PQ pq;

	pq.push(23);
	pq.push(2);
	pq.push(9);
	pq.push(1);

	int v;

	pq.pop(&v);
	printf("%d\n", v);
	pq.pop(&v);
	printf("%d\n", v);
	pq.pop(&v);
	printf("%d\n", v);
	pq.pop(&v);
	printf("%d\n", v);
	pq.pop(&v);
	printf("%d\n", v);
}