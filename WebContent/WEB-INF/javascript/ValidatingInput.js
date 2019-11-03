'use strict';

let inputFirstname = document.getElementById("firstname");
let inputLastname = document.getElementById("lastname");
let inputMobile = document.getElementById("mobile");
let inputPassword = document.getElementById("password");
let inputPasswordRep = document.getElementById("passwordRep");
let inputGender = document.getElementsByName("gender");

let buttonSubmit = document.getElementById("submitButton");

let p1 = document.getElementById('p1');
let p2 = document.getElementById('p2');
let p3 = document.getElementById('p3');
let p4 = document.getElementById('p4');
let p5 = document.getElementById('p5');
let p6 = document.getElementById('p6');

inputFirstname.title = "Skriv inn fornavn";
inputLastname.title = "Skriv inn etternavn";
inputMobile.title = "Skriv inn mobilnummer";
inputPassword.title = "Passord minst 3 tegn."
inputPasswordRep.title = "Passordene må være like.";

let validFirstname = false;
let validLastname = false;
let validMobile = false;
let validPassword = false;
let validPasswordRep = false;
let validGender = false;


buttonSubmit.disabled = true;
inputMobile.maxLength = 8;

inputFirstname.addEventListener("input", checkInputFirstname);
inputLastname.addEventListener("input", checkInputLastname);
inputMobile.addEventListener("input", checkMobile);
inputPasswordRep.addEventListener("input", checkPasswords);
inputPassword.addEventListener("input", checkInputPassword);

for (var i = 0, length = inputGender.length; i < length; i++) {
    inputGender[i].addEventListener("change", event => {
        validGender = true;
        checkValid();
    });
}

// Function that checks password length
function checkInputFirstname() {
    if (inputFirstname.value.length > 2) {
        inputFirstname.style.backgroundColor = "SpringGreen";
        validFirstname = true;
    } else {
        validFirstname = false;
        inputFirstname.style.backgroundColor = "Salmon";
        buttonSubmit.disabled = true
    }
    checkValid();
}

function checkInputLastname() {
    if (inputLastname.value.length > 2) {
        inputLastname.style.backgroundColor = "SpringGreen";
        validLastname = true;
        checkValid();
    } else {
        validLastname = false;
        inputLastname.style.backgroundColor = "Salmon";
        buttonSubmit.disabled = true
    }

}

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

function checkPasswords() {
    if (inputPasswordRep.value === inputPassword.value) {
        validPasswordRep = true;
        inputPasswordRep.style.backgroundColor = "SpringGreen";
        checkValid();
    } else {
        validPasswordRep = false;
        inputPasswordRep.style.backgroundColor = "Salmon";
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
    if (inputFirstname.value.length > 0) {
        checkInputFirstname();
        if (inputLastname.value.length > 0) {
            checkInputLastname();
            if (inputMobile.value.length > 0) {
                checkMobile();
                if (inputPassword.value.length > 0) {
                    checkPasswords();
                    if (inputPasswordRep.value.length > 0) {
                        checkInputPassword();
                        for (var i = 0, length = inputGender.length; i < length; i++) {
                            console.log(inputGender[i].checked);
                            if (inputGender[i].checked) {
                                validGender = true;
                            }
                        }
                    }
                }
            }
        }
    }
}

function checkValid() {
    check
    if (validGender && validFirstname && validLastname && validMobile && validPassword && validPasswordRep) {
        buttonSubmit.disabled = false;
    } else {
        buttonSubmit.disabled = true;
    }
}

document.addEventListener("DOMContentLoaded", check);
