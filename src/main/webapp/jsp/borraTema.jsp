<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/estilo.css" />">
<title>Borrar tema</title>
</head>
<body>
    <h1>
        Lista de <b>Temas</b>
    </h1>
    <c:set var="borraTemaView" scope="request" value="${borraTema}" />
    <c:set var="mensaje" scope="request" value="${borraTemaView.mensaje}" />
    <c:if test="${mensaje != ''}"> 
        <p>
            <span class="mensaje">${mensaje}</span>
        </p>
    </c:if>
    <div>${borraTemaView.update()}</div>
    <form action="/JEE_ECP/Valoraciones/borraTema" method="post">
	    <c:set var="autorizado" scope="request" value="${borraTemaView.autorizado}" />
	    <c:choose>
			<c:when test="${autorizado == false}" >
				<div>
		            <label class="campoForm" for="identificador">Identificador:</label>
		            <input type="password" id="identificador" name="identificador" value="${borraTemaView.identificador}">
		        </div>
		        <p>
                    <input type="submit" value="Comprobar" />
                </p>
			</c:when>
			<c:otherwise>
		        <label class="campoForm" for="tema">Temas:</label>
                <select name="tema">
                    <c:forEach  var="tema" items="${borraTemaView.temas}">
                        <option value="${tema.id}">${tema.nombre}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="identificador" value="${borraTemaView.identificador}">
		        <p>
		            <input type="submit" value="Borrar" />
		        </p>
			</c:otherwise>
	    </c:choose>
    </form>
    <p>
        <a href="/JEE_ECP/Valoraciones/home">Volver a Home</a>
    </p>
</body>
</html>