<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Capacitaciones | Listar capacitaciones</title>
    <c:if test="${sessionScope.usuario != null && sessionScope.usuario}">
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
      crossorigin="anonymous"
    />
    <script
      src="https://kit.fontawesome.com/33aec193ff.js"
      crossorigin="anonymous"
    ></script>
   <style>
     <%@ include file="css/style.css" %>
    </style>
    </c:if>
  </head>
  <body class="p-0 m-0">
    <main class="contenedor-principal">
  	  <div class="p-0 ">
  	  	<%@ include file ="plantillas/leftNav.jsp" %>
  	  </div>
  	  <div class="d-flex flex-column bg-body-tertiary w-100">
  	  <%@ include file="plantillas/navegador.jsp" %>
      <div class="bg-body-tertiary">  
      <h3 class="text-center my-4">Listado de capacitaciones</h3>
	  <div class="container-fluid table-responsive">
	  		<table class=" table table-sm table-striped m-auto">
		  <thead class="thead-dark">
		    <tr>
		      <th>ID</th>
		      <th>Nombre</th>
		      <th>Detalle</th>
		      <th>Día</th>
		      <th>Hora</th>
		      <th>Lugar</th>
		      <th>Duración</th>
		      <th>Asistentes</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="capacitacion" items="${capacitaciones}">
		      <tr>
		        <td>${capacitacion.id}</td>
		        <td>${capacitacion.nombre}</td>
		        <td>${capacitacion.detalle}</td>
		        <td>${capacitacion.dia}</td>
		        <td>${capacitacion.hora}</td>
		        <td>${capacitacion.lugar}</td>
		        <td>${capacitacion.duracion}</td>
		        <td>${capacitacion.cantidadAsistentes}</td>
		      </tr>
		    </c:forEach>
		  </tbody>
		</table>
	  </div>

      </div>
      </div>
    </main>

	<%@ include file="plantillas/footer.jsp" %>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
        <script>
    	<%@ include file="js/script.js" %>
    </script>
  </body>
</html>