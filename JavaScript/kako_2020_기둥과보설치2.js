const DEL = 0;
const CON = 1;

function solution(n, build_frame) {
  let map = Array(n + 1);
  // (n + 1) X (n + 1) 배열을 0으로 초기화
  for (let y = 0; y < map.length; y++) {
    map[y] = Array.from({ length: n + 1 }, () => 0);
  }
  // build_frame을 하나씩 확인
  for (let build of build_frame) {
    const X = build[0];
    const Y = build[1];
    const KIND = build[2];
    const ACT = build[3];

    // 수행
    if (ACT == CON) {
      map[Y][X] = map[Y][X] | (1 << KIND);
    } else {
      map[Y][X] = map[Y][X] & (1 << (KIND + 1) % 2);
    }

    // 체크
    if (!validate(map)) {
      // 적합하지않으면 복원
      if (ACT == DEL) {
        map[Y][X] = map[Y][X] | (1 << KIND);
      } else {
        map[Y][X] = map[Y][X] & (1 << (KIND + 1) % 2);
      }
    }
  }

  let result = [];
  for (let y = 0; y < n + 1; y++) {
    for (let j = 0; j < n + 1; j++) {
      if ((map[y][j] & 1) == 1) {
        result.push([j, y, 0]);
      } else if (map[y][j] >= 2) {
        result.push([j, y, 1]);
      }
    }
  }

  result.sort((a, b) => {
    return a[0] != b[0]
      ? a[0] - b[0]
      : a[1] != b[1]
      ? a[1] - b[1]
      : a[2] - b[2];
  });

  return result;
}

function validate(map) {
  const N = map.length;
  for (let y = 0; y < N; y++) {
    for (let x = 0; x < N; x++) {
      // 자리에 기둥이 있음
      if ((map[y][x] & 1) == 1) {
        const UNDER = y - 1;
        const LEFT = x - 1;
        if (y == 0) continue; // 바닥 체크
        if (map[y][x] >= 2) continue; // 세우려는 자리에 보가 있는지
        if ((map[UNDER][x] & 1) == 1) continue; // 아래에 기둥이 있는지
        if (LEFT >= 0 && map[y][LEFT] >= 2) continue; // 세우려는 자리 왼쪽부터 보가 오는지

        return false;
      }
      // 자리에 보가 있음
      if (map[y][x] >= 2) {
        const UNDER = y - 1;
        const LEFT = x - 1;
        const RIGHT = x + 1;
        if (UNDER >= 0 && (map[UNDER][x] & 1) == 1) continue; // 아래에 기둥이 있는지
        if (UNDER >= 0 && RIGHT < N && (map[UNDER][RIGHT] & 1) == 1) continue; // 오른쪽 아래에 기둥이 있는지
        if (LEFT >= 0 && RIGHT < N && map[y][LEFT] >= 2 && map[y][RIGHT] >= 2)
          continue; // 양쪽에 보가 있는지

        return false;
      }
    }
  }

  return true;
}

let sol = solution(5, [
  [0, 0, 0, 1],
  [2, 0, 0, 1],
  [4, 0, 0, 1],
  [0, 1, 1, 1],
  [1, 1, 1, 1],
  [2, 1, 1, 1],
  [3, 1, 1, 1],
  [2, 0, 0, 0],
  [1, 1, 1, 0],
  [2, 2, 0, 1],
]);

console.log(sol);
