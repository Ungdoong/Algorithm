function solution(key, lock) {
  const N = key.length;
  const M = lock.length;
  const lock_indexes = getIndex(lock, 0);
  // 키를 회전시키며 체크
  for (let lotate = 0; lotate <= 270; lotate += 90) {
    let key_indexes = getIndex(key, 1);
    // 키를 이동시키며 체크
    // y축 이동
    for (let di = 1 - N; di < M; di++) {
      // x축 이동
      for (let dj = 1 - N; dj < M; dj++) {
        if (check(lock_indexes, key_indexes, di, dj, M)) return true;
      }
    }

    // 키 회전
    key = lotateRight(key);
  }

  return false;
}

function lotateRight(arr) {
  const N = arr.length;

  let result_arr = [
    [0, 0, 0],
    [0, 0, 0],
    [0, 0, 0],
  ];
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      result_arr[j][N - i - 1] = arr[i][j];
    }
  }

  return result_arr;
}

function getIndex(arr, targetValue) {
  const N = arr.length;
  let result_list = [];
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (arr[i][j] == targetValue) {
        result_list.push([i, j]);
      }
    }
  }

  return result_list;
}

function check(lock, key, dy, dx, M) {
  let lock_indexes = JSON.parse(JSON.stringify(lock))
  for (let k_index of key) {
    let cy = k_index[0] + dy;
    let cx = k_index[1] + dx;
    if (cx < 0 || cy < 0 || cx >= M || cy >= M) continue;
    
    if(lock_indexes.length == 0)  return false;
    
    let check = false;
    for (let i=0; i<lock_indexes.length; i++) {
      if (cy == lock_indexes[i][0] && cx == lock_indexes[i][1]) {
        check = true;
        lock_indexes.splice(i, 1);
        break;
      }
    }

    if(!check)  return false;
  }

  if(lock_indexes.length == 0)  return true;
  else  return false;
}

let sol = solution(
  [
    [0, 0, 0],
    [1, 0, 0],
    [0, 1, 1],
  ],
  [
    [1, 1, 1],
    [1, 1, 0],
    [1, 0, 1],
  ]
);

console.log(sol);
