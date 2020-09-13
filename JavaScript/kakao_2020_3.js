const condition = [
  ['cpp', 'java', 'python'],
  ['backend', 'frontend'],
  ['junior', 'senior'],
  ['chicken', 'pizza']
]

function solution (info, query) {
  var answer = []
  let info_table = []

  for (let e of info) {
    let keys = e.split(' ')
    let key = getKey(keys)
    if (info_table[key] == null) {
      info_table[key] = []
      info_table[key].push(keys[4])
    } else {
      info_table[key].push(keys[4])
    }
  }

  for (let e of query) {
    let keys = e.split(' and ')
    keys.splice(3, 2, ...keys[3].split(' '))
    let find_keys = []
    makeKey(getKeys(keys), find_keys, 0, 0)

    let count = 0
    while (find_keys.length) {
      let cur = find_keys.shift()
      let score_list = info_table[cur] == null ? [] : info_table[cur]
      for (let score of score_list) {
        if (parseInt(score) >= keys[4]) {
          count++
        }
      }
    }
    answer.push(count)
  }

  return answer
}

const getKey = strs => {
  let key = 0
  for (let con = 0; con < 4; con++) {
    for (let i = 0; i < condition[con].length; i++) {
      if (strs[con] == condition[con][i]) {
        key += i * Math.pow(10, 3 - con)
        break
      }
    }
  }
  return key
}

const getKeys = arr => {
  let keys = []
  for (let con = 0; con < 4; con++) {
    if (arr[con] == '-') {
      keys.push([...Array(condition[con].length)].map((_, i) => i))
      continue
    }
    for (let i = 0; i < condition[con].length; i++) {
      if (arr[con] == condition[con][i]) {
        keys.push([i])
        break
      }
    }
  }
  return keys
}

const makeKey = (arr, target, cur, index) => {
  if (index >= 4) {
    target.push(cur)
    return
  }
  for (let i = 0; i < arr[index].length; i++) {
    makeKey(
      arr,
      target,
      cur + arr[index][i] * Math.pow(10, 3 - index),
      index + 1
    )
  }
}

let sol = solution(
  [
    'java backend junior pizza 150',
    'python frontend senior chicken 210',
    'python frontend senior chicken 150',
    'cpp backend senior pizza 260',
    'java backend junior chicken 80',
    'python backend senior chicken 50'
  ],
  [
    'java and backend and junior and pizza 100',
    'python and frontend and senior and chicken 200',
    'cpp and - and senior and pizza 250',
    '- and backend and senior and - 150',
    '- and - and - and chicken 100',
    '- and - and - and - 150'
  ]
)

console.log(sol)
