import idrabenia.domain.security.RegistrationInfo
import org.apache.commons.lang.Validate
import idrabenia.domain.security.User

/**
 * Service used for process registration of new users in system
 * @author Ilya Drabenia
 * @since 16.11.12
 */
class RegistrationService {

    /**
     * Method for register new user by existing email
     * @param registrationInfo
     * @return method set generated password to registrationInfo and return new user object
     */
    User registerNewUser(RegistrationInfo registrationInfo) {
        Validate.notNull(registrationInfo)

        registrationInfo.password = UUID.randomUUID().toString()
        new User(username: registrationInfo.email, password: registrationInfo.password, enabled: true).save(flush: true)
    }

}
