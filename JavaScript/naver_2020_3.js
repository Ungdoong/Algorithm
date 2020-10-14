let min = Number.MAX_SAFE_INTEGER
function solution (n, edges) {
  let infection = Array.from({ length: n }, () => false)
  let edge_array = Array.from({ length: n }, () => [])

  for (const edge of edges) {
    edge_array[edge[0]].push(edge[1])
  }
  infection[0] = true;
  find(edge_array, infection)

  return min
}

function find (arr, infec) {
  if (isFinish(arr, infec)) {
    min = Math.min(min, checkNum(infec))
    return
  }

  for (let i=0; i<infec.length; i++) {
    if (!infec[i]) continue
    for (let j = 0; j < arr[i].length; j++) {
      let next_arr = JSON.parse(JSON.stringify(arr))
      next_arr[i].splice(j, 1)
      let next_infec = progress(next_arr, infec)
      find(next_arr, next_infec)
    }
  }
}

function progress (arr, infec) {
  let result = JSON.parse(JSON.stringify(infec))
  for (let i=0; i<infec.length; i++) {
    if (!infec[i]) continue
    for (const connected_com of arr[i]) {
      result[connected_com] = true
    }
  }

  return result
}

function isFinish (arr, infec) {
  for (let i=0; i<infec.length; i++) {
    if (!infec[i]) continue
    for (const connected_com of arr[i]) {
      if (!infec[connected_com]) return false
    }
  }
  return true
}

function checkNum (infec) {
  return infec.reduce((acc, value) => (value ? acc + 1 : acc), 0)
}

console.log(
  solution(10, [[0, 1], [0, 2], [1, 3], [2, 4], [2, 5], [2, 6], [3, 7], [3, 8], [3, 9]])
)
