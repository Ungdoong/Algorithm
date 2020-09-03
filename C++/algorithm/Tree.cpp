#include <stdio.h>
#include <memory>

#define MAX_NODE_NUM 10000
#define MAX_CHILD_NUM 2

typedef struct {
	int parent;
	int child[MAX_CHILD_NUM];
}TreeNode;

class MyTree {
private:
	TreeNode tree[MAX_NODE_NUM];
	int nodeNum;

public:
	MyTree(int n_node) {
		nodeNum = n_node;
		for (int i = 0; i <= nodeNum; i++) {
			tree[i].parent = -1;
			for (int j = 0; j < MAX_CHILD_NUM; j++) {
				tree[i].child[j] = -1;
			}
		}
	}

	void addChild(int parent, int child) {
		int index = 0;
		for (int i = 0; i < MAX_CHILD_NUM; i++) {
			if (tree[parent].child[i] == -1) {
				index = i;
				break;
			}
		}

		tree[parent].child[index] = child;
		tree[child].parent = parent;
	}

	int getRoot() {
		int i;
		int j;
		for (i = 1; i <= nodeNum; i++) {
			if (tree[i].parent == -1) {
				return i;
			}
		}

		return -1;
	}

	void preOrder(int root) {
		int i;
		int child;
		printf("%d ", root);

		for (i = 0; i < MAX_CHILD_NUM; i++) {
			child = tree[root].child[i];
			if (child != -1) {
				preOrder(child);
			}
		}
	}
};

void main() {
	MyTree tree(13);

	tree.addChild(1, 2);
	tree.addChild(1, 3);
	tree.addChild(2, 4);
	tree.addChild(3, 5);
	tree.addChild(3, 6);
	tree.addChild(4, 7);
	tree.addChild(7, 12);
	tree.addChild(5, 9);
	tree.addChild(5, 8);
	tree.addChild(6, 11);
	tree.addChild(6, 10);
	tree.addChild(11, 13);

	int root = tree.getRoot();
	tree.preOrder(root);
}