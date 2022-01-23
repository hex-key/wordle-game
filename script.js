const btn = document.querySelector('#start-button');
const textBox = document.querySelector('#text-box');

//if enter key pressed while in text box 
textBox.addEventListener("keyup", (event) => {
    if (event.keyCode === 13) {
        event.preventDefault();
        if (textBox.value.length === 5) {
            alert("congrat");
        } else {
            alert("enter 5 characters idiot");
        }
    }
});

function startGame() {
    
}