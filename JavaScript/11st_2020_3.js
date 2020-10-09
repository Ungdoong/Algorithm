function solution( A ){
   const N = A.length
   const MAX_N = 1000000000
   let numbers = Array.from({length:N+1}, () => 0);

   for(const num of A)  numbers[num]++

   let overs = []
   let zeros = []
   for(let i = 1; i<=N; i++){
     if(numbers[i] > 1){
       while(--numbers[i] > 0)  overs.push(i)
     }else if(numbers[i] == 0)  zeros.push(i)
   }

   overs.sort((a,b) => a-b)
   zeros.sort((a,b) => a-b)

   let result = 0
   while(overs.length > 0){
    const delta = Math.abs(overs.shift() - zeros.shift())
    if((result + delta) > MAX_N) return -1
    result += delta
   }

   return result
}

console.log(solution([6,2,3,5,6,3]))