function solution(str){
  let q = new MyQ()
  console.log(q)
  return q.sum()
}

function MyQ(){
  this.a = 1
  this.b = 1
}

MyQ.prototype.sum = function(){
  console.log(this.a)

  return 2
}

console.log(solution("aaabbbcccdd"))