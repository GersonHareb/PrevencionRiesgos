<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@
taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set
  var="imgPrefix"
  value="${empty pageContext.request.contextPath ? '' : pageContext.request.contextPath}"
/>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Capacitaciones | Login</title>
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
  </head>
  <body class="bg-secondary">
    <main>
      <div class="container-fluid ">
        <div class="row">
          <div
            class="col-12 col-md-6 col-lg-4 col-xl-3 bg-light p-5 d-flex flex-column align-items-center justify-content-center login-contenedor"
          >
            <img
              src="${pageContext.request.contextPath}/views/img/logo.png"
              alt="Logo de la empresa"
              class="logo mx-auto my-0"
            />
            <p class="text-center mb-0 text-secondary">Capacitaciones</p>
            <h2 class="text-center mb-0">Herrera</h2>
            <div class="col-10 col-md-12 mx-auto navigation-panel py-4">
              <form
                action="${pageContext.request.contextPath}/login"
                method="POST"
                class="input-login mx-auto"
              >
                <div class="form-group mb-3 text-secondary">
                  <label for="username">Nombre de usuario:</label>
                  <input
                    type="text"
                    id="username"
                    name="username"
                    class="form-control"
                    required
                  />
                </div>
                <div class="form-group mb-3 text-secondary">
                  <label for="password">Contraseña:</label>
                  <input
                    type="password"
                    id="password"
                    name="password"
                    class="form-control"
                    required
                  />
                </div>
                <div class="row form-group d-flex flex-row justify-content-center p-2">
                	<div class="form-check">
  						<input class="form-check-input mb-4" type="checkbox" id="rememberMe">
 						 <label class="form-check-label" for="rememberMe">
   						 Recuérdame
  						</label>
					</div>
                  <button type="submit" class="btn btn-primary btn-block mb-4 shadow">
                    Iniciar sesion
                  </button>
                </div>
              </form>
            
              <a
                href="#"
                class="btn btn-outline-primary btn-block mb-2 btn-google shadow-sm w-100 p-0"
              >
                <span class="socials">
                  <i class="fa fa-google col-2 h-100"></i>
                  <span class="col-10">Iniciar sesión con Google</span>
                </span>
              </a>

              <a
                href="#"
                class="btn btn-outline-primary btn-block mb-2 btn-twitter  shadow-sm w-100 p-0"
              >
                <span class="socials">
                  <i class="fa fa-twitter col-2 h-100 my-auto"></i>
                  <span class="col-10">Iniciar sesión con Twitter</span>
                </span>
              </a>

              <a
                href="#"
                class="btn btn-outline-primary btn-block mb-2 btn-facebook shadow-sm w-100 p-0"
              >
                <span class="socials">
                  <i class="col-2 fa fa-facebook col-2 h-100 p-auto"></i>
                  <span class="col-10">Iniciar sesión con Facebook</span>
                </span>
              </a>
              </div>
            <footer class="mt-2 text-center">
            <a href="#"><small>Olvidaste la contraseña?</small></a>
              <p class="text-secondary"><small>&copy; 2023 Gerson Herrera. Todos los derechos reservados.</small></p>
              
            </footer>
          </div>
          <div class="col-md-6 col-lg-8 col-xl-9 imagen-login"></div>
        </div>
      </div>
    </main>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
    <!-- ... -->
    <c:if test="${not empty errorMessage}">
      <!-- Modal -->
      <div
        class="modal fade"
        id="errorModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Error</h5>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">${errorMessage}</div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-secondary"
                data-bs-dismiss="modal"
              >
                Intentarlo nuevamente
              </button>
            </div>
          </div>
        </div>
      </div>

      <!-- Script para abrir el modal automáticamente -->
      <script>
        var errorModal = new bootstrap.Modal(
          document.getElementById("errorModal")
        );
        errorModal.show();
      </script>
    </c:if>
    <!-- ... -->
  </body>
</html>