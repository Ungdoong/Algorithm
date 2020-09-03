#include <stdio.h>
#include <memory>
#define MAX_N 100

class MyQueue {
private:
	int front;
	int rear;
	int table[MAX_N];

public:
	MyQueue() {
		front = 0;
		rear = 0;
		memset(table, 0, MAX_N);
	}

	bool isEmpty() {
		return front == rear;
	}

	bool isFull() {
		return (rear + 1) % MAX_N == front;
	}

	int enqueue(int v) {
		if (isFull())	return 0;

		table[rear] = v;
		rear = (rear + 1) % MAX_N;

		return 1;
	}

	int dequeue(int *v) {
		if (isEmpty())	return 0;

		*v = table[front];

		front = (front + 1) % MAX_N;

		return 1;
	}
};


void main() {
	MyQueue q;

	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);

	int v;

	q.dequeue(&v);
	printf("%d\n", v);
	q.dequeue(&v);
	printf("%d\n", v);
	q.dequeue(&v);
	printf("%d\n", v);
}