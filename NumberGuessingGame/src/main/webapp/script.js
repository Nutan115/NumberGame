let randomNumber = Math.floor(Math.random() * 100) + 1;
let attemptsLeft = 10;
let score = 100;

function checkGuess() {
    let userGuess = parseInt(document.getElementById("userGuess").value);
    let message = document.getElementById("message");
    let attemptsText = document.getElementById("attempts");
    let scoreText = document.getElementById("score");

    if (isNaN(userGuess) || userGuess < 1 || userGuess > 100) {
        message.innerHTML = "⚠️ Please enter a number between 1 and 100!";
        return;
    }

    attemptsLeft--;
    attemptsText.innerText = attemptsLeft;
    score -= 10;

    if (userGuess === randomNumber) {
        message.innerHTML = `🎉 Correct! You guessed the number in ${10 - attemptsLeft} attempts!`;
        document.getElementById("restart").style.display = "block";
    } else if (userGuess < randomNumber) {
        message.innerHTML = "🔼 Too low! Try again.";
    } else {
        message.innerHTML = "🔽 Too high! Try again.";
    }

    scoreText.innerText = score;

    if (attemptsLeft === 0 && userGuess !== randomNumber) {
        message.innerHTML = `❌ Game Over! The number was ${randomNumber}.`;
        document.getElementById("restart").style.display = "block";
    }
}

function restartGame() {
    randomNumber = Math.floor(Math.random() * 100) + 1;
    attemptsLeft = 10;
    score = 100;
    
    document.getElementById("userGuess").value = "";
    document.getElementById("message").innerHTML = "";
    document.getElementById("attempts").innerText = attemptsLeft;
    document.getElementById("score").innerText = score;
    document.getElementById("restart").style.display = "none";
}
