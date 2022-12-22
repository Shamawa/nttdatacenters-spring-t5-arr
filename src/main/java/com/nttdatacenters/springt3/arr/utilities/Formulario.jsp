<!DOCTYPE html>
<html lang="es" xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="master">
<body>
<main layout:fragment="contenido">
    <div class="col-12">
        <h2>Alta Cliente</h2>
        <div th:classappend="'alert-' + (${clase != null} ? ${clase} : info)" th:if="${mensaje != null}"
             th:text="${mensaje}"
             class="alert">
        </div>
        <form th:object="${cliente}" th:action="@{/cliente/agregar_cliente}" method="post">
            <div class="form-group">
                <label for="nombre">Nombre del Cliente</label>
                <input autocomplete="off" autofocus th:field="*{nombre}" id="nombre"
                       placeholder="Escribe el nombre del cliente" type="text"
                       class="form-control" th:classappend="${#fields.hasErrors('nombre')} ? 'is-invalid' : ''">
                <div class="invalid-feedback" th:errors="*{nombre}"></div>
            </div>
            <button class="btn btn-success" type="submit">Guardar</button>
            &nbsp; <button class="btn btn-warning" type="submit" th:href="@{/clientes/mostrar}"> Ver todos</button>
        </form>
    </div>
</main>
</body>
</html>