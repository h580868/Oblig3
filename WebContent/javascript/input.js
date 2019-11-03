let inputMobile = document.getElementById("mobile");
let inputPassword = document.getElementById("password");

let buttonSubmit = document.getElementById("submitButton");

inputMobile.title = "Skriv inn mobilnummer";
inputPassword.title = "Passord minst 3 tegn."

let validMobile = false;
let validPassword = false;

buttonSubmit.disabled = true;
inputMobile.maxLength = 8;

inputMobile.addEventListener("input", checkMobile);
inputPassword.addEventListener("input", checkInputPassword);


// Function that checks password length
function checkMobile() {
    if (inputMobile.value.length === 8 && !isNaN(inputMobile.value)) {
        inputMobile.style.backgroundColor = "SpringGreen";
        validMobile = true;
        checkValid();
    } else {
        validMobile = false;
        inputMobile.style.backgroundColor = "Salmon";
    }

}

function checkInputPassword() {
    if (inputPassword.value.length > 3) {
        validPassword = true;
        inputPassword.style.backgroundColor = "SpringGreen";
    } else {
        validPassword = false;
        inputPassword.style.backgroundColor = "Salmon";
    }
    checkPasswords();
    checkValid();
}

function check() {
    if (inputMobile.value.length > 0) {
        checkMobile();
        if (inputPasswordRep.value.length > 0) {
            checkInputPassword();
        }
    }
}

}

function checkValid() {
    check
    if (validMobile && validPassword) {
        buttonSubmit.disabled = false;
    } else {
        buttonSubmit.disabled = true;
    }
}

document.addEventListener("DOMContentLoaded", check);
