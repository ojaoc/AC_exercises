const factorialIterative = (value) => {
    sampleArray = [];
    for (let i = 0; i < value; i++) {
        sampleArray.push(value - i);
    }
    const RESULT = sampleArray.reduce((accumulator, currentValue) => accumulator * currentValue);
    return RESULT;
}

console.log(factorialIterative(10));