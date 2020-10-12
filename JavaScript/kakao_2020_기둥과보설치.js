const GD = 0;
const BO = 1;
const DEL = 0;
const CON = 1;

function solution(n, build_frame) {
  let map = Array(n + 1);
  // (n + 1) X (n + 1) 배열을 0으로 초기화
  for (let i = 0; i < map.length; i++) {
    map[i] = Array.from({ length: n + 1 }, () => 0);
  }
  // build_frame을 하나씩 확인
  for (let build of build_frame) {
    if (!isPossible(map, build)) {
      continue;
    }

    // 설치일 경우
    if (build[3] == CON) construction(map, build);
    // 삭제일 경우
    else del(map, build);
  }

  let result = [];
  for (let i = 0; i < n + 1; i++) {
    for (let j = 0; j < n + 1; j++) {
      if ((map[i][j] & 1) == 1) {
        result.push([j, i, 0]);
      } else if (map[i][j] >= 2) {
        result.push([j, i, 1]);
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

function isPossible(map, condition) {
  const N = map.length;
  const X = condition[0];
  const Y = condition[1];
  const KIND = condition[2];
  const ACT = condition[3];

  // 설치
  if (ACT == CON) {
    // 기둥
    if (KIND == GD) {
      const UNDER = Y - 1;
      const LEFT = X - 1;
      if (Y == N - 1) return false;
      return (
        Y == 0 ||
        (LEFT >= 0 && map[Y][LEFT] >= 2) ||
        (UNDER >= 0 && (map[UNDER][X] & 1) == 1)
      );
    }
    // 보
    else {
      const LEFT = X - 1;
      const RIGHT = X + 1;
      const UNDER = Y - 1;
      if (X == N - 1) return false;
      return (
        (UNDER >= 0 && (map[UNDER][X] & 1) == 1) ||
        (RIGHT < N && UNDER >= 0 && (map[UNDER][RIGHT] & 1) == 1) ||
        (LEFT >= 0 && RIGHT < N && map[Y][LEFT] >= 2 && map[Y][RIGHT] >= 2)
      );
    }
  }
  // 삭제
  else {
    // 기둥
    if (KIND == GD) {
      const TOP = Y + 1;
      const LEFT = X - 1;

      let tmp_map = JSON.parse(JSON.stringify(map));
      tmp_map[Y][X] = tmp_map[Y][X] & 2;

      // 기둥 위에 보 존재
      if (
        map[TOP][X] >= 2 &&
        !isPossible(tmp_map, [X, TOP, 1, 1]) &&
        LEFT >= 0 &&
        map[TOP][LEFT] >= 2 &&
        !isPossible(tmp_map, [LEFT, TOP, 1, 1])
      )
        return false;
      else return (map[TOP][X] & 1) != 1;
    }
    // 보
    else {
      const LEFT = X - 1;
      const RIGHT = X + 1;

      let tmp_map = JSON.parse(JSON.stringify(map));
      tmp_map[Y][X] = tmp_map[Y][X] & 1;
      // 왼쪽에 보가 존재
      if (
        LEFT >= 0 &&
        map[Y][LEFT] >= 2 &&
        !isPossible(tmp_map, [LEFT, Y, 1, 1])
      )
        return false;

      // 오른쪽에 보가 존재
      if (
        RIGHT < N &&
        map[Y][RIGHT] >= 2 &&
        !isPossible(tmp_map, [RIGHT, Y, 1, 1])
      )
        return false;

      // 위에 기둥이 존재
      if ((map[Y][X] & 1) == 1 && !isPossible(tmp_map, [X, Y, 0, 1]))
        return false;
      if (
        RIGHT < N &&
        (map[Y][RIGHT] & 1) == 1 &&
        !isPossible(tmp_map, [RIGHT, Y, 0, 1])
      )
        return false;

      return true;
    }
  }
}

// 설치 함수
function construction(map, build) {
  const X = build[0];
  const Y = build[1];
  // 기둥일 경우
  if (build[2] == GD) map[Y][X] = map[Y][X] | 1;
  // 보일 경우
  else map[Y][X] = map[Y][X] | 2;
}

// 삭제 함수
function del(map, build) {
  const X = build[0];
  const Y = build[1];
  // 기둥일 경우
  if (build[2] == GD) map[Y][X] = map[Y][X] & 2;
  // 보일 경우
  else map[Y][X] = map[Y][X] & 1;
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
