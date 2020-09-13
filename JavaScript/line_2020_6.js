function solution (companies, applicants) {
  const com_info = companies.map(e => {
    let info = e.split(' ')
    return new Company(info[0], info[1].split(''), info[2])
  })
  console.log(com_info)
  const app_info = applicants.map(e => {
    let info = e.split(' ')
    return new Appli(info[0], info[1].split(''), info[2])
  })
  console.log(app_info)
  let apply = []
  for(let com of com_info){
    apply[com.name] = []
  }


  // 지원자 넣기
  for (let app of app_info) {
    if (app.count == 0 || app.want.length == 0) continue
    let want = app.want.shift()

    apply[want].push(app.name)
  }

  // 선택
  for(let com of com_info){
    for(let app of apply[com.name]){
      
    }
  }

  return []
}

function Company (name, want, num) {
  this.name = name
  this.want = want
  this.num = num
}

function Appli (name, want, count) {
  this.name = name
  this.want = want
  this.count = count
}

let sol = solution(
  ['A fabdec 2', 'B cebdfa 2', 'C ecfadb 2'],
  ['a BAC 1', 'b BAC 3', 'c BCA 2', 'd ABC 3', 'e BCA 3', 'f ABC 2']
)

console.log(sol)
