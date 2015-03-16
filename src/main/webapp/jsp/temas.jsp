<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.campoForm{
    position: relative;
    width: 150px;
    padding-top: 5px;
    padding-bottom: 5px;
    padding-left: 30px;
    display: inline-block;
}
.mensaje{
    color: red;
}
</style>
<title>Temas</title>
</head>
<body>
    <h1>
        Lista de <b>Temas</b>
    </h1>
    <c:set var="temasView" scope="request" value="${temas}" />
    <c:set var="mensaje" scope="request" value="${temasView.mensaje}" />
    <c:if test="${mensaje != ''}"> 
        <span class="mensaje">${mensaje}</span>
    </c:if>
    <div>${temasView.update()}</div>
    <form action="/JEE_ECP/Valoraciones/temas" method="post">
        <p>Temas:</p>
        <ul>
            <c:forEach var="tema" items="${temasView.temas}">
                <li><a href="/JEE_ECP/Valoraciones/temas?temaId=${tema.id}">${tema.nombre}</a></li>
            </c:forEach>
        </ul>
        <p>
            <span>Tema seleccionado:</span> 
            <c:set var="temaSeleccionado" scope="request" value="${temasView.tema}" />
            <c:choose>
                <c:when test="${temaSeleccionado == null}" >
                    <label><em>Seleccione un tema.</em></label>
                </c:when>
                <c:otherwise>
                    <input type="text" name="temaId" value="${temaSeleccionado.id}" style="display: none;">
                    <strong>${temaSeleccionado.nombre}: ${temaSeleccionado.pregunta}</strong>
                    <c:set var="valoracion" scope="request" value="${temasView.valoracion}" />
	                <p>               
	                    <span class="campoForm">Valoración:</span>
	                    <select name="respuesta">
	                        <c:forEach  var="puntuacion"  begin="1" end="10" step="1">
	                            <option value="${puntuacion}">${puntuacion}</option>
	                        </c:forEach>
	                    </select>
	                </p>
	                <p>
                        <c:set var="nivelesEstudios" scope="request" value="${temasView.nivelesEstudios}" />
                        <c:if test="${nivelesEstudios != null}"> 
                        <span class="campoForm">Nivel de Estudios:</span>
	                        <select name="nivelEstudios">
	                            <c:forEach  var="nivelEstudios" items="${nivelesEstudios}">
	                                <option value="${nivelEstudios}">${nivelEstudios.descripcion}</option>
	                            </c:forEach>
	                        </select>
                        </c:if>
                    </p>
                </c:otherwise>
            </c:choose>
        
        <p>
            <input type="submit" value="Votar" />
        </p>
    </form>
    <p>
        <a href="/JEE_ECP/Valoraciones/home">Volver a Home</a>
    </p>
</body>
</html>