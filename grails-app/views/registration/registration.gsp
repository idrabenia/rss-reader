<r:require module="registrationResources" />

<html>
<head>
    <meta name='layout' content='main' />
    <title><g:message code="registration.title" /></title>

    <script type="text/javascript">
        window['pageConfig'] = {
            registerUrl: "${g.createLink(controller: 'registration', action: 'registerNewUser')}"
        };
    </script>
</head>

<body>
<div id='login'>
    <div class='inner'>
        <div class='fheader'><g:message code="registration.form.title"/></div>

        <div class='login_message'>${flash.message}</div>


        <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
            <p>
                <label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
                <input type='email' class='text_' name='email' id='username' />
            </p>

            <p>
                <label for='passwordOutput'><g:message code="springSecurity.login.password.label"/>:</label>
                <span>&nbsp;</span>
                <span id="passwordOutput" class="passwordOutput"></span>
            </p>

            <p style="padding: 0 0 0 109px;">
                <input type='submit' id="submit" value='${message(code: 'registration.registerButton.label')}'/>
                <g:message code="newsList.buttonsSeparator.label" />
                <a href="${g.createLink(controller: 'login', action: 'auth')}">Войти</a>
            </p>
        </form>
    </div>
</div>
</body>
</html>
