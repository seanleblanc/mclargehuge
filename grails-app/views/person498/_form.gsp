<%@ page import="mclargehuge.Person498" %>



<div class="fieldcontain ${hasErrors(bean: person1Instance, field: 'birthday', 'error')} required">
	<label for="birthday">
		<g:message code="person1.birthday.label" default="Birthday" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthday" precision="day"  value="${person1Instance?.birthday}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: person1Instance, field: 'book', 'error')} required">
	<label for="book">
		<g:message code="person1.book.label" default="Book" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="book" name="book.id" from="${mclargehuge.Book1.list()}" optionKey="id" required="" value="${person1Instance?.book?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: person1Instance, field: 'first', 'error')} required">
	<label for="first">
		<g:message code="person1.first.label" default="First" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="first" required="" value="${person1Instance?.first}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: person1Instance, field: 'last', 'error')} required">
	<label for="last">
		<g:message code="person1.last.label" default="Last" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="last" required="" value="${person1Instance?.last}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: person1Instance, field: 'ssn', 'error')} required">
	<label for="ssn">
		<g:message code="person1.ssn.label" default="Ssn" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ssn" type="number" value="${person1Instance.ssn}" required=""/>

</div>

