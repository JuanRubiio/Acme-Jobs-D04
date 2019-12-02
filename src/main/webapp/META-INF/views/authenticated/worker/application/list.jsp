<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="authenticated.application.list.label.referenceNumber" path="referenceNumber" width="30%"/>
	<acme:list-column code="authenticated.application.list.label.moment" path="moment" width="20%"/>
	<acme:list-column code="authenticated.application.list.label.status" path="status" width="20%"/>
	<acme:list-column code="authenticated.application.list.label.qualifications" path="qualifications" width="30%"/>
</acme:list>


