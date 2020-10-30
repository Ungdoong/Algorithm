let min = Number.MAX_SAFE_INTEGER;
let N;
function jumpingOnClouds(c) {
  N = c.length;
  find(c, 0, 0);

  return min;
}

function find(clouds, cur, count) {
  console.log(cur)
  if (cur >= N - 1) {
    min = Math.min(min, count);
    return;
  }

  for (let jump = 1; jump <= 2; jump += 1) {
    const next_pos = cur + jump;
    if (next_pos >= N || clouds[next_pos] == 1) continue;
    find(clouds, next_pos, count + 1);
  }
}

console.log(jumpingOnClouds([0, 0, 1, 0, 0, 1, 0]));
