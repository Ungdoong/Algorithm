function solution(s) {
  const N = s.length;
  const M = s[0].length;

  for (let third = 0; third < M; third++) {
    for (let first = 0; first < N - 1; first++) {
      for (let second = first + 1; second < N; second++) {
        if(s[first][third] == s[second][third]) return [first, second, third]
      }
    }
  }

  return []
}

console.log(solution(['gr', 'sd', 'rg']));
