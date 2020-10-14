function solution (N) {
  let answer = [10, 0]
  for (let i = 2; i < 10; i++) {
    const multiple = conversion(N, i)

    if(answer[1] <= multiple){
      answer[1] = multiple
      answer[0] = i;
    }
  }

  return answer
}

function conversion (N, to) {
  let cur = N
  let result = 1;

  while (cur >= to) {
    const last = cur % to
    cur = Math.floor(cur / to)

    if (last != 0) result *= last;
  }

  if (cur != 0) result *= cur;

  return result;
}

console.log(solution(10000000))