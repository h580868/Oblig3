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
                    <label for="fornavn">Fornavn:</label>
                    <input id="firstname" type="text" maxlength="25" name="firstname" value="" />
                    <font color="red" id="p1">Ugyldig fornavn</font>
                </div>
                <div class="pure-control-group">
                    <label for="etternavn">Etternavn:</label>
                    <input id="lastname" type="text" maxlength="25" name="lastname" value="" />
                    <font color="red" id="p2">Ugyldig etternavn</font>
                </div>
                <div class="pure-control-group">
                    <label for="mobil">Mobil (8 siffer):</label>
                    <input id="mobile" type="text" maxlength="8" name="mobile" value="" />
                    <font color="red" id="p3">Ugyldig mobil</font>
                </div>
                <div class="pure-control-group">
                    <label for="password">Passord:</label>
                    <input id="password" type="password" name="password" value="" />
                    <font color="red" id="p4">Ugyldig passord</font>
                </div>
                <div class="pure-control-group">
                    <label for="passord">Passord repetert:</label>
                    <input id="passwordRep" type="password" name="passwordRepetert" value="" />
                    <font color="red" id="p5">Passordene må være like</font>
                </div>
                <div class="pure-control-group">
                    <label for="kjonn">Kjønn:</label>
                    <input id="gender" type="radio" name="gender" value="mann" />Mann
                    <input id="gender" type="radio" name="gender" value="kvinne" />Kvinne
                    <font color="red" id="p6">Du må oppgi kjonn</font>
                </div>
                <div class="pure-controls">
                    <button id="submitButton" type="submit" class="pure-button pure-button-primary">Meld
                    meg på</button>
                </div>
            </fieldset>
        </form>
        <script src="javascript/ValidatingInput.js" charset="utf-8"></script>
    </body>

    </html>
