function solution (N, stages) {
  var answer = []
  let users = stages.length
  stages.sort((a, b) => a - b)
  for (const stage of stages) {
    if (answer[stage] == null) answer[stage] = [0, 0]

    answer[stage][0]++
    users--
    answer[stage][1] = answer[stage][0] / (answer[stage][0] + users)
  }

  let result = []
  for (let i = 1; i <= N; i++) {
    if (answer[i] == null) answer[i] = [i, 0]
    result[i] = [i, answer[i][1]]
  }
  return result.sort((a, b) => (b[1] != a[1] ? b[1] - a[1] : a[0] - b[0])).map(e => e[0]).splice(0, result.length-1)
}

console.log(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
