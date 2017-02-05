package mclargehuge



import grails.test.mixin.*
import spock.lang.*

@TestFor(Person1Controller)
@Mock(Person1)
class Person1ControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.person1InstanceList
            model.person1InstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.person1Instance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def person1 = new Person1()
            person1.validate()
            controller.save(person1)

        then:"The create view is rendered again with the correct model"
            model.person1Instance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            person1 = new Person1(params)

            controller.save(person1)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/person1/show/1'
            controller.flash.message != null
            Person1.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def person1 = new Person1(params)
            controller.show(person1)

        then:"A model is populated containing the domain instance"
            model.person1Instance == person1
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def person1 = new Person1(params)
            controller.edit(person1)

        then:"A model is populated containing the domain instance"
            model.person1Instance == person1
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/person1/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def person1 = new Person1()
            person1.validate()
            controller.update(person1)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.person1Instance == person1

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            person1 = new Person1(params).save(flush: true)
            controller.update(person1)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/person1/show/$person1.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/person1/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def person1 = new Person1(params).save(flush: true)

        then:"It exists"
            Person1.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(person1)

        then:"The instance is deleted"
            Person1.count() == 0
            response.redirectedUrl == '/person1/index'
            flash.message != null
    }
}
