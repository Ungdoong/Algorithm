function solution (ball, order) {
  var answer = []

  let ball_N = ball.length
  let order_N = order.length
  let possible = 1
  while (order_N && ball_N && possible) {
    ball_N = ball.length
    order_N = ball.length
    for (let i = 0; i < order_N; i++) {
      if (order[i] == ball[0]) {
        answer.push(ball.shift())
        order.splice(i, 1)
        break
      }
      if (order[i] == ball[ball_N - 1]) {
        answer.push(ball.pop())
        order.splice(i, 1)
        break
      }

      if (i == order_N - 1) {
        possible = 0
      }
    }
  }

  return answer
}

let sol = solution([1, 2, 3, 4, 5, 6], [6, 2, 5, 1, 4, 3])

console.log(sol)
