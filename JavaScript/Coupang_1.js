function solution(str){
  let prev = str[0]
  let cnt = 1
  let result = str[0]
  
  for(let i=1; i<str.length; i++){
    if(prev == str[i])  cnt++
    else{
      if(cnt == 1){
        result += str[i]
      }else{
        result += (cnt + str[i])
      }
      prev = str[i]
      cnt = 1
    }

    if(i == str.length-1 && cnt != 1){
      result += cnt
    }
  }

  return result
}

console.log(solution("aaabbbcccdd"))