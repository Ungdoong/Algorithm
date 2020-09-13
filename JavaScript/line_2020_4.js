function solution (maze) {
  const dx = [1, 0, -1, 0]
  const dy = [0, 1, 0, -1]
  const dir = {
    BOTTOM: 0,
    LEFT: 1,
    TOP: 2,
    RIGHT: 3
  }
  const N = maze.length
  let cx = 0
  let cy = 0
  let count = 0
  let cdir = dir.BOTTOM
  while (cx != N - 1 || cy != N - 1) {
    // console.log('cy : ' + cy + ' / cx : ' + cx + ' / cdir : ' + cdir)
    for (let d = 0; d < 4; d++) {
      let dd = (d + cdir) % 4
      let nx = cx + dx[dd]
      let ny = cy + dy[dd]
      if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue
      if (maze[ny][nx] == 1) continue

      cx = nx
      cy = ny
      cdir = (dd + 3) % 4
      count++
      break
    }
  }
  return count
}

let sol = solution([[0, 1, 0, 0, 0, 0], [0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 1, 0], [0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 0]])

console.log(sol)
