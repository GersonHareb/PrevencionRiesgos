<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Capacitaciones | Contacto</title>
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
          
            <h3 class=" text-center my-4">Contacta con nosotros</h3>
			<form action="${pageContext.request.contextPath}/contactos" method="post" class="mb-5">
			  <div class="form-floating mb-3">
			    <input type="text" class="form-control" id="floatingName" name="username" placeholder="Tu nombre aquí" />
			    <label for="floatingName">Nombre</label>
			  </div>
			  <div class="form-floating mb-3">
			    <input type="email" class="form-control" id="floatingEmail" name="email" placeholder="Correo Electrónico" />
			    <label for="floatingEmail">Correo Electrónico</label>
			  </div>
			  <div class="form-floating mb-3">
			    <input type="text" class="form-control" id="floatingDireccion" name="direccion" placeholder="Dirección" />
			    <label for="floatingDireccion">Dirección</label>
			  </div>
			  <div class="form-floating mb-3">
			    <textarea class="form-control custom-textarea" id="floatingComentarios" name="comentarios" placeholder="Comentarios" style="height: 150px"></textarea>
			    <label for="floatingComentarios">Comentarios</label>
			  </div>
			  <button type="submit" class="btn btn-primary">Enviar</button>
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