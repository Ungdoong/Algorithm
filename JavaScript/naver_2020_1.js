function solution (sentence, key) {
  let answer = sentence
  let N = answer.length
  let index = 0

  for (let k of key) {
    if(!sentence.includes(k))  continue;
    for (let i = index; i < N; i++) {
      if (answer[i] == k) {
        let tmp = answer.substring(0, i) + answer.substring(i + 1, N)
        answer = tmp
        N = answer.length
        index = i
        break;
      }
    }
  }
  return answer
}

console.log(solution("acbbcsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadc", 'abc'))
