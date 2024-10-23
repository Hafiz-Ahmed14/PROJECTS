let gameseq = [];
let userseq = [];
let btns = ["yellow", "red", "purple", "green"];


let started = false;
let level = 0;

let h2 = document.querySelector("h2");

document.addEventListener("keypress", function() {
    if(started == false) {
        console.log("Game Started");
        started = true;
        levelUp();
    }
});

function GameFlash(btn) {
    btn.classList.add("flash");
    setTimeout(function() {
        btn.classList.remove("flash");
    }, 250);
}

function UserFlash(btn) {
    btn.classList.add("userflash");
    setTimeout(function() {
        btn.classList.remove("userflash");
    }, 250);
}

function levelUp() {
    userseq = [];
    level++;
    h2.innerText = `Level ${level}`;

    // create random number

    let randNum = Math.floor(Math.random() * 4);
    console.log(randNum);
    let randColor = btns[randNum];
    let randBtn = document.querySelector(`.${randColor}`);
    gameseq.push(randColor);
    console.log(gameseq);
    GameFlash(randBtn);
    
}

function checkAns(indx) {
    // let indx = level - 1;
    if(gameseq[indx] == userseq[indx]) {
        if(userseq.length == gameseq.length) {
            setTimeout(levelUp(), 1000);
        }
    }
    else {

        h2.innerHTML = `Game Over!! Your Score Was <b>${level} <b> <br> Press any key to start`;
        document.querySelector("body").style.backgroundColor = "red";
        setTimeout(function(){
            document.querySelector("body").style.backgroundColor = "white";
        },150);

        reset();
    }
}
function btnPress() {
    let btn = this;
    UserFlash(btn);

    userColor = btn.getAttribute("id");
    userseq.push(userColor);

    checkAns(userseq.length - 1);
}

let allBtns = document.querySelectorAll(".btn");

for(btn of allBtns) {
    btn.addEventListener("click", btnPress );
}

function reset() {
    started = false;
    level = 0;
    userseq = [];
    gameseq = [];
}
