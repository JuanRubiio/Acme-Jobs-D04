
<%--
- list.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.auditor.audit-record.list.label.title" path="title" width="40%"/>
	<acme:list-column code="authenticated.auditor.audit-record.list.label.moment" path="percentage" width="20%"/>
	<acme:list-column code="authenticated.auditor.audit-record.list.label.status" path="description" width="40%"/>
</acme:list>
	<acme:form-return code="authenticated.auditor.audit-record.form.button.return"/>



