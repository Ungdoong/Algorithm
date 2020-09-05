#include <stdio.h>
#include <memory>

#define MAX 100

int size;
int stack[MAX];

bool isEmpty() {
	return size == 0;
}

bool isFull() {
	return size == MAX;
}

void push(int v) {
	if (isFull()) {
		printf("Full\n");
		return;
	}

	stack[size] = v;

	printf("%d is pushed\n", stack[size++]);
}

void pop(int *v) {
	if (isEmpty()) {
		printf("Empty\n");
		return;
	}

	size--;
	*v = stack[size];

	printf("%d is poped\n", *v);
}

int main(int argc, char* argv[]) {
	int v = 0;
	pop(&v);
	push(2);
	push(3);
	pop(&v);
	pop(&v);
}