package mclargehuge



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Book99Controller {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Book99.list(params), model:[book99InstanceCount: Book99.count()]
    }

    def show(Book99 book99Instance) {
        respond book99Instance
    }

    def create() {
        respond new Book99(params)
    }

    @Transactional
    def save(Book99 book99Instance) {
        if (book99Instance == null) {
            notFound()
            return
        }

        if (book99Instance.hasErrors()) {
            respond book99Instance.errors, view:'create'
            return
        }

        book99Instance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'book99.label', default: 'Book99'), book99Instance.id])
                redirect book99Instance
            }
            '*' { respond book99Instance, [status: CREATED] }
        }
    }

    def edit(Book99 book99Instance) {
        respond book99Instance
    }

    @Transactional
    def update(Book99 book99Instance) {
        if (book99Instance == null) {
            notFound()
            return
        }

        if (book99Instance.hasErrors()) {
            respond book99Instance.errors, view:'edit'
            return
        }

        book99Instance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Book99.label', default: 'Book99'), book99Instance.id])
                redirect book99Instance
            }
            '*'{ respond book99Instance, [status: OK] }
        }
    }

    @Transactional
    def delete(Book99 book99Instance) {

        if (book99Instance == null) {
            notFound()
            return
        }

        book99Instance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Book99.label', default: 'Book99'), book99Instance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'book99.label', default: 'Book99'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
