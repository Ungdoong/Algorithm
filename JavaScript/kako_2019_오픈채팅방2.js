function solution(record) {
  let users = [];
  let messages = [];
  const action = {
    Enter: "님이 들어왔습니다.",
    Leave: "님이 나갔습니다.",
  };

  for (const rec of record) {
    const [act, uid, nick] = rec.split(" ");

    if(act != 'Change') messages.push([act, uid]);

    if(nick)  users[uid] = nick;
  }

  return messages.map(([act, uid]) => `${users[uid]}${action[act]}`)
}

console.log(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))