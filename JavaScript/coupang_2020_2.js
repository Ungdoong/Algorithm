function solution (n, customers) {
  let kiosks = Array.from({ length: n }, () => [0, false, 0])

  for (const customer of customers) {
    const time = customer.split(' ')
    const month = time[0].split('/')[0]
    const day = time[0].split('/')[1]

    let arrive_date = new Date('2020-' + month + '-' + day + ' ' + time[1])

    // 도착시간보다 종료시간이 더 빠른 것들 업데이트
    const arrive_time = arrive_date.getTime()
    for(let i=0; i<kiosks.length; i++){
      if(kiosks[i][0] != 0 && kiosks[i][0] < arrive_time){
        kiosks[i][1] = false
      }
    }

    const index = findKiosk(kiosks)

    // 키오스크에 할당
    // 현재 비어있는 키오스크일 경우
    if (!kiosks[index][1]) {
      arrive_date.setMinutes(arrive_date.getMinutes() + parseInt(time[2]))
      kiosks[index][0] = arrive_date.getTime()
      kiosks[index][1] = true
      kiosks[index][2]++
    } else {
      let finish_time = new Date(kiosks[index][0])
      finish_time.setMinutes(finish_time.getMinutes() + parseInt(time[2]))
      kiosks[index][0] = finish_time.getTime()
      kiosks[index][2]++
    }
  }

  return kiosks.reduce((max, val) => Math.max(max, val[2]), 0)
}

function findKiosk (kiosks) {
  // 남는 키오스크가 있는지 검사하고 작업 종료시간 체크
  let result = [0, -1]
  for (let i = 0; i < kiosks.length; i++) {
    if (kiosks[i][1]) continue

    if (kiosks[i][2] == 0) {
      return i
    }

    if (result[0] > kiosks[i][0] || result[0] == 0) {
      result[0] = kiosks[i][0]
      result[1] = i
    }
  }

  // 남는 키오스크 인덱스 반환
  if (result[0] != 0) return result[1]

  // 남는 키오스크가 없으면 종료시간이 가장 빠른 것 반환
  for (let i = 0; i < kiosks.length; i++) {
    if (result[0] > kiosks[i][0] || result[0] == 0) {
      result[0] = kiosks[i][0]
      result[1] = i
    }
  }

  return result[1] % 10007
}

console.log(
  solution(2, ['02/28 23:59:00 03', '03/01 00:00:00 02', '03/01 00:05:00 01'])
)
