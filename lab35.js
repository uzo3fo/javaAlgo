function totalCaps(arr) {
  let count = 0;
  let letters = arr.join("").split("");
  for (let i = 0; i < letters.length; i++) {
    if (letters[i] === letters[i].toUpperCase()) {
      count++;
    }
  }
  return count;
}

totalCaps(["AwesomE", "ThIngs", "hAppEning", "HerE"]); // 8
