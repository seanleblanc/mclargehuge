
<%@ page import="mclargehuge.Person414" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person1.label', default: 'Person414')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-person1" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-person1" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="birthday" title="${message(code: 'person1.birthday.label', default: 'Birthday')}" />
					
						<th><g:message code="person1.book.label" default="Book" /></th>
					
						<g:sortableColumn property="first" title="${message(code: 'person1.first.label', default: 'First')}" />
					
						<g:sortableColumn property="last" title="${message(code: 'person1.last.label', default: 'Last')}" />
					
						<g:sortableColumn property="ssn" title="${message(code: 'person1.ssn.label', default: 'Ssn')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${person1InstanceList}" status="i" var="person1Instance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${person1Instance.id}">${fieldValue(bean: person1Instance, field: "birthday")}</g:link></td>
					
						<td>${fieldValue(bean: person1Instance, field: "book")}</td>
					
						<td>${fieldValue(bean: person1Instance, field: "first")}</td>
					
						<td>${fieldValue(bean: person1Instance, field: "last")}</td>
					
						<td>${fieldValue(bean: person1Instance, field: "ssn")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${person1InstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
