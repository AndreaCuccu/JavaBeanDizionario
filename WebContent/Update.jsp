<html>
<head><title>Modifica una parola al db</title></head>
<body>
    <jsp:useBean id="diz" scope="session" class="mieibeans.UpdateBean"/>
    <form action="Update" method="POST">
        Parola:
        <input type="text" name="parola">
        Significato:
        <input type="text" name="significato">
        <button type="submit" value="Submit"></button>
    </form>
    <a href="\WebContent">Indietro</a>
</body>
</html>