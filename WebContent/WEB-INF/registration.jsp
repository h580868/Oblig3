<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <!-- Fra https://purecss.io/ -->
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
    <title>Påmelding</title>
</head>

<body>
    <h2>Påmelding</h2>
    <form method="post" class="pure-form pure-form-aligned" onsubmit='return formValidation()'>
        <fieldset>
            <div class="pure-control-group">
                <label for="fornavn">Fornavn:</label> <input type="text" maxlength="25" name="firstname" value="" />
                <font color="red" id="p1">Ugyldig fornavn</font>
            </div>
            <div class="pure-control-group">
                <label for="etternavn">Etternavn:</label> <input type="text" maxlength="25" name="lastname" value="" />
                <font color="red" id="p2">Ugyldig etternavn</font>
            </div>
            <div class="pure-control-group">
                <label for="mobil">Mobil (8 siffer):</label> <input type="text" maxlength="8" name="mobile" value="" />
                <font color="red" id="p3">Ugyldig mobil</font>
            </div>
            <div class="pure-control-group">
                <label for="password">Passord:</label> <input type="password" name="password" value="" />
                <font color="red" id="p4">Ugyldig passord</font>
            </div>
            <div class="pure-control-group">
                <label for="passordRepetert">Passord repetert:</label> <input type="passwordRep" name="passordRepetert" value="" />
                <font color="red" id="p5">Passordene må være like</font>
            </div>
            <div class="pure-control-group">
                <label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn" value="mann" />mann
                <input type="radio" name="kjonn" value="kvinne" />kvinne
                <font color="red" id="p6">Du må oppgi kjonn</font>
            </div>
            <div class="pure-controls">
                <button id="submitButton" type="submit" class="pure-button pure-button-primary">Meld
                    meg på</button>
            </div>
        </fieldset>
    </form>
    <script>
        document.getElementById.password.addEventListener("keyup", myScript);

        function formValidation() {
            // Make quick references to our fields.
            var firstname = document.getElementById('firstname');
            var lastname = document.getElementById('lastname');
            var mobile = document.getElementById('mobile');
            var password = document.getElementById('password');
            var passwordRep = document.getElementById('passwordRep');
            // To check empty form fields.
            if (firstname.value.length == 0) {
                document.getElementById('head').innerText = "* All fields are mandatory *"; // This segment displays the validation rule for all fields
                firstname.focus();
                return false;
            }
            // Check each input in the order that it appears in the form.
            if (inputAlphabet1(firstname, "Ugyldig fornavn")) {
                if (inputAlphabet2(lastname, , "Ugyldig etternavn")) {
                    if (textNumeric(mobile, "Ugyldig mobil")) {
                        if (passCheck(password, "Ugyldig passord")) {
                            if (passEqual(password, passwordRep, "Passordene må være like")) {
                                return true;
                            }
                        }
                    }

                }
            }
            return false;
        }
        // Function that checks password strength
        function passStr(inputtext) {
            var numericExpression1 = /^[0-9]+$/;
            var numericExpression2 = /^[a-z]+$/;
            var numericExpression3 = /^[A-Z]+$/;
            var numericExpression4 = /^[\[ \\ \^ \$ \. \| \? \* \+ \( \)]+$/;
            var strength = 0;
            if (inputtext.includes(numericExpression1)) {
                strength++;
            }
            if (inputtext.includes(numericExpression2)) {
                strength++;
            }
            if (inputtext.includes(numericExpression3)) {
                strength++;
            }
            if (inputtext.includes(numericExpression4)) {
                strength++;
            }
            if (inputtext.length > 6) {
                strength++;
            }
            var returnText = "";
            switch (strength) {
                case 0:
                    returnText = "Grusomt svak"
                    break;
                case 1:
                    returnText = "Veldig svak"
                    break;
                case 2:
                    returnText = "Svak"
                    break;
                case 3:
                    returnText = "Medium"
                    break;
                case 4:
                    returnText = "Sterk"
                    break;
                case 5:
                    returnText = "Veldig sterk"
                    break;
                default:
                    returnText = "???"
                    break;
            }
            document.getElementById('p4').innerText = returnText;
        }

        // Function that checks password length
        function passCheck(inputtext, alertMsg) {
            if (inputtext.length >= 3) {
                return true;
            } else {
                document.getElementById('p4').innerText = alertMsg;
                return false;
            }
        }
        // Function that checks password equal
        function passEqual(inputtext, inputtext2, alertMsg) {
            if (inputtext == inputtext2) {
                return true;
            } else {
                document.getElementById('p5').innerText = alertMsg;
                inputtext.focus();
                return false;
            }
        }

        // Function that checks whether input text is numeric or not.
        function textNumeric(inputtext, alertMsg) {
            var numericExpression = /^[0-9]+$/;
            if (inputtext.value.match(numericExpression)) {
                return true;
            } else {
                document.getElementById('p3').innerText = alertMsg; // This segment displays the validation rule for mobile.
                inputtext.focus();
                return false;
            }
        }
        // Function that checks whether input text is an alphabetic character or not.
        function inputAlphabet1(inputtext, alertMsg) {
            var alphaExp = /^[a-zA-Z]+$/;
            if (inputtext.value.match(alphaExp)) {
                return true;
            } else {
                document.getElementById('p1').innerText = alertMsg; // This segment displays the validation rule for name.
                //alert(alertMsg);
                inputtext.focus();
                return false;
            }
        }

        function inputAlphabet2(inputtext, alertMsg) {
            var alphaExp = /^[a-zA-Z]+$/;
            if (inputtext.value.match(alphaExp)) {
                return true;
            } else {
                document.getElementById('p2').innerText = alertMsg; // This segment displays the validation rule for name.
                //alert(alertMsg);
                inputtext.focus();
                return false;
            }
        }
        // Function that checks whether input text includes alphabetic and numeric characters.
        function textAlphanumeric(inputtext, alertMsg) {
            var alphaExp = /^[0-9a-zA-Z]+$/;
            if (inputtext.value.match(alphaExp)) {
                return true;
            } else {
                document.getElementById('p5').innerText = alertMsg; // This segment displays the validation rule for address.
                inputtext.focus();
                return false;
            }
        }
        // Function that checks whether a option is selected from the selector and if it's not it displays an alert message.
        function trueSelection(inputtext, alertMsg) {
            if (inputtext.value == "Du må oppgi kjønn") {
                document.getElementById('p6').innerText = alertMsg; //this segment displays the validation rule for selection.
                inputtext.focus();
                return false;
            } else {
                return true;
            }
        }

        }

    </script>
</body>

</html>
