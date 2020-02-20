const isPalindromeIterative = (string) => {

    const regex = /[a-zA-Z]/g;
    // I want to evaluate only letters, excluding spaces and other characters
    string = string
        .match(regex)
        .join('')
        .toLowerCase();

    const reversedString = [];

    for (let i = 0; i < string.length; i++) {

        reversedString.unshift(string[i]);

    }

    if (string === reversedString.join('')) return true;
    else return false;

}

console.log(isPalindromeIterative('Noel sees Leon'));
console.log(isPalindromeIterative('Euston saw I was not Sue'));
console.log(isPalindromeIterative('Eve damned Eden, mad Eve.'));