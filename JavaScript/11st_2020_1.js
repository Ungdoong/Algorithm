function solution(s) {
  let check = false;
  let result = s.split("").reduce(
    ([acc, _, count, sum], cur_v) => {
      let str = "";
      let plus = 0;
      if (cur_v != "a") {
        while (++count < 3) {
          str += "a";
          plus++;
        }
      } else {
        if (count + 1 == 3) check = true;
      }
      return [acc + str + cur_v, cur_v, cur_v == "a" ? count + 1 : 0, sum + plus];
    },
    ["", "", 0, 0]
  );

  while(++result[2] < 3){
    result[0] += 'a'
    result[3]++
  }

  return (check)? -1 : result[3];
}

console.log(solution("a"));
