let table = []
function solution (orders, course) {
  let answer = []

  // 코스 갯수 별로 탐색
  for (let n of course) {
    // 주문 마다 탐색
    for (let order of orders) {
      // 코스 갯수에 가능한 조합과 그 횟수를 table에 담음
      makeCourse(order, n, '', 0)
    }

    let tmp_array = []
    let max_order = 2
    // 테이블에서 가장 주문횟수 많은 것 꺼내서 답에 넣음
    while (table.length) {
      let cur = table.shift()
      if (cur[1] > max_order) {
        max_order = cur[1]
        tmp_array = []
        tmp_array.push(cur[0])
      } else if (cur[1] == max_order) {
        tmp_array.push(cur[0])
      }
    }
    answer.push(...tmp_array)
  }

  // 정렬
  answer.sort()

  return answer
}

const makeCourse = (order, n, cur, index) => {
  if (cur.length >= n) {
    let check = include(table, cur)
    cur = cur.split('').sort().join('')
    if (check == -1) {
      table.push([cur, 1])
    } else {
      table[check][1]++
    }
    return
  }

  for (let i = index; i < order.length; i++) {
    makeCourse(order, n, cur + order.charAt(i), i + 1)
  }
}

const include = (table, str) => {
  for (let i = 0; i < table.length; i++) {
    if (table[i][0] == str) return i
  }

  return -1
}

let sol = solution(["XYZ", "XWY", "WXA"], [2, 3, 4])

console.log(sol)
