#include <stdio.h>

#define MAX_NODE_NUM 10001
#define MAX_CHILD_NUM 2

typedef struct {
	int parent;
	int child[MAX_CHILD_NUM];
}TreeNode;

TreeNode tree[MAX_NODE_NUM];
int nodeNum;
int edgeNum;
int root;

void initTree() {
	int i, j;
	for (i = 0; i <= nodeNum; i++) {
		tree[i].parent = -1;
		for (j = 0; j < MAX_CHILD_NUM; j++) {
			tree[i].child[j] = -1;
		}
	}
}

void addChild(int parent, int child) {
	for (int i = 0; i < MAX_CHILD_NUM; i++) {
		if (tree[parent].child[i] == -1) {
			tree[parent].child[i] = child;
			tree[child].parent = parent;
			printf("[AddChild]\n");
			printf("tree[%d].child[%d] = %d\n", parent, i, tree[parent].child[i]);
			printf("tree[%d].parent = %d\n", child, tree[child].parent);
			return;
		}
	}
}

int getRoot() {
	for (int i = 1; i <= nodeNum; i++) {
		if (tree[i].parent == -1) {
			return i;
		}
	}
}

void preOrder(int p) {
	int i, child;
	printf("%d ", p);

	for (i = 0; i < MAX_CHILD_NUM; i++) {
		child = tree[p].child[i];
		if (child != -1) {
			preOrder(child);
		}
	}
}

int main(int argc, char *argv[]) {
	nodeNum = 13;
	edgeNum = 12;
	initTree();

	addChild(1, 2);
	addChild(1, 3);
	addChild(2, 4);
	addChild(3, 5);
	addChild(3, 6);
	addChild(4, 7);
	addChild(7, 12);
	addChild(5, 9);
	addChild(5, 8);
	addChild(6, 11);
	addChild(6, 10);
	addChild(11, 13);

	root = getRoot();

	preOrder(root);
}