<%--
- form.jsp
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

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.companyrecord.name" path="name"/>
	<acme:form-textbox code="authenticated.companyrecord.sector" path="sector"/>
	<acme:form-textbox code="authenticated.companyrecord.ceoName" path="ceoName"/>
	<acme:form-textbox code="authenticated.companyrecord.webSite" path="webSite"/>
	<acme:form-textbox code="authenticated.companyrecord.phone" path="phone"/>
	<acme:form-textbox code="authenticated.companyrecord.email" path="email"/>
	<acme:form-checkbox code="authenticated.companyrecord.incorporated" path="incorporated"/>
	<acme:form-textbox code="authenticated.companyrecord.stars" path="stars"/>
	<acme:form-textarea code="authenticated.companyrecord.description" path="description"/>
	

<%-- 	<acme:form-submit code="authentication.offer.create" action="/authenticated/offer/create"/>
 --%>
		
  	<acme:form-return code="authentication.offer.return"/>
</acme:form>
