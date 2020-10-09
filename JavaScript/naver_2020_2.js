function solution (blocks) {
  const N = blocks.length
  let tree = Array(N)

  for (let i = 0; i < N; i++) {
    if (tree[i] == null) tree[i] = []
    tree[i][blocks[i][0]] = blocks[i][1]
  }

  for (let i = 0; i < tree.length - 1; i++) {
    for (let j = 0; j < tree[i].length; j++) {
      if (tree[i][j] == null) continue
      const left = j
      const right = j + 1
      if (
        (tree[i + 1][left] == null && tree[i + 1][right] == null) ||
        (tree[i + 1][left] && tree[i + 1][right])
      )
        continue
      if (tree[i + 1][left] == null) {
        tree[i + 1][left] = tree[i][j] - tree[i + 1][right]
        j = -1;
      } else if (tree[i + 1][right] == null) {
        tree[i + 1][right] = tree[i][j] - tree[i + 1][left]
        j = -1;
      }
    }
  }

  let answer = [];
  for(const line of tree){
    for(const num of line)  answer.push(num)
  }

  return answer
}

console.log(
  solution([[0, 92], [1, 20], [2, 11], [1, -81], [3, 98]])
)
