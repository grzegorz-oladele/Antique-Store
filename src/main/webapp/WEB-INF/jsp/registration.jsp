<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<main>
    <section class="form-registration">
        <form:form modelAttribute="user" method="post">
            <label for="username">Nazwa użytkownika</label>
            <form:input path="username" placeholder="Podaj nazwę użytkownika"/>
            <label for="password">Podaj hasło</label>
            <form:password path="password" placeholder="Podaj hasło"/>
            <label for="password2">Powtórz hasło</label>
            <input name="password2" id="password2" type="password" placeholder="Powtórz hasło">
            <label for="email">Podaj email</label>
            <form:input path="email" placeholder="Podaj email"/>
            <button type="submit">Zarejestruj</button>
        </form:form>
    </section>
</main>
<%@include file="footer.jsp" %>