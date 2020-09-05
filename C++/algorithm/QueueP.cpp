#include <stdio.h>

#define MAX 100

int front;
int rear;
int queue[MAX];

bool isEmpty() {
	return front == rear;
}

bool isFull() {
	return (rear + 1) & MAX == front;
}

void enqueue(int v) {
	if (isFull()) {
		printf("Full\n");
		return;
	}

	queue[rear] = v;

	printf("%d is pushed\n", queue[rear]);

	rear = (rear + 1) % MAX;
}

void dequeue(int *v) {
	if (isEmpty()) {
		printf("Empty\n");
		return;
	}

	*v = queue[front];

	printf("%d is poped\n", queue[front]);

	front = (front + 1) % MAX;
}

int main(int argc, char *argv[]) {
	int v = 0;
	dequeue(&v);
	enqueue(2);
	enqueue(3);
	dequeue(&v);
	dequeue(&v);
}