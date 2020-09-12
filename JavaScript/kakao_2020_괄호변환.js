const inverse = str => {
  if(str.length <= 2) return '';

  let result = '';
  for(let c of str.slice(1, str.length-1)){
    result += (c == '(')? ')':'('
  }

  return result;
}

const change = arr => {
  if(arr.length == 0)  return ''
  let result = ''
  let count = 0
  let not = 0
  while (arr.length != 0) {
    let cur = arr.shift()
    count += cur == '(' ? 1 : -1
    result += cur;
    if(count < 0) not = 1
    else if(count == 0){
      if(not){
        return '(' + change(arr) + ')' + inverse(result)
      }else{
        return result + change(arr)
      }
    }
  }

  return result;
}

function solution (p) {
  if (p.length == 0) return p

  return change(p.split(''))
}

console.log(solution('()))((()'))
