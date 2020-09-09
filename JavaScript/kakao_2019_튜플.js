function solution(s) {
    var answer = [];
    var map = new Map();
    var array_str = s.split('},{').map((v) => v.replace(/{/g, '').replace(/}/g, ''));
    var L = array_str.length;
    for(var i=0; i<L; i++){
        var strs = array_str[i].split(',');
        var len = strs.length;
        map.set(len, strs);
    }

    var i = 0;
    var flag = new Map();
    while(i++ < L){
        var cur_list = map.get(i);
        for(var num of cur_list){
            if(!flag.has(num)){
                answer.push(parseInt(num));
                flag.set(num, true);
            }
        }
    }

    return answer;
}

solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");