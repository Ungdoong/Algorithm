function solution (play_time, adv_time, logs) {
  var answer = ''

  let time_table = []
  for (let log of logs) {
    let t = new Time()
    ;[t.start, t.end] = log.split('-').map(e => e.split(':'))
    time_table.push(t)
  }

  time_table.sort((a, b) => timeCompare(a.start, b.start))
  let adv_size = adv_time.split(':')
  let result_table = []
  for (let i = 0; i < time_table.length; i++) {
    let origin = time_table[i]
    let adv_end = timePlus(origin.start, adv_size)
    let seeing_time =
      timeCompare(adv_end, origin.end) > 0
        ? timeMinus(origin.start, origin.end)
        : timeMinus(origin.start, adv_end)
    for (let j = 0; j < time_table.length; j++) {
      if (i == j) continue
      if (timeCompare(adv_end, time_table[j].start) <= 0) break
      console.log(i + '/' + j)
      let compare = time_table[j]
      if (timeCompare(compare.start, origin.start) < 0) {
        seeing_time = timePlus(
          seeing_time,
          timeCompare(adv_end, compare.end) > 0
            ? timeMinus(origin.start, compare.end)
            : timeMinus(origin.start, adv_end)
        )
      } else {
        seeing_time = timePlus(
          seeing_time,
          timeCompare(adv_end, compare.end) > 0
            ? timeMinus(compare.start, compare.end)
            : timeMinus(compare.start, adv_end)
        )
        console.log(timeCompare(adv_end, compare.end))
        console.log('dddd'+seeing_time)
        console.log(adv_end, compare.start)
      }
    }
    console.log(seeing_time)

    result_table.push([time_table[i].start, seeing_time])
  }
  console.log(result_table)
  return answer
}

function Time () {
  let start
  let end
}

const timeCompare = (a, b) => parseInt(a.join('')) - parseInt(b.join(''))
const timePlus = (a, b) => {
  const [h1, m1, s1] = a.map(e => parseInt(e))
  const [h2, m2, s2] = b.map(e => parseInt(e))

  let [nh, nm, ns] = [h1 + h2, m1 + m2, s1 + s2]
  nh += Math.floor(nm / 60)
  nm = (nm % 60) + Math.floor(ns / 60)
  ns = ns % 60

  let result = ['' + nh, '' + nm, '' + ns]

  for (let i = 0; i < 3; i++) {
    if (result[i].length < 2) {
      while (result[i].length < 2) {
        result[i] = '0' + result[i]
      }
    }
  }
  return result
}

const timeMinus = (a, b) => {
  const [h1, m1, s1] = b.map(e => parseInt(e))
  const [h2, m2, s2] = a.map(e => parseInt(e))

  let [nh, nm, ns] = [h1 - h2, m1 - m2, s1 - s2]
  nh = nm < 0 ? nh - 1 : nh
  nm = nm < 0 ? 60 + nm : nm
  nm = ns < 0 ? nm - 1 : nm
  ns = ns < 0 ? 60 + ns : ns

  let result = ['' + nh, '' + nm, '' + ns]
  for (let i = 0; i < 3; i++) {
    if (result[i].length < 2) {
      while (result[i].length < 2) {
        result[i] = '0' + result[i]
      }
    }
  }
  console.log('result : '+result)
  return result
}

let sol = solution('02:03:55', '00:14:15', [
  '01:20:15-01:45:14',
  '00:40:31-01:00:00',
  '00:25:50-00:48:29',
  '01:30:59-01:53:29',
  '01:37:44-02:02:30'
])
