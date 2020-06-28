function generatePairs(num) {
  let result = [];
  for (let i = 0; i <= num; i++) {
    for (let j = i; j <= num; j++) {
      result.push([i, j]);
    }
  }
  return result;
}

generatePairs(1); // [ [0, 0], [0, 1], [1,1]]
