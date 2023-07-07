<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Capacitaciones | Crear Usuario</title>
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
      <div class="container-fluid">
          <div class="formulario">
          
            <h3 class="text-center my-4">Editar Administrativo</h3>
           <form class="mb-5" method="POST" action="${pageContext.request.contextPath}/editarAdmin">
			<input type="hidden" name="adminId" value="${admin.id}" />
			<div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" name="nombre" value="${admin.nombre}" required>
            </div>
            
            <div class="form-group">
                <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                <input type="date" class="form-control" name="fechaNacimiento" value="${admin.fechaNacimiento}">
            </div>
            
            <div class="form-group ">
                <label for="rut">RUT:</label>
                <input type="text" class="form-control" name="rut" maxlength="18" value="${admin.rut}">
            </div>
            
            <div class="form-group">
                <label for="tipo">Tipo:</label>
                <select class="form-control" name="tipo" onchange="mostrarCampos() " disabled>
					<option value="Cliente" ${admin.tipo == 'Cliente' ? 'selected' : ''}>Cliente</option>
    				<option value="Administrativo" ${admin.tipo == 'Administrativo' ? 'selected' : ''}>Administrativo</option>
    				<option value="Profesional" ${admin.tipo == 'Profesional' ? 'selected' : ''}>Profesional</option>
                </select>
            </div>
			
			<div class="form-group administrativo-fields">
            <div class="form-group ">
                <label for="area">Area:</label>
                <input type="text" class="form-control" name="area" value="${admin.area}">
            </div>
            <div class="form-group ">
                <label for="experienciaPrevia">Experiencia previa:</label>
                <input type="text" class="form-control" name="experienciaPrevia" value="${admin.experienciaPrevia}">
            </div>
			</div>
			
              <button type="submit" class="btn btn-primary mt-5">Ingresar</button>
            </form>
          </div>
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