function solution(key, lock) {
  for (let lotate = 0; lotate <= 270; lotate += 90) {
    



    // 키 회전
    key = lotateRight(key);
  }
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

function getIndex(arr, targetValue){
  const N = arr.length;
  let result_list = [];
  for(let i=0; i<N; i++){
    for(let j=0; j<N; j++){
      if(arr[i][j] == targetValue)  result_list.push([i, j])
    }
  }
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
