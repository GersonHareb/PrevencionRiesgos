<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-expand-lg" id="sidebar">
  <div class="w-100">
    <button class="navbar-toggler ms-auto" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav nav-item-collection mb-md-5 w-100">
        <li class="nav-item mt-3 w-100" id="inicio-link">
          <a class="nav-link w-100 px-5" href="${pageContext.request.contextPath}/inicio">
            <i class="fas fa-home me-3"></i> Inicio
          </a>
        </li>
        <li class="nav-item mt-3 w-100" id="listarCapacitacion-link">
          <a class="nav-link w-100 px-5" href="${pageContext.request.contextPath}/listarCapacitacion">
            <i class="fas fa-list me-3"></i> Listado capacitacion
          </a>
        </li>
        <li class="nav-item mt-3 w-100" id="crearCapacitacion-link">
          <a class="nav-link w-100 px-5" href="${pageContext.request.contextPath}/crearCapacitacion">
            <i class="fas fa-plus me-3"></i> Crear capacitacion
          </a>
        </li>
        <li class="nav-item mt-3 w-100" id="contactos-link">
          <a class="nav-link w-100 px-5" href="${pageContext.request.contextPath}/contactos">
            <i class="fas fa-envelope me-3"></i> Contacto
          </a>
        </li>
        <li class="nav-item mt-3 w-100" id="crearUsuario-link">
          <a class="nav-link w-100 px-5" href="${pageContext.request.contextPath}/crearusuario">
            <i class="fas fa-user-plus me-3"></i> Crear usuario
          </a>
        </li>
        <li class="nav-item mt-3 w-100" id="listarUsuario-link">
          <a class="nav-link w-100 px-5 ${request.getRequestURI().contains('/listarusuario') ? 'active' : ''}" href="${pageContext.request.contextPath}/listarusuario">
            <i class="fas fa-users me-3"></i> Listar usuario
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Resto de tu código HTML -->






