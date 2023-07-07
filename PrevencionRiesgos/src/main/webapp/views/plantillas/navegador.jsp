<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 

		<div class="datos-usuario">
		<div class="d-flex flex-row align-items-center">
			<img
      		src="${pageContext.request.contextPath}/views/img/logo.png"
      		alt="Logo de la empresa"
      		class="userPic mx-auto my-0"/>
          	<div class="d-flex flex-column">
          		<a
            	class="pb-0 ps-2"
            	aria-current="page"
            	href="${pageContext.request.contextPath}/inicio">
            		Hola de nuevo, <strong>${username}</strong>
          		</a>
          		<a class="pt-0 ps-2" href="#"><small>Editar perfil</small></a>
          	</div>

		</div>
		<div class="ms-sm-auto boton-cerrar-sesion">
			<button
        	class="btn btn-primary btn-sm shadow ms-3 "
        	aria-current="page"
        	onclick="cerrarSesion()">
        		Cerrar sesion
          </button>
		</div>

        </div>
