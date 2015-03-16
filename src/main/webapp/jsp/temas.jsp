<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temas</title>
</head>
<body>
    <h1>
        Vista de <b>Rol</b>
    </h1>
    <c:set var="temasView" scope="request" value="${temas}" />
    <div>${temasView.update()}</div>
    <form action="/Web/v1/rol" method="post">
        <p>Lista de Temas:</p>
        <ul>
            <c:forEach var="tema" items="${temasView.temas}">
                <li><a href="/JEE_ECP/Valoraciones/temas?temaId=${tema.id}">${tema.nombre}</a></li>
            </c:forEach>
        </ul>
        <p>
            Tema seleccionado: 
            <c:set var="temaSeleccionado" scope="request" value="${temasView.tema}" />
            <c:choose>
                <c:when test="${temaSeleccionado == null}" >
                    <label><em>Seleccione un tema.</em></label>
                </c:when>
                <c:otherwise>
                    <strong>${temaSeleccionado.nombre}: ${temaSeleccionado.pregunta}</strong>
                </c:otherwise>
            </c:choose>
        </p>
        <p>
            <input type="submit" value="Votar" />
        </p>
    </form>
    <p>
        <a href="/Web/v1/home">Volver a Home</a>
    </p>
</body>
</html>