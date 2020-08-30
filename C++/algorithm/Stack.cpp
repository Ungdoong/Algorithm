#include <stdio.h>
#include <iostream>
#include <malloc.h>
#include "Stack.h"

using namespace std;

void MyStack::stackInit() {
	top = 0;
	size = 100;
	stack = (int*)malloc(sizeof(int) * size);
}

bool MyStack::isEmpty() {
	return top == 0;
}

bool MyStack::isFull() {
	return top == size;
}

int MyStack::push(int v) {
	if (isFull()) {
		cout << "Stack is Full" << endl;
		return 0;
	}

	*(stack + top) = v;
	cout << "pushed : " << *(stack + top) << endl;
	top++;

	return 1;
}

int MyStack::pop() {
	if (isEmpty()) {
		cout << "Stack is Empty" << endl;
		return 0;
	}

	int value = *(stack + --top);
	cout << "pop : " << value << endl;

	return value;
}