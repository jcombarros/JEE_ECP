<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/estilo.css" />">

<title>Nuevo Tema</title>
</head>
<body>
    <h1>
        Nuevo <b>Tema</b>
    </h1>
    <c:set var="nuevoTemaView" scope="request" value="${nuevoTema}" />
    <c:set var="mensaje" scope="request" value="${nuevoTemaView.mensaje}" />
    <c:if test="${mensaje != ''}"> 
        <p>
            <span class="mensaje">${mensaje}</span>
        </p>
    </c:if>
    <div>${nuevoTemaView.update()}</div>
    <form action="/JEE_ECP/Valoraciones/nuevoTema" method="post">
        <div>
            <label class="campoForm" for="nombre">Nombre:</label>
            <input type="text" name="nombre" value="${nuevoTemaView.tema.nombre}">
        </div>
        <div>
            <label class="campoForm" for="pregunta">Pregunta:</label>
            <textarea rows="2" cols="50" name="pregunta" style="resize: none">${nuevoTemaView.tema.pregunta}</textarea>
        </div>
        <p>
            <input type="submit" value="Crear" />
        </p>
    </form>
    <p>
        <a href="/JEE_ECP/Valoraciones/home">Volver a Home</a>
    </p>
</body>
</html>