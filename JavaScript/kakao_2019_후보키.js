let result = []
let rel = []
function solution (relation) {
  rel = JSON.parse(JSON.stringify(relation))
  comb(0, 0)
  result.sort((a,b) => a.length-b.length)
  console.log(result)
  console.log([1,2,3].includes(1))
}

function comb (flag, cur) {
  if (cur >= 4) {
    check(flag)
    return
  }

  for (let i = 0; i < 2; i++) {
    comb(flag | (i << cur), cur + 1)
  }
}

function check (flag) {
  let tmp = []
  for (let i = 0; i < 4; i++) {
    if (((flag >> i) & 1) == 0) tmp.push(i)
  }

  for(let columns of result){
    let not_contain = false;
    for(let col of columns){
      for(let i=0; i<4; i++){
        
      }
    }
  }

  let arr = []
  for (let record of rel) {
    let str = ''
    for (let i = 0; i < 4; i++) {
      if ((flag >> i) & (1 == 1)) continue
      str += record[i]
    }
    if (arr[str] == null) arr[str] = 0
    arr[str]++

    if (arr[str] >= 2) return
  }

  result.push(tmp)
}

console.log(
  solution([
    ['100', 'ryan', 'music', '2'],
    ['200', 'apeach', 'math', '2'],
    ['300', 'tube', 'computer', '3'],
    ['400', 'con', 'computer', '4'],
    ['500', 'muzi', 'music', '3'],
    ['600', 'apeach', 'music', '2']
  ])
)
