package mclargehuge



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Person62Controller {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Person62.list(params), model:[person1InstanceCount: Person62.count()]
    }

    def show(Person62 person1Instance) {
        respond person1Instance
    }

    def create() {
        respond new Person62(params)
    }

    @Transactional
    def save(Person62 person1Instance) {
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
                flash.message = message(code: 'default.created.message', args: [message(code: 'person1.label', default: 'Person62'), person1Instance.id])
                redirect person1Instance
            }
            '*' { respond person1Instance, [status: CREATED] }
        }
    }

    def edit(Person62 person1Instance) {
        respond person1Instance
    }

    @Transactional
    def update(Person62 person1Instance) {
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
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Person62.label', default: 'Person62'), person1Instance.id])
                redirect person1Instance
            }
            '*'{ respond person1Instance, [status: OK] }
        }
    }

    @Transactional
    def delete(Person62 person1Instance) {

        if (person1Instance == null) {
            notFound()
            return
        }

        person1Instance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Person62.label', default: 'Person62'), person1Instance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'person1.label', default: 'Person62'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
