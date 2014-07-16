package demo

class RegisterController {

    static allowedMethods = [registerWithCommandObject: 'POST', register: 'POST']

    def registerWithCommandObject(User user) {
        [user: user]
    }

    def register() {
        def user = new User(params)
        user.validate()
        [user: user]
    }
}

class User {
    String name
    static constraints = {
        name matches: /[A-Z].*/
    }
}
