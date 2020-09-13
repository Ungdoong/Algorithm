function solution (boxes) {
  let answer = 0

  let N = boxes.length
  let check = []

  // 짝 맞추기
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < 2; j++) {
      let fruit = boxes[i][j]
      if (check[fruit] == null) {
        check[fruit] = [i, j]
      } else {
        let target = check[fruit]
        target[1] = (target[1] + 1) % 2

        let tmp = boxes[target[0]][target[1]]
        boxes[target[0]][target[1]] = boxes[i][j]
        boxes[i][j] = tmp

        check[tmp] = [i, j]
        check[fruit] = null;
      }
    }
  }
  
  // 모자란거 구하기
  for(let box of boxes){
      if(box[0] != box[1]){
          answer++;
      }
  }

  return answer
}

let sol = solution([
  [1, 2],
  [2, 1],
  [3, 3],
  [4, 5],
  [5, 6],
  [7, 8]
])

console.log(sol)
