package idrabenia.domain.security

/**
 * Class represent request on registration of specified user
 * @author Ilya Drabenia
 * @since 16.11.12
 */
class RegistrationInfo {
    String email
    String password
    String errorsList

    static constraints = {
        email nullable: false, blank: false, email: true, validator: emailUniqueValidator
        password nullable: true
        errorsList nullable: true
    }

    static emailUniqueValidator = { field, obj ->
        !User.findByUsername(field)
    }

    static mapWith = "none"
}
