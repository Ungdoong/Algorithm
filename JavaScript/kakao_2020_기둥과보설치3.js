const GI = 0;
const BO = 1;
const CON = 0;
const DEL = 1;

function solution(n, build_frame) {
  let map = Array(n + 1);
  for (let row of map) row = Array.from({ length: n + 1 }, [false, false]);

  for (let i = 0; i <= n; i++) {
    for (let j = 0; j <= n; j++) {
      console.log(map[j][i]+' ')
    }
    console.log('\n')
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
