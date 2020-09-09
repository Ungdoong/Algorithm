class Node {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
class Tree {
  constructor() {
    this.root = null;
  }

  addChild(val) {
    let newNode = new Node(val);

    if (!this.root) {
      this.root = newNode;
      return;
    }

    let cur = this.root;
    while (cur) {
      if (val[0] < cur.val[0]) {
        if (!cur.left) {
          cur.left = newNode;
          cur = null;
        } else {
          cur = cur.left;
        }
      } else {
        if (!cur.right) {
          cur.right = newNode;
          cur = null;
        } else {
          cur = cur.right;
        }
      }
    }
  }
  getRoot() {
    return this.root;
  }

  preOrder(arr, node) {
    arr.push(node.val[2]);

    if (node.left) this.preOrder(arr, node.left);
    if (node.right) this.preOrder(arr, node.right);
  }

  postOrder(arr, node) {
    if (node.left) this.postOrder(arr, node.left);
    if (node.right) this.postOrder(arr, node.right);
    arr.push(node.val[2]);
  }
}

function solution(nodeinfo) {
  let answer = [[], []];
  let nodes = nodeinfo
    .map((v, i) => {
      v.push(i + 1);
      return v;
    })
    .sort((a, b) => (b[1] - a[1] == 0 ? a[0] - b[0] : b[1] - a[1]));
  let tree = new Tree();
  for (let n of nodes) {
    tree.addChild(n);
  }

  tree.preOrder(answer[0], tree.getRoot());
  tree.postOrder(answer[1], tree.getRoot());

  return answer;
}

solution([
  [5, 3],
  [11, 5],
  [13, 3],
  [3, 5],
  [6, 1],
  [1, 3],
  [8, 6],
  [7, 2],
  [2, 2],
]);
