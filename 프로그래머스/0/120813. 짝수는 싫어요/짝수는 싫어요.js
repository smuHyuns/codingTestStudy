function solution(n) {
    let answer = [];
    let index = 0;
    for(let i=1; i<=n; i++){
        if(i%2 === 1){
            answer[index] = i;
            index++;
        }
    }
    return answer;
}