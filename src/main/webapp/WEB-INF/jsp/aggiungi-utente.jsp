<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Aggiungi utente</title>
    </head>
    <body>
        <h1>Aggiungi un'utente</h1>
        <form:form modelAttribute="add_user_validator" action="/admin/gestione/utenti/aggiungi-utente" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="username">Username</label>
                    <form:input type="text" class="form-control" id="username" placeholder="Username" path="username" />
                </div>
                <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <form:input type="email" class="form-control" id="email" placeholder="Email" path="email" />
                </div>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <form:input type="password" class="form-control" id="password" placeholder="Password" path="password" />
            </div>
            <div class="form-group">
                <label for="data">Data di nascita</label>
                <form:input type="date" class="form-control" id="data" placeholder="Data di nascita" path="dataDiNascita" />
            </div>
            <div class="form-group">
                <label for="ruolo">Ruolo</label>
                <form:select id="ruolo" class="form-control" path="ruolo" >
                    <h5>Default = USER</h5>
                    <option selected>Scegli...</option>
                    <option>ADMIN</option>
                    <option>USER</option>
                </form:select>
            </div>
            <button type="submit" class="btn btn-primary">Aggiungi utente</button>
        </form:form>
    </body>
</html>