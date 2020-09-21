function solution(record) {
  const ORDER = {
    Enter: 0,
    Leave: 1,
    Change: 2,
  };
  const ORDER_HG = ["들어왔습니다.", "나갔습니다."];
  let users = [];
  for (let i = 0; i < record.length; i++) {
    let arr = record[i].split(" ");
    if (users[arr[1]] == null) users[arr[1]] = new USER(arr[2]);
    if (arr[0] != "Leave") users[arr[1]].changeNickname(arr[2]);
  }

  let result = [];
  for (let i = 0; i < record.length; i++) {
    let arr = record[i].split(" ");
    if (ORDER[arr[0]] < 2) {
      result.push(users[arr[1]].nickname + "님이 " + ORDER_HG[ORDER[arr[0]]]);
    }
  }

  return result;
}

function USER(nickname) {
  this.nickname = nickname;
}

USER.prototype = {
  changeNickname: function (nickname) {
    this.nickname = nickname;
  },
};

console.log(
  solution([
    "Enter uid1234 Muzi",
    "Enter uid4567 Prodo",
    "Leave uid1234",
    "Enter uid1234 Prodo",
    "Change uid4567 Ryan",
  ])
);
