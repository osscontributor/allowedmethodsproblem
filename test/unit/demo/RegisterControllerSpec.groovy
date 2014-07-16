package demo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RegisterController)
class RegisterControllerSpec extends Specification {

    void "test register with valid request method"() {
        when:
        params.name = 'Jeff'
        request.method = 'POST'
        def model = controller.register()
        def user = model.user

        then:
        response.status == 200
        user.name == 'Jeff'
    }

    void "test register with invalid request method"() {
        when:
        params.name = 'Jeff'
        request.method = 'GET'
        controller.register()

        then:
        response.status == 405
    }

    void "test register with command object and valid request method"() {
        when:
        params.name = 'Jeff'
        request.method = 'POST'
        def model = controller.registerWithCommandObject()
        def user = model.user

        then:
        response.status == 200
        user.name == 'Jeff'
    }

    void "test register with command object and invalid request method"() {
        when:
        params.name = 'Jeff'
        request.method = 'GET'
        controller.registerWithCommandObject()

        then:
        response.status == 405
    }
}
