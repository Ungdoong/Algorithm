const GI = 0;
const BO = 1;
const CON = 0;
const DEL = 1;

function solution(n, build_frame) {
  let map = Array(n + 1);
  for (let i=0; i<n+1; i++) map[i] = Array.from({ length: n + 1 }, () => [false, false]);

  for(const build of build_frame){
    const [x, y, what, how] = build
    
    if(how == CON)  map[y][x][what] = true
    else  map[y][x][what] = false


  }
}

function check(map, n){
  for(let y=0; y<n+1; y++){
    for(let x=0; x<n+1; x++){
      // 기둥 체크
      if(map[y][x][0]){
        if(y != 0 && !map[y-1][x][0] && !map[y-1][x][1])  return false 
      }

      // 보 체크
      if(map[y][x][1]){
        const right = x + 1
        const left = y - 1
      }
    }
  }
}

console.log(
  solution(5, [
    [1, 0, 0, 1],
    [1, 1, 1, 1],
    [2, 1, 0, 1],
    [2, 2, 1, 1],
    [5, 0, 0, 1],
    [5, 1, 0, 1],
    [4, 2, 1, 1],
    [3, 2, 1, 1],
  ])
);
