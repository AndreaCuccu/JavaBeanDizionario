<html>
<head><title>Cerca Parole dentro il dizionario!</title></head>
<body>
    <jsp:useBean id="diz" scope="session" class="mieibeans.FindBean"/>
    <jsp:setProperty name="diz" property="parola" param="parola"/>
    la parola:
    <jsp:getProperty name="diz" property="parola"/>
    Vuol dire: 
    <jsp:getProperty name="diz" property="significato"/>
    <a href="\WebContent">Indietro</a>
</body>
</html>