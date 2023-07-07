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
          
            <h3 class="text-center my-4">Crear Usuario</h3>
           <form class="mb-5" method="POST" action="${pageContext.request.contextPath}/crearusuario">
			<div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" name="nombre" required>
            </div>
            
            <div class="form-group">
                <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                <input type="date" class="form-control" name="fechaNacimiento">
            </div>
            
            <div class="form-group ">
                <label for="rut">RUT:</label>
                <input type="text" class="form-control" name="rut" maxlength="18">
            </div>
            
            <div class="form-group">
                <label for="tipo">Tipo:</label>
                <select class="form-control" name="tipo" onchange="mostrarCampos()">
                	<option value="" selected disabled>Elige una opción</option>
                    <option value="Cliente">Cliente</option>
                    <option value="Administrativo">Administrativo</option>
                    <option value="Profesional">Profesional</option>
                </select>
            </div>
            

            
			<div class="form-group cliente-fields hidden">
			<div class="form-group ">
                <label for="telefono">Telefono:</label>
                <input type="text" class="form-control" name="telefono">
            </div>
            <div class="form-group">
                <label for="afp">AFP:</label>
                <select class="form-control" name="afp">
                	<option value="" selected disabled>Elige una opción</option>
                    <option value="Capital">Capital</option>
                    <option value="Habitat">Habitat</option>
                    <option value="Cuprum">Cuprum</option>
                    <option value="Provida">Provida</option>
                    <option value="Planvital">Planvital</option>
                    <option value="Futuro">Futuro</option>
                    <option value="Modelo">Modelo</option>
                </select>
            </div>
             <div class="form-group">
                <label for="sistemaSalud">Sistema de salud:</label>
                <select class="form-control" name="sistemaSalud">
                	<option value="" selected disabled>Elige una opción</option>
                    <option value="Fonasa">Fonasa</option>
                    <option value="Isapre">Isapre</option>
                </select>
            </div>
            <div class="form-group ">
                <label for="direccion">Direccion:</label>
                <input type="text" class="form-control" name="direccion">
            </div>
            <div class="form-group ">
                <label for="comuna">Comuna:</label>
                <input type="text" class="form-control" name="comuna">
            </div>
            <div class="form-group ">
                <label for="edad">Edad:</label>
                <input type="text" class="form-control" name="edad">
            </div>
			</div>
			
			<div class="form-group administrativo-fields hidden">
            <div class="form-group ">
                <label for="area">Area:</label>
                <input type="text" class="form-control" name="area">
            </div>
            <div class="form-group ">
                <label for="experienciaPrevia">Experiencia previa:</label>
                <input type="text" class="form-control" name="experienciaPrevia">
            </div>
			</div>
			
			<div class="form-group profesional-fields hidden">
            <div class="form-group ">
                <label for="titulo">Titulo:</label>
                <input type="text" class="form-control" name="titulo">
            </div>
            <div class="form-group ">
                <label for="fechaIngreso">Fecha de ingreso:</label>
                <input type="date" class="form-control" name="fechaIngreso">
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