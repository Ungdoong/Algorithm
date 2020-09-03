#include <stdio.h>
#include <memory>
#define MAX_N 100

class MyStack {
private:
	int top;
	int stack[MAX_N];
public:
	MyStack() {
		top = 0;
		memset(stack, 0, MAX_N);
	}

	bool isEmpty() {
		return top == 0;
	}

	bool isFull() {
		return top == MAX_N;
	}

	int push(int v) {
		if (isFull())	return 0;

		stack[top++] = v;
		return 1;
	}

	int pop(int *v) {
		if (isEmpty())	return 0;

		*v = stack[--top];

		return 1;
	}
};

int main() {
	MyStack stack;

	stack.push(2);
	stack.push(3);

	int v;

	stack.pop(&v);
	printf("%d\n", v);
	stack.pop(&v);
	printf("%d\n", v);
}