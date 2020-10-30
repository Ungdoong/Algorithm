function repeatedString(s, n) {
  const word_len = s.length
  const multiple = Math.floor(n / word_len)
  const last = n - word_len * multiple
  let result = 0

  // 단어에서 a가 나오는 수 체크
  let word_a_num = 0
  for(let i=0; i<word_len; i++){
    if(s[i] == 'a') word_a_num++
  }

  // 단어에서 a의 개수 X 단어 나오는 수 : result 에 합산
  result += word_a_num * multiple

  // 남은 개수에서 a가 몇개인지
  for(let i=0; i<last; i++){
    if(s[i] == 'a') result++
  }

  return result
}

console.log(repeatedString('aba', 10));
