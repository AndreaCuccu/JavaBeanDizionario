<html>
	<jsp:useBean id="Diz" class="mieibeans.Dizionario"/>
	<p> Ciao, Benvenuto! </p>
	<jsp:getProperty name="Diz" property="parola"/>
	
</html>
