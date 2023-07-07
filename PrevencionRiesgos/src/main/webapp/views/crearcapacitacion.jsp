<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Capacitaciones | Crear Capacitaciones</title>
    <c:if test="${sessionScope.usuario != null && sessionScope.usuario}">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous" />
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
          <h3 class="text-center my-4">Crear capacitacion</h3>
          <form class="mb-5" method="POST" action="${pageContext.request.contextPath}/crearCapacitacion" onsubmit="return validarFormulario()">
            <div class="mb-3">
              <label for="rutCliente" class="form-label ">Rut del Cliente</label>
              <input type="text" class="form-control" id="rutCliente" name="rutCliente" disabled />
            </div>
            <div class="mb-3">
              <label for="nombre" class="form-label ">Nombre</label>
              <input type="text" class="form-control" id="nombre" name="nombre" required />
            </div>
            <div class="mb-3">
              <label for="descripcion" class="form-label ">Descripción</label>
              <input type="text" class="form-control" id="detalle" name="detalle" required />
            </div>
            <div class="mb-3">
              <label for="dia" class="form-label ">Día de la Capacitación</label>
              <input type="date" class="form-control" id="dia" name="dia" required />
            </div>
            <div class="mb-3">
              <label for="hora" class="form-label ">Hora de la Capacitación</label>
              <input type="time" class="form-control" id="hora" name="hora" required />
            </div>
            <div class="mb-3">
              <label for="lugar" class="form-label ">Lugar de la Capacitación</label>
              <input type="text" class="form-control" id="lugar" name="lugar" required />
            </div>
            <div class="mb-3">
              <label for="duracion" class="form-label ">Duración de la Capacitación</label>
              <input type="time" class="form-control" id="duracion" name="duracion" required />
            </div>
            <div class="mb-3">
              <label for="cantidadAsistentes" class="form-label ">Cantidad de Asistentes</label>
              <input type="number" class="form-control" id="cantidadAsistentes" name="cantidadAsistentes" required />
            </div>
            <button type="submit" class="btn btn-primary" >Ingresar</button>
          </form>
        </div>
      </div>
      </div>
      </div>
    </main>
    <%@ include file="plantillas/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      crossorigin="anonymous"></script>
    <script>
      <%@ include file="js/script.js" %>
    </script>
  </body>
</html>
