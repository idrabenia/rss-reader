import idrabenia.domain.security.User

class BootStrap {

    def init = { servletContext ->

        if (!User.count()) {
            new User(username: 'admin', password: 'admin', enabled: true).save(flush: true)
            new User(username: 'qa', password: 'qa', enabled: true).save(flush: true)
        }

    }

    def destroy = {
    }
}
