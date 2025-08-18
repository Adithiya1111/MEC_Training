let random = Math.round(Math.random()*100);
console.log(random);
    
  let lives = 9;

    
function num() {
    let num = document.getElementById('number').value;
    // console.log(num);

    document.getElementById("live").textContent = `Lives: ${lives}`;
    

    if (num < 1 || num > 100) {
        document.getElementById('msg').innerText = "Enter the number between 1 to 100";
        return;
    }

    if(num == random) {
        location.href = "win.html";
        return
    }
    else if (lives == 0) {
        location.href = "lose.html";
    }
    else if (num > random) {
        document.getElementById('msg').innerText = "Try with lesser number";
    }
    else {
        document.getElementById('msg').innerText = "Try with greater number";
    }
    lives--;

}
