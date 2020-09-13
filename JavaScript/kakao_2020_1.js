function solution (new_id) {
  //[출처] [펌] javascript 특수문자 제거 정규식|작성자 하하하
  let reg = /[\{\}\[\]\/?,;:|\)*~`!^+<>@\#$%&\\\=\(\'\"]/gi
  // 소문자 변환 및 특수문자 제거
  let answer = new_id.toLowerCase().replace(reg, '')

  // 중복된 점 하나로
  answer = compress(answer)

  // 앞뒤 점 제거
  if (answer.length && answer.charAt(0) == '.') {
    answer = answer.slice(1, answer.length)
  }
  if (answer.length && answer.charAt(answer.length - 1) == '.') {
    answer = answer.slice(0, answer.length - 1)
  }

  // 빈 문자열이면 a 대입
  if (answer.length == 0) answer = 'a'

  // 16자 이상이면 15개의 문자를 제외하고 지운 후 마지막 문자 확인
  if (answer.length > 15) {
    answer = answer.slice(0, 15)
    if (answer.charAt(14) == '.') answer = answer.slice(0, 14)
  }

  // 2자 이하이면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
  if (answer.length <= 2) {
    let c = answer.charAt(answer.length - 1)
    while (answer.length < 3) {
      answer += c
    }
  }

  return answer
}

const compress = str => {
  let result = str.split('')
  return result.reduce(
    ([result, prev], current) => {
      if (current == '.' && current == prev) {
        return [result, current]
      } else if (current == '.' && prev != current) {
        return [result + current, current]
      } else {
        return [result + current, current]
      }
    },
    ['', '']
  )[0]
}

let sol = solution("=.=")
console.log(sol)
