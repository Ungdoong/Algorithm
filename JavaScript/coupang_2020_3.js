function solution (k, score) {
  let diff_list = []

  let prev = -1
  for (let i = 0; i < score.length; i++) {
    if (prev == -1) {
      prev = score[i]
      continue
    }

    diff_list.push([prev - score[i], i - 1, i])
    prev = score[i]
  }
  diff_list.sort((a, b) => a[0] - b[0])

  let alive_list = Array.from({ length: score.length }, () => 1)
  let count = 1
  prev = 0
  for (let i = 0; i < diff_list.length; i++) {
    const diff = diff_list[i][0]
    if (prev == 0) {
      prev = diff
      continue
    }

    if (prev == diff) count++
    else {
      prev = diff
      count = 1
    }

    if (count == k) {
      let tmp_count = count - 1
      while (tmp_count >= 0) {
        const index = i - tmp_count
        alive_list[diff_list[index][1]] = -1
        alive_list[diff_list[index][2]] = -1
        tmp_count--
      }
    } else if (count > k) {
      alive_list[diff_list[i][1]] = -1
      alive_list[diff_list[i][2]] = -1
    }
  }

  return alive_list.reduce((acc, val) => (val == 1 ? acc + 1 : acc), 0)
}

console.log(
  solution(2, [
    1300000000,
    700000000,
    668239490,
    618239490,
    568239490,
    568239486,
    518239486,
    157658638,
    157658634,
    100000000,
    100
  ])
)
