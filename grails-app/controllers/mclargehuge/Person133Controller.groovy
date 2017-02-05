package mclargehuge



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Person133Controller {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Person133.list(params), model:[person1InstanceCount: Person133.count()]
    }

    def show(Person133 person1Instance) {
        respond person1Instance
    }

    def create() {
        respond new Person133(params)
    }

    @Transactional
    def save(Person133 person1Instance) {
        if (person1Instance == null) {
            notFound()
            return
        }

        if (person1Instance.hasErrors()) {
            respond person1Instance.errors, view:'create'
            return
        }

        person1Instance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'person1.label', default: 'Person133'), person1Instance.id])
                redirect person1Instance
            }
            '*' { respond person1Instance, [status: CREATED] }
        }
    }

    def edit(Person133 person1Instance) {
        respond person1Instance
    }

    @Transactional
    def update(Person133 person1Instance) {
        if (person1Instance == null) {
            notFound()
            return
        }

        if (person1Instance.hasErrors()) {
            respond person1Instance.errors, view:'edit'
            return
        }

        person1Instance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Person133.label', default: 'Person133'), person1Instance.id])
                redirect person1Instance
            }
            '*'{ respond person1Instance, [status: OK] }
        }
    }

    @Transactional
    def delete(Person133 person1Instance) {

        if (person1Instance == null) {
            notFound()
            return
        }

        person1Instance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Person133.label', default: 'Person133'), person1Instance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'person1.label', default: 'Person133'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
