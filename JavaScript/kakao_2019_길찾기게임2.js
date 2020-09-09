function solution(nodeInfo) {
  let answer = [[], []];
  let root;

  const Node = function (x, y, id) {
    this.x = x;
    this.y = y;
    this.id = id;
    this.left = null;
    this.right = null;
  };

  const insert = function (x, y, id) {
    if (!root) root = new Node(x, y, id);
    else _insert(root, x, y, id);
  };

  const _insert = function (parent, x, y, id) {
    let side = x < parent.x ? "left" : "right";

    if (parent[side] != null) {
      _insert(parent[side], x, y, id);
    } else {
      parent[side] = new Node(x, y, id);
    }
  };

  const preOrder = function (arr, n) {
    arr.push(n.id);
    if (n.left) preOrder(arr, n.left);
    if (n.right) preOrder(arr, n.right);
  };

  const postOrder = function (arr, n) {
    if (n.left) postOrder(arr, n.left);
    if (n.right) postOrder(arr, n.right);

    arr.push(n.id);
  };

  nodeInfo
    .map(([x, y], i) => {
      return [x, y, i + 1];
    })
    .sort(([, ya], [, yb]) => yb - ya)
    .forEach(([x, y, id]) => insert(x, y, id));

  preOrder(answer[0], root);
  postOrder(answer[1], root);

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
