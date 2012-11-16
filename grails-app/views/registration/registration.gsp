<r:require module="registrationResources" />

<html>
<head>
    <meta name='layout' content='main'/>
    <title><g:message code="registration.title"/></title>
    <script>
        window['pageConfig'] = {
            registerUrl: "${g.createLink(controller: 'registration', action: 'registerNewUser')}"
        };
    </script>
</head>

<body>
<div id='login'>
    <div class='inner'>
        <div class='fheader'><g:message code="registration.form.title"/></div>

        %{--<g:if test='${flash.message}'>--}%
            <div class='login_message'>${flash.message}</div>
        %{--</g:if>--}%

        <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
            <p>
                <label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
                <input type='email' class='text_' name='email' id='username'/>
            </p>

            <p>
                <label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
                <input type='text' readonly="true" class='text_' name='j_password' id="passwordOutput" />
                %{--<label id="passwordOutput" style="padding-top: 4px;"></label>--}%
            </p>

            <p style="padding: 0 0 0 109px;">
                <input type='submit' id="submit" value='${message(code: 'registration.registerButton.label')}'/>
            </p>
        </form>
    </div>
</div>
</body>
</html>
