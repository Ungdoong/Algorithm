let count = 0
function solution (depar, hub, dest, roads) {
  let adj = [];

  for(const road of roads){
    const src = road[0]
    const dst = road[1]

    if(adj[src] == null)  adj[src] = []

    adj[src].push(dst)
  }

  let result = 0
  findRoot(adj, depar, hub, depar)
  result = count
  count = 0
  findRoot(adj, hub, dest, hub)
  result *= count

  return result
}

function findRoot(adj, src, dest, cur){
  if(cur == dest){
    count = (count + 1) % 10007
    return;
  }

  if(adj[cur] == null)  return;

  for(const next of adj[cur]){
    findRoot(adj, src, dest, next);
  }
}

console.log(
  solution('SEOUL', 'DAEGU', 'YEOSU', [
    ['ULSAN', 'BUSAN'],
    ['DAEJEON', 'ULSAN'],
    ['DAEJEON', 'GWANGJU'],
    ['SEOUL', 'DAEJEON'],
    ['SEOUL', 'ULSAN'],
    ['DAEJEON', 'DAEGU'],
    ['GWANGJU', 'BUSAN'],
    ['DAEGU', 'GWANGJU'],
    ['DAEGU', 'BUSAN'],
    ['ULSAN', 'DAEGU'],
    ['GWANGJU', 'YEOSU'],
    ['BUSAN', 'YEOSU']
  ])
)
