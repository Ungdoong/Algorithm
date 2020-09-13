function solution (cards) {
  cards = cards.map(e => (e > 10 ? 10 : e))

  let player = []
  let dealer = []
  let cash = 0
  while (cards.length) {
    player.push(cards.shift())
    dealer.push(cards.shift())
    player.push(cards.shift())
    dealer.push(cards.shift())

    // 블랙잭
    let p_scores = makeScores(player)
    let d_scores = makeScores(dealer)
    let p_check = scoreCheck(p_scores, 21)
    let d_check = scoreCheck(d_scores, 21)
    if (p_check == 0 || d_check == 0) {
      if (p_check == 0 && d_check == 0) cash = cash
      else if (p_check == 0) cash += 3
      else if (d_check == 0) cash -= 2
      player = []
      dealer = []
      continue
    }

    // 21이상
    if (p_check == 1 || d_check == 1) {
      if (p_check == 1 && d_check == 1) cash = cash
      else if (p_check == 1) cash -= 2
      else if (d_check == 1) cash += 2
      player = []
      dealer = []
      continue
    }

    // 플레이어
    let game_end = 0;
    if (dealer[1] == 1 || dealer[1] >= 7) {
      p_check = scoreCheck(p_scores, 17)
      while (p_check < 0 && cards.length) {
        player.push(cards.shift())
        p_scores = makeScores(player)
        p_check = scoreCheck(p_scores, 17)
        if (scoreCheck(p_scores, 21) > 0) {
          cash -= 2
          player = []
          dealer = []
          game_end = 1
          break
        }

        if(p_check < 0 &&cards.length == 0) game_end = 1;
      }
    } else if (dealer[1] == 2 || dealer[1] == 3) {
      p_check = scoreCheck(p_scores, 12)
      while (p_check < 0 && cards.length) {
        player.push(cards.shift())
        p_scores = makeScores(player)
        p_check = scoreCheck(p_scores, 12)
        if (scoreCheck(p_scores, 21) > 0) {
          cash -= 2
          player = []
          dealer = []
          game_end = 1
          break
        }

        if(p_check < 0 && cards.length == 0) game_end = 1;
      }
    }
    
    if (game_end) continue

    // 딜러
    d_check = scoreCheck(d_scores, 17)
    while (d_check < 0 && cards.length) {
      dealer.push(cards.shift())
      d_scores = makeScores(dealer)
      d_check = scoreCheck(d_scores, 17)
      if (scoreCheck(d_scores, 21) > 0) {
        cash += 2
        player = []
        dealer = []
        game_end = 1
        break
      }

      if(d_check < 0 && cards.length == 0) game_end = 1;
    }

    if (game_end) continue

    // 점수 체크
    p_check = scoreCheck(p_scores, 21)
    d_check = scoreCheck(d_scores, 21)
    // 블랙잭
    if (p_check == 0 || d_check == 0) {
      if (p_check == 0 && d_check == 0) cash = cash
      else if (p_check == 0) cash += 3
      else if (d_check == 0) cash -= 2
      player = []
      dealer = []
      continue
    } 
    // 점수 비교
    else {
      let compare = compareScore(p_scores, d_scores)
      if(compare < 0){
        cash += 2
      }else if(compare > 0){
        cash -= 2
      }
    }
  }

  return cash
}

const compareScore = (p_scores, d_scores) => {
  let p_min = Number.MAX_SAFE_INTEGER
  let d_min = Number.MAX_SAFE_INTEGER
  for (let score of p_scores) {
    if (score > 21) break
    p_min = Math.min(p_min, 21 - score)
  }

  for (let score of d_scores) {
    if (score > 21) break
    d_min = Math.min(d_min, 21 - score)
  }

  return p_min - d_min;
}

const makeScores = cards => {
  let possibleScore = []
  let num_one = 0
  let score = 0
  for (let card of cards) {
    if (card != 1) {
      score += card
    } else {
      num_one++
    }
  }

  possibleScore.push(score)
  while (num_one-- > 0) {
    let tmp_list = []
    while (possibleScore.length) {
      let originScore = possibleScore.shift()
      tmp_list.push(originScore + 1)
      tmp_list.push(originScore + 11)
    }
    possibleScore = tmp_list
  }
  return possibleScore
}

const scoreCheck = (scores, target_score) => {
  let over = -1
  for (let score of scores) {
    if (score == target_score) return 0
    else if (score > target_score) over = 1
  }

  return over
}

let sol = solution([3, 3, 3, 3, 3, 3, 3, 3, 3, 3])

console.log(sol)
