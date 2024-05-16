function solution(babbling) {
  var answer = 0;
  for (let i = 0; i < babbling.length; i++) {
    if (findSol(babbling[i])) answer++;
  }
  return answer;
}

function findSol(word) {
  let length = word.length;
  if (word.includes('aya')) length -= 3;
  if (word.includes('ye')) length -= 2;
  if (word.includes('woo')) length -= 3;
  if (word.includes('ma')) length -= 2;

  if (length == 0) return true;
}
