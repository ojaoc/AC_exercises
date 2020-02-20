const factorialRecursive = (value) => {
    if (value < 0) return;
    if (value === 0) return 1;
    return value * factorialRecursive(value - 1);
}

console.log(factorialRecursive(10));