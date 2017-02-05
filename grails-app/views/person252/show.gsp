
<%@ page import="mclargehuge.Person252" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person1.label', default: 'Person252')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-person1" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-person1" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list person1">
			
				<g:if test="${person1Instance?.birthday}">
				<li class="fieldcontain">
					<span id="birthday-label" class="property-label"><g:message code="person1.birthday.label" default="Birthday" /></span>
					
						<span class="property-value" aria-labelledby="birthday-label"><g:formatDate date="${person1Instance?.birthday}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${person1Instance?.book}">
				<li class="fieldcontain">
					<span id="book-label" class="property-label"><g:message code="person1.book.label" default="Book" /></span>
					
						<span class="property-value" aria-labelledby="book-label"><g:link controller="book1" action="show" id="${person1Instance?.book?.id}">${person1Instance?.book?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${person1Instance?.first}">
				<li class="fieldcontain">
					<span id="first-label" class="property-label"><g:message code="person1.first.label" default="First" /></span>
					
						<span class="property-value" aria-labelledby="first-label"><g:fieldValue bean="${person1Instance}" field="first"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${person1Instance?.last}">
				<li class="fieldcontain">
					<span id="last-label" class="property-label"><g:message code="person1.last.label" default="Last" /></span>
					
						<span class="property-value" aria-labelledby="last-label"><g:fieldValue bean="${person1Instance}" field="last"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${person1Instance?.ssn}">
				<li class="fieldcontain">
					<span id="ssn-label" class="property-label"><g:message code="person1.ssn.label" default="Ssn" /></span>
					
						<span class="property-value" aria-labelledby="ssn-label"><g:fieldValue bean="${person1Instance}" field="ssn"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:person1Instance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${person1Instance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
