<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Modifica utente</title>
    </head>
    <body>
        <form:form modelAttribute="utente_modify" action="/admin/gestione/utenti/conferma_modifica/${utente.id}" method="post">
            <h1>Modifica utente: ${utente.username}</h1>
            <br>
            <label for="username">Modifica username:</label>
            <form:input type="text" id="username" name="username" value="${utente.username}" path="username" />
            <br>
            <label for="email">Modifica email:</label>
            <form:input type="email" id="email" name="email" value="${utente.email}" path="email" />
            <br>
            <label for="data">Modifica data di nascita:</label>
            <form:input type="date" id="data" name="data" value="${utente.dataDiNascita}" path="dataDiNascita" />
            <button type="submit" class="btn btn-success">Modifica</button>
        </form:form>
    </body>
</html>