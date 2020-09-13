function solution(n) {
    let N = n.toString()
    let count = 0;
    while(N.length > 1){
        count++;
        let min = Number.MAX_SAFE_INTEGER;
        for(let i=1; i< N.length; i++){
            let left = N.substring(0, i);
            let right = N.substring(i, N.length)

            if(right.charAt(0) == '0')  continue;
            left = parseInt(left)
            right = parseInt(right)

            min = Math.min(min, left + right)
        }

        n = min
        N = n.toString();
    }

    return [count, n];
}

let sol = solution(73425);

console.log(sol)