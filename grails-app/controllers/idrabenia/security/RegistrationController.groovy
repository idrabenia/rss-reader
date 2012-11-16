package idrabenia.security

import idrabenia.domain.security.RegistrationInfo
import grails.converters.JSON

/**
 * Controller used for registration of new users
 * @author Ilya Drabenia
 * @since 16.11.12
 */
class RegistrationController {

    def registrationService

    def index = {
        render(view: 'registration')
    }

    def registerNewUser = {
        def info = new RegistrationInfo(params)

        if (info.validate()) {
            registrationService.registerNewUser(info)
        }

        info.errorsList = info.errors?.allErrors?.collect { message(error: it, encodeAs: 'HTML') }?.join('<br />')
        render(info as JSON)
    }

}
