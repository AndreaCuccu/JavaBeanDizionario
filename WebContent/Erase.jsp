<html>
    <head>

        <title>Cancella contenuto da db</title>
    </head>
    <body>
        <jsp:useBean id="diz" scope="session" class="mieibeans.EraseBean"/>
        <form action="erase" method="POST">
            Parola:
            <input type="text" name="parola">
            <button type="submit" value="Submit"></button>
        </form>
        <a href="\WebContent">Indietro</a>
    </body>
</html>