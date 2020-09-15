function solution(s) {
  let answer = 1001;
  let len = s.length;

  if(len == 1)  return 1;

  // 1개 단위부터 탐색
  for (let size = 1; size <= len / 2; size++) {
    let entry = []; // 자른 단어들을 담아둘 배열
    let start = 0; // 잘라낼 위치를 가리키는 인덱스
    let str_len = 0; // 압축 후 문자 길이

    // 사이즈 크기로 잘라냄
    while (start + size <= len) {
      entry.push(s.substring(start, start + size));
      start += size;
    }
    // 남은 조각이 있으면 마저 입력
    if (len - start > 0) entry.push(s.substring(start, len));
    // 종료값 삽입
    entry.push("\0");

    let word = entry.shift(); // 비교할 맨 처음 단어
    let count = 1; // 동일한 단어가 나온 횟수
    let cur;
    while (word != "\0") {
      cur = entry.shift();
      if (word == cur) {
        count++;
      } else {
        str_len += (count == 1)? word.length:word.length + (''+count).length;

        word = cur;
        count = 1;
      }
    }

    answer = Math.min(answer, str_len);
  }
  return answer;
}

solution("a");
