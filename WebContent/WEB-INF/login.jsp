<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <!-- Fra https://purecss.io/ -->
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
        <title>Logg inn</title>
    </head>

    <body>
        <h2>Logg inn</h2>
        <p>Det er kun registrerte deltagere som får se deltagerlisten.</p>
        <p>
            <font color="red">Ugyldig brukernavn og/eller passord</font>
        </p>
        <form method="post" class="pure-form pure-form-aligned">
            <fieldset>
                <div class="pure-control-group">
                    <label id="mobile" for="mobil">Mobil:</label> <input type="text" name="mobil" />
                </div>
                <div class="pure-control-group">
                    <label id="password" for="password">Password:</label> <input type="password" name="passord" />
                </div>
                <div class="pure-controls">
                    <button id="submitButton" type="submit" class="pure-button pure-button-primary">Logg
					inn</button>
                </div>
            </fieldset>
        </form>
        <script src="javascript/login.js" charset="utf-8"></script>
    </body>

    </html>
