class PriorityQueue {
  constructor (dist) {
    this.queue = []
    this.dist = dist
  }

  enqueue = v => {
    this.queue.push(v)
  }

  dequeue = v => {
    let entry = 0
    let entryIndex = this.queue[entry]

    this.queue.forEach((node, i) => {
      if (this.dist[entryIndex] > this.dist[node]) {
        entryIndex = node
        entry = i
      }
    })

    return this.queue.splice(entry, 1)
  }
}

function solution (n, s, a, b, fares) {
  var answer = 0

  // 그래프 생성
  const graph = new Array(n).fill(null).map(() => new Array())
  for (let fare of fares) {
    const [n1, n2, w] = fare

    graph[n1 - 1].push([n2 - 1, w])
    graph[n2 - 1].push([n1 - 1, w])
  }

  // Priority Queue
  const dist = new Array(n).fill(Number.MAX_SAFE_INTEGER)
  const visited = new Array(n).fill(false)
  const pq = new PriorityQueue(dist)
  pq.enqueue(s-1)
  dist[s-1] = 0

  // 다익스트라
  while (pq.queue.length) {
    const [curr] = pq.dequeue()
    console.log(curr)

    if (visited[curr]) continue

    visited[curr] = true

    for (const [next, w] of graph[curr]) {
      if (dist[next] > dist[curr] + w) {
          dist[next] = dist[curr] + w;
          pq.enqueue(next);
      }
    }
  }

  console.log(dist)

  return answer
}

const findShorest = (start, end) => {
  const dis = {}
  const prev = {}
  const pq = new PriorityQueue()
  const visited = {}
}

findShorest(0, 0)

let sol = solution(6, 4, 6, 2, [
  [4, 1, 10],
  [3, 5, 24],
  [5, 6, 2],
  [3, 1, 41],
  [5, 1, 24],
  [4, 6, 50],
  [2, 4, 66],
  [2, 3, 22],
  [1, 6, 25]
])
