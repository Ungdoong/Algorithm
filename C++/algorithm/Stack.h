#pragma once

#ifndef __STACK_H__
#define __STACK_H__

class MyStack {
private:
	int top;
	int size;
	int *stack;
public:
	MyStack(void) {
		stackInit();
	}

	void stackInit(void);
	bool isEmpty();
	bool isFull();
	int push(int v);
	int pop();
};
#endif // !
