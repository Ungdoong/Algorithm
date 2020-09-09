function solution(s) {
    var answer;
    answer = JSON.parse(s.replace(/{/g, '[').replace(/}/g, ']'))
    .sort((a, b) => a.length - b.length)
    .reduce((arr, v, n) => {
        if (n) {
            return arr.concat(v.filter(f => !arr.includes(f)));
        }
        return v;
    }, []);

    return answer;
}

solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");