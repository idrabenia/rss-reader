import idrabenia.domain.security.RegistrationInfo
import org.apache.commons.lang.Validate
import idrabenia.domain.security.User
import org.apache.commons.lang.RandomStringUtils

/**
 * Service used for process registration of new users in system
 * @author Ilya Drabenia
 * @since 16.11.12
 */
class RegistrationService {

    private static final int RANDOM_PASSWORD_CHAR_COUNT = 10

    /**
     * Method for register new user by existing email
     * @param registrationInfo
     * @return method set generated password to registrationInfo and return new user object
     */
    User registerNewUser(RegistrationInfo registrationInfo) {
        Validate.notNull(registrationInfo)

        registrationInfo.password = RandomStringUtils.randomAlphanumeric(RANDOM_PASSWORD_CHAR_COUNT)
        new User(username: registrationInfo.email, password: registrationInfo.password, enabled: true).save(flush: true)
    }

}
