<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Capacitaciones | Listar usuarios</title>
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
      <div class="p-0">
  	  	<%@ include file ="plantillas/leftNav.jsp" %>
  	  </div>
  	  <div class="d-flex flex-column bg-body-tertiary w-100">
  	  <%@ include file="plantillas/navegador.jsp" %>
      <div class="bg-body-tertiary">
      <div class="container-fluid table-responsive">
      
      <h3 class=" text-center my-4">Listado de usuarios</h3>
	    
	    <h4 class="text-center">Clientes</h4>
	    <table class="table m-auto">
	    
	    <thead class="thead-dark">
	        <tr>
	            <th scope="col">ID</th>
	            <th scope="col">Nombre</th>
	            <th scope="col">Fecha de Nacimiento</th>
	            <th scope="col">RUT</th>
	            <th scope="col">Teléfono</th>
	            <th scope="col">AFP</th>
	            <th scope="col">Sistema de Salud</th>
	            <th scope="col">Dirección</th>
	            <th scope="col">Comuna</th>
	            <th scope="col">Edad</th>
	            <th scope="col">Editar</th>
	        </tr>
	        </thead>
	        <tbody>
	        <c:forEach var="cliente" items="${clientes}">
	            <tr>
	                <th scope="row">${cliente.id}</th>
	                <td>${cliente.nombre}</td>
	                <td>${cliente.fechaNacimiento}</td>
	                <td>${cliente.rut}</td>
	                <td>${cliente.telefono}</td>
	                <td>${cliente.afp}</td>
	                <td>${cliente.sistemaSalud}</td>
	                <td>${cliente.direccion}</td>
	                <td>${cliente.comuna}</td>
	                <td>${cliente.edad}</td>
	                <td>
                    <a href="${pageContext.request.contextPath}/editarClientes?id=${cliente.id}">
                        <i class="fas fa-edit"></i>
                    </a>
                </td>
	            </tr>
	        </c:forEach>
	        </tbody>
	    </table>
	
	    <h4 class="text-center mt-3">Administrativos</h4>
	    <table class="table m-auto">
	    <thead class="thead-dark">
	        <tr>
	            <th scope="col">ID</th>
	            <th scope="col">Nombre</th>
	            <th scope="col">Fecha de Nacimiento</th>
	            <th scope="col">RUT</th>
	            <th scope="col">Área</th>
	            <th scope="col">Experiencia Previa</th>
	            <th scope="col">Editar</th>
	        </tr>
	        </thead>
	        <c:forEach var="admin" items="${admins}">
	            <tr>
	                <td>${admin.id}</td>
	                <td>${admin.nombre}</td>
	                <td>${admin.fechaNacimiento}</td>
	                <td>${admin.rut}</td>
	                <td>${admin.area}</td>
	                <td>${admin.experienciaPrevia}</td>
	                <td>
                    <a href="${pageContext.request.contextPath}/editarAdmin?id=${admin.id}">
                        <i class="fas fa-edit"></i>
                    </a>
                </td>
	            </tr>
	        </c:forEach>
	    </table>
	
	    <h4 class="text-center mt-3">Profesionales</h4>
	    <table class="table m-auto">
	    <thead class="thead-dark">
	        <tr>
	            <th>ID</th>
	            <th>Nombre</th>
	            <th>Fecha de Nacimiento</th>
	            <th>RUT</th>
	            <th>Título</th>
	            <th>Fecha de Ingreso</th>
	            <th scope="col">Editar</th>
	        </tr>
	        </thead>
	        <c:forEach var="profesional" items="${pros}">
	            <tr>
	                <td>${profesional.id}</td>
	                <td>${profesional.nombre}</td>
	                <td>${profesional.fechaNacimiento}</td>
	                <td>${profesional.rut}</td>
	                <td>${profesional.titulo}</td>
	                <td>${profesional.fechaIngreso}</td>
	                <td>
                    <a href="${pageContext.request.contextPath}/editarProfesional?id=${profesional.id}">
                        <i class="fas fa-edit"></i>
                    </a>
                </td>
	            </tr>
	        </c:forEach>
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