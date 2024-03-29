<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form> 
	<acme:form-textbox code="administrator.noncommercialBanner.form.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.noncommercialBanner.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.noncommercialBanner.form.label.target" path="target"/>
	<acme:form-textbox code="administrator.noncommercialBanner.form.label.jingle" path="jingle"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.noncommercialBanner.form.button.update" action="/administrator/non-commercial-banner/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.noncommercialBanner.form.button.delete" action="/administrator/non-commercial-banner/delete"/>
	<acme:form-submit test="${command == 'create'}" code="administrator.noncommercialBanner.form.button.create" action="/administrator/non-commercial-banner/create"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.noncommercialBanner.form.button.update" action="/administrator/non-commercial-banner/update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.noncommercialBanner.form.button.delete" action="/administrator/non-commercial-banner/delete"/>
	<acme:form-return code="administrator.noncommercialBanner.form.button.return"/>
</acme:form>
