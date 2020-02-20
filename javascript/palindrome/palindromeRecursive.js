const isPalindromeRecursive = (string, firstCall = false) => {

    // Only want this condition to be met the first time it is called
    if (firstCall) {

        const regex = /[a-zA-Z]/g;
        // I want to evaluate only letters, excluding spaces and other characters
        string = string
            .match(regex)
            .join('')
            .toLowerCase();

    }

    // Exiting condition
    if (string.length < 2) return true;

    // Keep track of removed characters
    let firstChar, lastChar;

    const removeChar = (index, text) => {

        switch (index) {

            case 'first':
                firstChar = text.slice(0, 1);
                return text.slice(1); // anything but the first

            case 'last':
                lastChar = text.slice(-1);
                return text.slice(0, -1); // anything but the last

        }

    }

    string = removeChar('first', string); // Update string without first char
    string = removeChar('last', string); // Update string without last char

    if (firstChar === lastChar) {

        return isPalindromeRecursive(string);

    } else {

        return false;

    }

}

console.log(isPalindromeRecursive('1Noel sees Leon', true));
console.log(isPalindromeRecursive('Euston saw I was not Sue', true));
console.log(isPalindromeRecursive('Eve damned Eden, mad Eve.', true));