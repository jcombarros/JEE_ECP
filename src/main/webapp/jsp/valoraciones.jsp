<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/estilo.css" />">
<title>Valoraciones</title>
</head>
<body>
    <h1>
        Lista de <b>Valoraciones</b> por tema
    </h1>
    <c:set var="valoracionesView" scope="request" value="${valoraciones}" />
    <c:set var="mensaje" scope="request" value="${valoracionesView.mensaje}" />
    <c:if test="${mensaje != ''}"> 
        <p>
            <span class="mensaje">${mensaje}</span>
        </p>
    </c:if>
    <div>${valoracionesView.update()}</div>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Pregunta</th>
            <th># respuestas</th>
            <c:set var="nivelesEstudios" scope="request" value="${valoracionesView.nivelesEstudios}" />
            <c:forEach  var="nivelEstudios" items="${nivelesEstudios}">
	            <th>Media ${nivelEstudios.descripcion}</th>
	        </c:forEach>
        </tr>
        <c:set var="temas" scope="request" value="${valoracionesView.temas}" />
	    <c:forEach  var="temaDto" items="${temas}">
            <tr>
                <td>${temaDto.nombre}</td>
                <td>${temaDto.pregunta}</td>
                <td>${temaDto.numValoraciones}</td>
                <c:set var="mediaPorNivel" scope="request" value="${temaDto.mediaPorNivel}" />
                <c:forEach  var="media" items="${mediaPorNivel}">
                    <td>${media}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="/JEE_ECP/Valoraciones/home">Volver a Home</a>
    </p>
</body>
</html>