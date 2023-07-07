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
          
            <h3 class="text-center my-4">Editar Cliente</h3>
           <form class="mb-5" method="POST" action="${pageContext.request.contextPath}/editarClientes">
           <input type="hidden" name="clienteId" value="${cliente.id}" />
			<div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" name="nombre" value="${cliente.nombre}" required>
            </div>
            
            <div class="form-group">
                <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                <input type="date" class="form-control" name="fechaNacimiento" value="${cliente.fechaNacimiento}">
            </div>
            
            <div class="form-group ">
                <label for="rut">RUT:</label>
                <input type="text" class="form-control" name="rut" maxlength="18" value="${cliente.rut}">
            </div>
            
            <div class="form-group">
                <label for="tipo">Tipo:</label>
                <select class="form-control" name="tipo" onchange="mostrarCampos()" disabled>
					<option value="Cliente" ${cliente.tipo == 'Cliente' ? 'selected' : ''}>Cliente</option>
    				<option value="Administrativo" ${cliente.tipo == 'Administrativo' ? 'selected' : ''}>Administrativo</option>
    				<option value="Profesional" ${cliente.tipo == 'Profesional' ? 'selected' : ''}>Profesional</option>
                </select>
            </div>
            

            
			<div class="form-group cliente-fields">
			<div class="form-group ">
                <label for="telefono">Telefono:</label>
                <input type="text" class="form-control" name="telefono" value="${cliente.telefono}">
            </div>
            <div class="form-group">
                <label for="afp">AFP:</label>
					  <select class="form-control" name="afp">
					    <option value="Capital" ${cliente.afp == 'Capital' ? 'selected' : ''}>Capital</option>
					    <option value="Habitat" ${cliente.afp == 'Habitat' ? 'selected' : ''}>Habitat</option>
					    <option value="Cuprum" ${cliente.afp == 'Cuprum' ? 'selected' : ''}>Cuprum</option>
					    <option value="Provida" ${cliente.afp == 'Provida' ? 'selected' : ''}>Provida</option>
					    <option value="Planvital" ${cliente.afp == 'Planvital' ? 'selected' : ''}>Planvital</option>
					    <option value="Futuro" ${cliente.afp == 'Futuro' ? 'selected' : ''}>Futuro</option>
					    <option value="Modelo" ${cliente.afp == 'Modelo' ? 'selected' : ''}>Modelo</option>
					  </select>
            </div>
             <div class="form-group">
                <label for="sistemaSalud">Sistema de salud:</label>
                <select class="form-control" name="sistemaSalud">
 					<option value="Fonasa" ${cliente.sistemaSalud == 'Fonasa' ? 'selected' : ''}>Fonasa</option>
    				<option value="Isapre" ${cliente.sistemaSalud == 'Isapre' ? 'selected' : ''}>Isapre</option>
                </select>
            </div>
            <div class="form-group ">
                <label for="direccion">Direccion:</label>
                <input type="text" class="form-control" name="direccion" value="${cliente.direccion}">
            </div>
            <div class="form-group ">
                <label for="comuna">Comuna:</label>
                <input type="text" class="form-control" name="comuna" value="${cliente.comuna}">
            </div>
            <div class="form-group ">
                <label for="edad">Edad:</label>
                <input type="text" class="form-control" name="edad" value="${cliente.edad}">
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